package nonprofit.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nonprofit.dao.NonProfitDao;
import nonprofit.model.Address;
import nonprofit.model.BusinessInfo;
import nonprofit.model.ExemptionInfo;
import nonprofit.model.ListItem;

@Service
public class NonProfitServiceImpl implements NonProfitService {

	@Autowired
	NonProfitDao nonProfitDao;

	@Autowired
	PropertiesService propertiesService;
	
	private static final Logger logger = LoggerFactory.getLogger(NonProfitServiceImpl.class);

	private static final String DATE_FORMAT = "MM-dd-yyyy";	
	private static final String ERROR_PROMPT = "Review and correct errors encountered below.";
	private static final String REQUIRE_FILE = "One or more required documents are missing.";
	private static final String REJECT_FILE = "File type must be PDF or image.";
	private static final String REJECT_SIZE = "The size of one or more files exceeds 10MB.";
	@Override
	public boolean processFile(MultipartFile file, BindingResult result, RedirectAttributes redirectAttributes) {
		// TODO Auto-generated method stub
		long max = 10000000L;
		if(!file.isEmpty()) {
			if(!file.getContentType().contains("pdf") && !file.getContentType().contains("png") && !file.getContentType().contains("jpeg")) {
				result.reject("fieldErrors", ERROR_PROMPT);
				result.rejectValue("file", "rejectFile", REJECT_FILE);
				redirectAttributes.addFlashAttribute("errors", result);
				return false;
			} else if (file.getSize() > max) {
				result.reject("fieldErrors", ERROR_PROMPT);
				result.rejectValue("file", "rejectFile", REJECT_SIZE);
				redirectAttributes.addFlashAttribute("errors", result);
				return false;
			}
		}
		if(file.isEmpty()) {
			result.reject("fieldErrors", ERROR_PROMPT);
			result.rejectValue("file", "requireFile", REQUIRE_FILE);
			redirectAttributes.addFlashAttribute("errors", result);
			return false;
		}
		return true;
	}
	
	@Override
	public List<Address> validateAddress(String streetNumber, String streetName, String city, String state, String zip, String dPrefix, String dSuffix, String streetType, String unitType, String unitNumber) throws IOException {
		/*InputStream input = new FileInputStream(PROPERTIES_PATH);
		Properties prop = new Properties();
		prop.load(input);*/
		RestTemplate rest = new RestTemplate(getClientHttpRequestFactory());
		//Required fields
		StringBuilder fullAddress = new StringBuilder("<ITSFullAddrData>")
				.append("<streetNumber>"+streetNumber+"</streetNumber>")
				.append("<streetName>"+streetName+"</streetName>")
				.append("<city>"+city+"</city>")
				.append("<state>"+state+"</state>")
				.append("<zip>"+zip+"</zip>");
		//Optional fields
		if(StringUtils.hasText(dPrefix))	{
			fullAddress.append("<streetPrefixDir>"+dPrefix+"</streetPrefixDir>");
		}
		if(StringUtils.hasText(dSuffix))	{
			fullAddress.append("<streetSuffixDir>"+dSuffix+"</streetSuffixDir>");
		}
		if(StringUtils.hasText(streetType))	{
			fullAddress.append("<streetNameSuffix>"+streetType+"</streetNameSuffix>");
		}
		if(StringUtils.hasText(unitType))	{
			fullAddress.append("<unitType>"+unitType+"</unitType>");
		}
		if(StringUtils.hasText(unitNumber))	{
			fullAddress.append("<unitNumber>"+unitNumber+"</unitNumber>");
		}
		fullAddress.append("</ITSFullAddrData>");

		String addressMatchUrl = propertiesService.getProperties().getProperty("address.match.url")+fullAddress.toString();

		ResponseEntity<String> response = rest.getForEntity(addressMatchUrl, String.class);

		List<Address> list = new ArrayList<Address>();

		if(null != response.getBody()) {
			JSONArray ja = new JSONArray(response.getBody());
			for(int i = 0; i < ja.length(); i++) {
				JSONObject obj = ja.getJSONObject(i);
				Address addr = new Address();
				addr.setStdAddress(obj.getString("stdAddress"));
				addr.setCityNew(obj.getString("city"));
				addr.setStateNew(obj.getString("state"));
				addr.setZip(obj.getString("zip"));
				addr.setZip4(obj.getString("zip4"));
				list.add(addr);
			}
		}		

		return list;
	}
	
