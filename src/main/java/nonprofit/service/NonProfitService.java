package nonprofit.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nonprofit.model.Address;
import nonprofit.model.BusinessInfo;
import nonprofit.model.ExemptionInfo;
import nonprofit.model.ListItem;

public interface NonProfitService {

	public void register(BusinessInfo businessInfo, ExemptionInfo exemptionInfo, String string) throws IllegalStateException, IOException;

	public List<ListItem> getStateList();

	public List<ListItem> getUnitTypeList();

	public List<ListItem> getStreetTypeList();

	public List<ListItem> getExemptionTypeList();

	public BigDecimal generateWebFilingId();

	public String generateRegistrationNumber();

	public String generateWebConfirmationNumber(String webFilingId);

	public int registerFundClass(BigDecimal webFilingId, String fundClass, String taxPeriod);

	public List<Address> validateAddress(String streetNumber, String streetName, String city, String state, String zip, String dPrefix, String dSuffix, String streetType, String unitType, String unitNumber) throws IOException;

	public void parseAddress(BusinessInfo businessInfo, Address address) throws IOException;

	public boolean processFile(MultipartFile multipartFile, BindingResult result, RedirectAttributes redirectAttributes);
}
