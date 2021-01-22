/**
 * 
 */
package nonprofit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nonprofit.model.Address;
import nonprofit.model.BusinessInfo;
import nonprofit.model.ExemptionInfo;
import nonprofit.model.ListItem;
import nonprofit.service.CaptchaService;
import nonprofit.service.NonProfitService;
import nonprofit.service.PropertiesService;

/**
 * @author 410284
 *
 */
@Controller
@SessionAttributes({ "businessInfo", "exemptionInfo"})
public class NonProfitController {

	@Autowired
	NonProfitService nonProfitService;
	
	@Autowired
	CaptchaService captchaService;
	
	@Autowired
	PropertiesService propertiesService;

	private static final Logger logger = LoggerFactory.getLogger(NonProfitController.class);
	
	private static final String ADDRESS_VALIDATION = "AddressValidation";
	private static final String CERTIFICATE = "Certificate";
	private static final String CONFIRMATION = "Confirmation";
	private static final String ERROR_PROMPT = "Review and correct errors encountered below.";
	private static final String EXCEPTION_PAGE = "ExceptionPage";
	private static final String EXEMPTION_FORM = "ExemptionForm";	
	private static final String REGISTRATION_FORM = "RegistrationForm";
	

	@ModelAttribute("businessInfo")
	public BusinessInfo newBusinessInfo() {
		return new BusinessInfo();
	}

	@ModelAttribute("exemptionInfo")
	public ExemptionInfo newExemptionInfo() {
		return new ExemptionInfo();
	}
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String showIntro(Model model) {
		return "Introduction";
	}
	
	@RequestMapping(value = { "/exemption" }, method = RequestMethod.GET)
	public String showExemptionForm(Model model) {
		if (model.containsAttribute("errors")) {
			model.addAttribute("org.springframework.validation.BindingResult.exemptionInfo",
					model.asMap().get("errors"));
		}
		try {
			List<ListItem> exemptionTypeList = nonProfitService.getExemptionTypeList();
			for(int i=0; i < exemptionTypeList.size(); i++) {
				if(exemptionTypeList.get(i).getValue().equals("28")) {
					exemptionTypeList.remove(i);
					break;
				}
			}

			model.addAttribute("exemptionType", exemptionTypeList);
			model.addAttribute("siteKey", propertiesService.getProperties().getProperty("recaptcha.sitekey"));

			return EXEMPTION_FORM;
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("Database error occurred when loading exemption form");
			logger.error(e.getMessage());
			return EXCEPTION_PAGE;
		}
	}

	@RequestMapping(value = { "/exemption" }, method = RequestMethod.POST)
	public String postExemptionForm(@Validated @ModelAttribute("exemptionInfo") ExemptionInfo exemptionInfo,
			BindingResult result, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		try {
			captchaService.processResponse( request.getParameter("g-recaptcha-response"), request.getRemoteAddr());
		} catch (Exception captchaEx) {
			captchaEx.printStackTrace();
			logger.error(captchaEx.getMessage());
			result.reject("fieldErrors", "Captcha failed validation.  Please try again.");
			redirectAttributes.addFlashAttribute("errors", result);
			return "redirect:/exemption";
		}
		
		if (result.hasErrors()) {
			result.reject("fieldErrors", "Review and correct errors encountered below.");
			redirectAttributes.addFlashAttribute("errors", result);
			return "redirect:/exemption";
		} else if (exemptionInfo.getFundClass().isEmpty()) {
			String eappUrl = propertiesService.getProperties().getProperty("eapp.url");
			return "redirect:" + eappUrl + exemptionInfo.getExemptionId();
		} else {
			List<String> fileNameList = new ArrayList<String>();
			//Check required documents
			if(!nonProfitService.processFile(exemptionInfo.getFile()[0], result, redirectAttributes)) {
				return "redirect:/exemption";
			} else {
				fileNameList.add(exemptionInfo.getFile()[0].getOriginalFilename());
			}
			//Check optional documents
			if(exemptionInfo.isNameChanged()) {
				for(int i = 1; i < 3; i++) {
					if(!nonProfitService.processFile(exemptionInfo.getFile()[i], result, redirectAttributes)) {
						return "redirect:/exemption";
					} else {
						fileNameList.add(exemptionInfo.getFile()[i].getOriginalFilename());
					}
				}
			}
			exemptionInfo.setFileNames(fileNameList);
			return "redirect:/application";
		}
	}

	@RequestMapping(value = { "/application" }, method = RequestMethod.GET)
	public String showApplication(Model model) {
		if (model.containsAttribute("errors")) {
			model.addAttribute("org.springframework.validation.BindingResult.businessInfo",
					model.asMap().get("errors"));
		}
		// prevent skipping pages
		ExemptionInfo ex = (ExemptionInfo) model.asMap().get("exemptionInfo");
		if(null == ex.getExemptionId()) {
			return "redirect:/exemption";
		}
		try {
			List<ListItem> stateList = nonProfitService.getStateList();
			model.addAttribute("stateList", stateList.subList(1, stateList.size()));

			List<ListItem> unitType = nonProfitService.getUnitTypeList();			
			Collections.sort(unitType);			
			
			List<ListItem> unitTypeMailing = new ArrayList<ListItem>(unitType);			
			model.addAttribute("unitTypeMailing", unitTypeMailing.subList(1, unitTypeMailing.size()));

			for(int i=0; i < unitType.size(); i++) {
				if(unitType.get(i).getValue().equals("POBX")) {
					unitType.remove(i);
					break;
				}
			}

			model.addAttribute("unitType", unitType.subList(1, unitType.size()));

			List<ListItem> streetType = nonProfitService.getStreetTypeList();
			Collections.sort(streetType);
			model.addAttribute("streetType", streetType.subList(1, streetType.size()));
			return REGISTRATION_FORM;
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error("Database error occurred when loading application form");
			logger.error(e.getMessage());
			return EXCEPTION_PAGE;
		}
	}