	@Override
	public void parseAddress(BusinessInfo businessInfo, Address address) throws IOException {
		/*InputStream input = new FileInputStream(PROPERTIES_PATH);
		Properties prop = new Properties();
		prop.load(input);*/
		String addressParseUrlBase =  propertiesService.getProperties().getProperty("address.parse.url");
		if(StringUtils.hasText(address.getStdAddress())) {
			String addressParseUrl = addressParseUrlBase
					+"?addressLine1="+address.getStdAddress()
					+"&city="+address.getCityNew()
					+"&state="+address.getStateNew()
					+"&postalCode="+address.getZip();

			RestTemplate rest = new RestTemplate(getClientHttpRequestFactory());

			ResponseEntity<String> response = rest.getForEntity(addressParseUrl, String.class);

			JSONObject obj = new JSONObject(response.getBody());

			businessInfo.setStreetNumber(obj.getString("streetNumber").toUpperCase());
			businessInfo.setDirectionalPrefix(obj.getString("streetPrefixDir").toUpperCase());
			businessInfo.setStreetName(obj.getString("streetName").toUpperCase());
			businessInfo.setStreetType(obj.getString("streetNameSuffix").toUpperCase());
			businessInfo.setDirectionalSuffix(obj.getString("streetSuffixDir").toUpperCase());
			businessInfo.setCity(obj.getString("city").toUpperCase());
			businessInfo.setState(obj.getString("state").toUpperCase());
			businessInfo.setZipCode(obj.getString("zip").toUpperCase());

			if(businessInfo.isOneAddress()) {
				businessInfo.setStreetNumberMailing(businessInfo.getStreetNumber());
				businessInfo.setDirectionalPrefixMailing(businessInfo.getDirectionalPrefix());
				businessInfo.setStreetNameMailing(businessInfo.getStreetName());
				businessInfo.setStreetTypeMailing(businessInfo.getStreetType());
				businessInfo.setDirectionalSuffixMailing(businessInfo.getDirectionalSuffix());
				businessInfo.setCityMailing(businessInfo.getCity());
				businessInfo.setStateMailing(businessInfo.getState());
				businessInfo.setZipCodeMailing(businessInfo.getZipCode());
			}
		}

		if(StringUtils.hasText(address.getStdAddressMailing())) {
			String addressParseUrl = addressParseUrlBase
					+"?addressLine1="+address.getStdAddressMailing()
					+"&city="+address.getCityMailingNew()
					+"&state="+address.getFirmNameMailing()
					+"&postalCode="+address.getZipMailing();

			RestTemplate rest = new RestTemplate(getClientHttpRequestFactory());

			ResponseEntity<String> response = rest.getForEntity(addressParseUrl, String.class);

			JSONObject obj = new JSONObject(response.getBody());

			businessInfo.setStreetNumberMailing(obj.getString("streetNumber").toUpperCase());
			businessInfo.setDirectionalPrefixMailing(obj.getString("streetPrefixDir").toUpperCase());
			businessInfo.setStreetNameMailing(obj.getString("streetName").toUpperCase());
			businessInfo.setStreetTypeMailing(obj.getString("streetNameSuffix").toUpperCase());
			businessInfo.setDirectionalSuffixMailing(obj.getString("streetSuffixDir").toUpperCase());
			businessInfo.setCityMailing(obj.getString("city").toUpperCase());
			businessInfo.setStateMailing(obj.getString("state").toUpperCase());
			businessInfo.setZipCodeMailing(obj.getString("zip").toUpperCase());
		}
	}

	//@Transactional(rollbackFor = SQLException.class)
	@Override
	public void register(BusinessInfo businessInfo, ExemptionInfo exemptionInfo, String ip) throws IllegalStateException, IOException {		

		BigDecimal webFilingId = generateWebFilingId();		

		businessInfo.setWebFilingId(webFilingId);

		//build phone numbers
		String phoneNumber = businessInfo.getPhoneNumberContact().replace("(", "").replace(")", "");		
		businessInfo.setPhoneNumberContact(phoneNumber);
		businessInfo.setPhoneNumberFiler(phoneNumber);
		businessInfo.setPhoneExtFiler(businessInfo.getPhoneExtContact());
		businessInfo.setFirstNameFiler(businessInfo.getFirstNameContact());
		businessInfo.setLastNameFiler(businessInfo.getLastNameContact());
		businessInfo.setEmailAddressFiler(businessInfo.getEmailAddressContact());

		//format business date
		//businessInfo.setBusinessStartDate(businessInfo.getBusinessStartDate().replaceAll("-", "/"));

		//generate registration numbers
		String registrationNumber = generateRegistrationNumber();
		businessInfo.setRegistrationNumber(registrationNumber);
		businessInfo.setWebConfirmationNumber(generateWebConfirmationNumber(businessInfo.getWebFilingId().toString()));

		nonProfitDao.register(businessInfo, exemptionInfo);

		/*InputStream input = new FileInputStream(PROPERTIES_PATH);
		Properties prop = new Properties();
		prop.load(input);*/
		String directory =  propertiesService.getProperties().getProperty("storage.path");

		MultipartFile[] files = exemptionInfo.getFile();
		StringBuilder fileName = null;

		Path path = Paths.get(directory+getDate(DATE_FORMAT));
		if(!Files.exists(path) && (!files[0].isEmpty() || !files[1].isEmpty())) {
			Files.createDirectories(path);
		}

		if(!files[0].isEmpty()) {
			fileName = new StringBuilder("NP_")
					.append(registrationNumber)
					.append("_EXEMPTION-LETTER.")
					.append(FilenameUtils.getExtension(files[0].getOriginalFilename()));
			files[0].transferTo(new	File(path.toString() + "/" + fileName.toString()));
			logger.info(fileName + " uploaded by user at " + ip);
		}

		if(exemptionInfo.isNameChanged()) {
			if(!files[1].isEmpty()) {
				fileName = new StringBuilder("NP_")
						.append(registrationNumber)
						.append("_ORIGINAL-ARTICLES.")
						.append(FilenameUtils.getExtension(files[1].getOriginalFilename()));
				files[1].transferTo(new	File(path.toString() + "/" + fileName.toString()));
				logger.info(fileName + " uploaded by user at " + ip);
			}	

			if(!files[2].isEmpty()) {
				fileName = new StringBuilder("NP_")
						.append(registrationNumber)
						.append("_AMENDED-ARTICLES.")
						.append(FilenameUtils.getExtension(files[2].getOriginalFilename()));
				files[2].transferTo(new	File(path.toString() + "/" + fileName.toString()));
				logger.info(fileName + " uploaded by user at " + ip);
			}	
		}
	}
	
	@Override
	@Cacheable("stateList")
	public List<ListItem> getStateList() {
		return nonProfitDao.getStateList();
	}

	@Override
	@Cacheable("unitType")
	public List<ListItem> getUnitTypeList() {
		return nonProfitDao.getUnitTypeList();
	}

	@Override
	@Cacheable("streetType")
	public List<ListItem> getStreetTypeList() {
		return nonProfitDao.getStreetTypeList();
	}
	
	@Override
	@Cacheable("exemptionType")
	public List<ListItem> getExemptionTypeList() {
		return nonProfitDao.getExemptionTypeList();
	}

	@Override
	public BigDecimal generateWebFilingId() {
		return nonProfitDao.generateWebFilingId();
	}

	@Override
	public String generateRegistrationNumber() {
		return nonProfitDao.generateRegistrationNumber();
	}

	@Override
	public String generateWebConfirmationNumber(String webFilingId) {	
		return "R"+webFilingId+getDate("MMddYYYY");
	}

	@Override
	public int registerFundClass(BigDecimal webFilingId, String fundClass, String taxPeriod) {
		return nonProfitDao.registerFundClass(webFilingId, fundClass, taxPeriod);

	}
	
	private String getDate(String format) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(format);		
		return formatter.format(calendar.getTime());
	}

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
	    int timeout = 5000;
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
	      = new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(timeout);
	    return clientHttpRequestFactory;
	}
}