	@RequestMapping(value = { "/application" }, method = RequestMethod.POST)
	public String postApplication(Model model, @Validated @ModelAttribute("businessInfo") BusinessInfo businessInfo,
			BindingResult result, RedirectAttributes redirectAttributes) {
		try {
			if (result.hasErrors()) {
				result.reject("fieldErrors", ERROR_PROMPT);
				redirectAttributes.addFlashAttribute("errors", result);
				return "redirect:/application";
			} else {
				return "redirect:/address-validation";
			}
		} catch (Exception e) {
			e.printStackTrace();	
			logger.error("Error occured when redirecting to confirmation screen");
			logger.error(e.getMessage());
			return EXCEPTION_PAGE;
		}
	}

	@RequestMapping(value = { "/address-validation" }, method = RequestMethod.GET)
	public String addressValidation(Model model, BusinessInfo businessInfo) {
		model.addAttribute("address", new Address());
		if(StringUtils.isEmpty(businessInfo.getBusinessDescription())) {
			return "redirect:/exemption";
		}
		if(!StringUtils.hasText(businessInfo.getUnitType()) || !StringUtils.hasText(businessInfo.getUnitNumber())) {
			businessInfo.setUnitType("");
			businessInfo.setUnitNumber("");			
		}
		if(!StringUtils.hasText(businessInfo.getUnitTypeMailing()) || !StringUtils.hasText(businessInfo.getUnitNumberMailing())) {
			businessInfo.setUnitTypeMailing("");
			businessInfo.setUnitNumberMailing("");
		}
		try {
			List<Address> addressMatches = nonProfitService.validateAddress(businessInfo.getStreetNumber(), 
					businessInfo.getStreetName(), 
					businessInfo.getCity(), 
					businessInfo.getState(), 
					businessInfo.getZipCode(), 
					businessInfo.getDirectionalPrefix(),
					businessInfo.getDirectionalSuffix(), 
					businessInfo.getStreetType(),
					businessInfo.getUnitType(),
					businessInfo.getUnitNumber());
			model.addAttribute("addressMatches", addressMatches);
			if(!businessInfo.isOneAddress()) {
				List<Address> addressMatchesMailing = nonProfitService.validateAddress(businessInfo.getStreetNumberMailing(), 
						businessInfo.getStreetNameMailing(), 
						businessInfo.getCityMailing(), 
						businessInfo.getStateMailing(), 
						businessInfo.getZipCodeMailing(), 
						businessInfo.getDirectionalPrefixMailing(),
						businessInfo.getDirectionalSuffixMailing(), 
						businessInfo.getStreetTypeMailing(),
						businessInfo.getUnitTypeMailing(),
						businessInfo.getUnitNumberMailing());
				model.addAttribute("addressMatchesMailing", addressMatchesMailing);
			}
		} catch (Exception e) {
			e.printStackTrace();	
			logger.error("Error occured on address validation GET");
			logger.error(e.getMessage());
			return "redirect:/confirmation";
		}	
		return ADDRESS_VALIDATION;
	}

	@RequestMapping(value = { "/address-validation" }, method = RequestMethod.POST)
	public String confirmAddress(@ModelAttribute("address") Address address, BindingResult result, BusinessInfo businessInfo) {
		try {
			nonProfitService.parseAddress(businessInfo, address);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			logger.error("Error occured on address validation POST");
			logger.error(e.getMessage());
		}
		return "redirect:/confirmation";
	}

	@RequestMapping(value = { "/confirmation" }, method = RequestMethod.GET)
	public String showConfirmation(Model model) {
		BusinessInfo b = (BusinessInfo) model.asMap().get("businessInfo");
		if(StringUtils.isEmpty(b.getBusinessDescription())) { 
			return "redirect:/exemption"; 
		}

		try {
			return CONFIRMATION;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error occured when loading confirmation screen");
			logger.error(e.getMessage());
			return EXCEPTION_PAGE;
		}		
	}

	@RequestMapping(value = { "/confirmation" }, method = RequestMethod.POST)
	public String confirmRegistration(@ModelAttribute("businessInfo") BusinessInfo businessInfo, BindingResult result) {
		if (result.hasErrors()) {
			return EXCEPTION_PAGE;
		}
		return CONFIRMATION;
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String redirectFromRegister() {
		return "redirect:/exemption";
	}

	// POST-GET-REDIRECT prevents duplicate submissions if user refreshes
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute("businessInfo") BusinessInfo businessInfo,
			@ModelAttribute("exemptionInfo") ExemptionInfo exemptionInfo, HttpServletRequest request) {
		try {
			nonProfitService.register(businessInfo, exemptionInfo, request.getHeader("X-FORWARDED-FOR"));			 
			return "redirect:/certificate";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Database error occurred when processing registration data");
			logger.error(e.getMessage());
			return EXCEPTION_PAGE;
		}
	}

	@RequestMapping(value = { "/certificate" }, method = RequestMethod.GET)
	public String showCertificate(Model model, SessionStatus session) {
		BusinessInfo b = (BusinessInfo) model.asMap().get("businessInfo");
		if(StringUtils.isEmpty(b.getBusinessDescription())) { 
			return "redirect:/exemption"; 
		}
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
		model.addAttribute("currentDate", formatter.format(calendar.getTime()));
		calendar.add(Calendar.MONTH, 6);
		model.addAttribute("expirationDate", formatter.format(calendar.getTime()));		
		session.setComplete();
		return CERTIFICATE;
	}
}
