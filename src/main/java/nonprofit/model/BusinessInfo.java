/**
 * 
 */
package nonprofit.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
//import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
/**
 * @author 410284
 * THE JBOSS SERVER RUNS ON EAP7.1 WHICH SUPPORTS UP TO JAVA 7 EE.
 * Unfortunately it only supports Hibernate validator versions of @NotBlank and @Email, which is deprecated, otherwise we would use the javax validator.
 * We will leave it until otherwise.
 */
public class BusinessInfo {
	private BigDecimal webFilingId;
	private String registrationNumber;
	private String webConfirmationNumber;
	
	@NotBlank
	@Size(min=1, max=60)
	private String businessDescription;	
	@NotBlank
	@Size(min=1, max=84)
	private String businessLegalName;
	@Size(min=0, max=56)
	private String dbaName;
	//@DateTimeFormat(iso=ISO.DATE)
	private String businessStartDate;
	@Pattern(regexp="^(COR|LLC|PAR|SPR|TST)", message="Invalid value")
	private String businessType;
	@Size(min=0, max=15)
	private String sellersPermitNumber;
	@NotBlank
	@Pattern(regexp="^[0-9]{1,10}$", message="Invalid value")
	private String streetNumber;
	@Size(min=0, max=5)
	private String streetNumberFraction;
	@Size(min=0, max=2)
	private String directionalPrefix;
	@NotBlank
	@Size(min=1, max=45)
	private String streetName;
	@Size(min=0, max=2)
	private String directionalSuffix;
	@Size(min=0, max=20)
	private String streetType;
	@Size(min=0, max=20)
	private String unitType;
	@Size(min=0, max=10)
	private String unitNumber;
	@NotBlank
	@Size(min=1, max=25)
	private String city;
	@Pattern(regexp="^[a-zA-Z]{2}$", message="Invalid value")
	private String state;
	@NotBlank
	@Pattern(regexp="^[0-9]{5}$", message="Invalid value")
	private String zipCode;
	@Size(min=0, max=28)
	private String careOf;
	@Pattern(regexp="^(Y|N)", message="Invalid value")
	private String locationType;
	private boolean oneAddress;
	@Pattern(regexp="^[0-9]{1,10}$", message="Invalid value")
	private String streetNumberMailing;
	@Size(min=0, max=5)
	private String streetNumberFractionMailing;
	@Size(min=0, max=2)
	private String directionalPrefixMailing;
	@NotBlank
	@Size(min=1, max=45)
	private String streetNameMailing; 
	@Size(min=0, max=2)
	private String directionalSuffixMailing;
	@Size(min=0, max=20)
	private String streetTypeMailing;
	@Size(min=0, max=20)
	private String unitTypeMailing;
	@Size(min=0, max=10)
	private String unitNumberMailing;
	@NotBlank
	@Size(min=1, max=25)
	private String cityMailing;
	@Pattern(regexp="^[a-zA-Z]{2}$", message="Invalid value")
	private String stateMailing;
	@NotBlank
	@Pattern(regexp="^[0-9]{5}$", message="Invalid value")
	private String zipCodeMailing;
	@Size(min=0, max=28)
	private String careOfMailing;
	@Pattern(regexp="^(Y|N)", message="Invalid value")
	private String locationTypeMailing;
	@NotBlank
	@Size(min=1, max=30)
	private String firstNameContact;
	@NotBlank
	@Size(min=1, max=30)
	private String lastNameContact;
	@Size(min=0, max=20)
	private String titleContact;	
	@NotBlank
	@Pattern(regexp="^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$", message="Invalid value for phone number")
	private String phoneNumberContact;
	@Pattern(regexp="^[0-9]{0,4}$", message="Invalid value for extension")
	private String phoneExtContact;	
	@NotBlank
	@Email
	private String emailAddressContact;
	private String webAddress;
	
	private String firstNameFiler;
	private String lastNameFiler;
	private String titleFiler;
	private String phoneNumberFiler;
	private String phoneExtFiler;	
	private String emailAddressFiler;	
		
	/**
	 * 
	 */
	public BusinessInfo() {
		this.state = "CA";
		this.stateMailing = "CA";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");		
		this.businessStartDate = formatter.format(calendar.getTime());
	}
	
	/**
	 * @return the webFilingId
	 */
	public BigDecimal getWebFilingId() {
		return webFilingId;
	}
	/**
	 * @param webFilingId the webFilingId to set
	 */
	public void setWebFilingId(BigDecimal webFilingId) {
		this.webFilingId = webFilingId;
	}
	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	/**
	 * @return the webConfirmationNumber
	 */
	public String getWebConfirmationNumber() {
		return webConfirmationNumber;
	}
	/**
	 * @param webConfirmationNumber the webConfirmationNumber to set
	 */
	public void setWebConfirmationNumber(String webConfirmationNumber) {
		this.webConfirmationNumber = webConfirmationNumber;
	}
	/**
	 * @return the businessDescription
	 */
	public String getBusinessDescription() {
		return businessDescription;
	}
	/**
	 * @param businessDescription the businessDescription to set
	 */
	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}
	/**
	 * @return the legalBusinessName
	 */
	public String getBusinessLegalName() {
		return businessLegalName;
	}
	/**
	 * @param legalBusinessName the legalBusinessName to set
	 */
	public void setBusinessLegalName(String legalBusinessName) {
		this.businessLegalName = legalBusinessName;
	}
	/**
	 * @return the dbaName
	 */
	public String getDbaName() {
		return dbaName;
	}
	/**
	 * @param dbaName the dbaName to set
	 */
	public void setDbaName(String dbaName) {
		this.dbaName = dbaName;
	}
	/**
	 * @return the businessStartDate
	 */
	public String getBusinessStartDate() {
		return businessStartDate;
	}
	/**
	 * @param businessStartDate the businessStartDate to set
	 */
	public void setBusinessStartDate(String businessStartDate) {
		this.businessStartDate = businessStartDate;
	}
	/**
	 * @return the businessType
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * @param businessType the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	/**
	 * @return the sellerPermitNumber
	 */
	public String getSellersPermitNumber() {
		return sellersPermitNumber;
	}
	/**
	 * @param sellerPermitNumber the sellerPermitNumber to set
	 */
	public void setSellersPermitNumber(String sellerPermitNumber) {
		this.sellersPermitNumber = sellerPermitNumber;
	}
	/**
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}
	/**
	 * @param streetNumber the streetNumber to set
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	/**
	 * @return the streetNumberFraction
	 */
	public String getStreetNumberFraction() {
		return streetNumberFraction;
	}
	/**
	 * @param streetNumberFraction the streetNumberFraction to set
	 */
	public void setStreetNumberFraction(String streetNumberFraction) {
		this.streetNumberFraction = streetNumberFraction;
	}
	/**
	 * @return the directionalPrefix
	 */
	public String getDirectionalPrefix() {
		return directionalPrefix;
	}
	/**
	 * @param directionalPrefix the directionalPrefix to set
	 */
	public void setDirectionalPrefix(String directionalPrefix) {
		this.directionalPrefix = directionalPrefix;
	}
	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}
	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	/**
	 * @return the directionalSuffix
	 */
	public String getDirectionalSuffix() {
		return directionalSuffix;
	}
	/**
	 * @param directionalSuffix the directionalSuffix to set
	 */
	public void setDirectionalSuffix(String directionalSuffix) {
		this.directionalSuffix = directionalSuffix;
	}
	/**
	 * @return the streetType
	 */
	public String getStreetType() {
		return streetType;
	}
	/**
	 * @param streetType the streetType to set
	 */
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}
	/**
	 * @return the unitType
	 */
	public String getUnitType() {
		return unitType;
	}
	/**
	 * @param unitType the unitType to set
	 */
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	/**
	 * @return the unitNumber
	 */
	public String getUnitNumber() {
		return unitNumber;
	}
	/**
	 * @param unitNumber the unitNumber to set
	 */
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the careOf
	 */
	public String getCareOf() {
		return careOf;
	}
	/**
	 * @param careOf the careOf to set
	 */
	public void setCareOf(String careOf) {
		this.careOf = careOf;
	}
	/**
	 * @return the locationType
	 */
	public String getLocationType() {
		return locationType;
	}
	/**
	 * @param locationType the locationType to set
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	/**
	 * @return the oneAddress
	 */
	public boolean isOneAddress() {
		return oneAddress;
	}

	/**
	 * @param oneAddress the oneAddress to set
	 */
	public void setOneAddress(boolean oneAddress) {
		this.oneAddress = oneAddress;
	}

	/**
	 * @return the streetNumberMailing
	 */
	public String getStreetNumberMailing() {
		return streetNumberMailing;
	}
	/**
	 * @param streetNumberMailing the streetNumberMailing to set
	 */
	public void setStreetNumberMailing(String streetNumberMailing) {
		this.streetNumberMailing = streetNumberMailing;
	}
	/**
	 * @return the streetNumberFractionMailing
	 */
	public String getStreetNumberFractionMailing() {
		return streetNumberFractionMailing;
	}
	/**
	 * @param streetNumberFractionMailing the streetNumberFractionMailing to set
	 */
	public void setStreetNumberFractionMailing(String streetNumberFractionMailing) {
		this.streetNumberFractionMailing = streetNumberFractionMailing;
	}
	/**
	 * @return the directionalPrefixMailing
	 */
	public String getDirectionalPrefixMailing() {
		return directionalPrefixMailing;
	}
	/**
	 * @param directionalPrefixMailing the directionalPrefixMailing to set
	 */
	public void setDirectionalPrefixMailing(String directionalPrefixMailing) {
		this.directionalPrefixMailing = directionalPrefixMailing;
	}
	/**
	 * @return the streetNameMailing
	 */
	public String getStreetNameMailing() {
		return streetNameMailing;
	}
	/**
	 * @param streetNameMailing the streetNameMailing to set
	 */
	public void setStreetNameMailing(String streetNameMailing) {
		this.streetNameMailing = streetNameMailing;
	}
	/**
	 * @return the directionalSuffixMailing
	 */
	public String getDirectionalSuffixMailing() {
		return directionalSuffixMailing;
	}
	/**
	 * @param directionalSuffixMailing the directionalSuffixMailing to set
	 */
	public void setDirectionalSuffixMailing(String directionalSuffixMailing) {
		this.directionalSuffixMailing = directionalSuffixMailing;
	}
	/**
	 * @return the streetTypeMailing
	 */
	public String getStreetTypeMailing() {
		return streetTypeMailing;
	}
	/**
	 * @param streetTypeMailing the streetTypeMailing to set
	 */
	public void setStreetTypeMailing(String streetTypeMailing) {
		this.streetTypeMailing = streetTypeMailing;
	}
	/**
	 * @return the unitTypeMailing
	 */
	public String getUnitTypeMailing() {
		return unitTypeMailing;
	}
	/**
	 * @param unitTypeMailing the unitTypeMailing to set
	 */
	public void setUnitTypeMailing(String unitTypeMailing) {
		this.unitTypeMailing = unitTypeMailing;
	}
	/**
	 * @return the unitNumberMailing
	 */
	public String getUnitNumberMailing() {
		return unitNumberMailing;
	}
	/**
	 * @param unitNumberMailing the unitNumberMailing to set
	 */
	public void setUnitNumberMailing(String unitNumberMailing) {
		this.unitNumberMailing = unitNumberMailing;
	}
	/**
	 * @return the cityMailing
	 */
	public String getCityMailing() {
		return cityMailing;
	}
	/**
	 * @param cityMailing the cityMailing to set
	 */
	public void setCityMailing(String cityMailing) {
		this.cityMailing = cityMailing;
	}
	/**
	 * @return the stateMailing
	 */
	public String getStateMailing() {
		return stateMailing;
	}
	/**
	 * @param stateMailing the stateMailing to set
	 */
	public void setStateMailing(String stateMailing) {
		this.stateMailing = stateMailing;
	}
	/**
	 * @return the zipCodeMailing
	 */
	public String getZipCodeMailing() {
		return zipCodeMailing;
	}
	/**
	 * @param zipCodeMailing the zipCodeMailing to set
	 */
	public void setZipCodeMailing(String zipCodeMailing) {
		this.zipCodeMailing = zipCodeMailing;
	}
	/**
	 * @return the careOfMailing
	 */
	public String getCareOfMailing() {
		return careOfMailing;
	}
	/**
	 * @param careOfMailing the careOfMailing to set
	 */
	public void setCareOfMailing(String careOfMailing) {
		this.careOfMailing = careOfMailing;
	}
	/**
	 * @return the locationTypeMailing
	 */
	public String getLocationTypeMailing() {
		return locationTypeMailing;
	}
	/**
	 * @param locationTypeMailing the locationTypeMailing to set
	 */
	public void setLocationTypeMailing(String locationTypeMailing) {
		this.locationTypeMailing = locationTypeMailing;
	}
	/**
	 * @return the firstNameBusiness
	 */
	public String getFirstNameContact() {
		return firstNameContact;
	}
	/**
	 * @param firstNameContact the firstNameContact to set
	 */
	public void setFirstNameContact(String firstNameContact) {
		this.firstNameContact = firstNameContact;
	}
	/**
	 * @return the lastNameContact
	 */
	public String getLastNameContact() {
		return lastNameContact;
	}
	/**
	 * @param lastNameContact the lastNameContact to set
	 */
	public void setLastNameContact(String lastNameContact) {
		this.lastNameContact = lastNameContact;
	}
	/**
	 * @return the titleContact
	 */
	public String getTitleContact() {
		return titleContact;
	}
	/**
	 * @param titleContact the titleContact to set
	 */
	public void setTitleContact(String titleContact) {
		this.titleContact = titleContact;
	}
	/**
	 * @return the phoneNumberContact
	 */
	public String getPhoneNumberContact() {
		return phoneNumberContact;
	}
	/**
	 * @param phoneNumberContact the phoneNumberContact to set
	 */
	public void setPhoneNumberContact(String phoneNumberContact) {
		this.phoneNumberContact = phoneNumberContact;
	}
	/**
	 * @return the phoneExtContact
	 */
	public String getPhoneExtContact() {
		return phoneExtContact;
	}

	/**
	 * @param phoneExtContact the phoneExtContact to set
	 */
	public void setPhoneExtContact(String phoneExtContact) {
		this.phoneExtContact = phoneExtContact;
	}

	/**
	 * @return the emailAddressContact
	 */
	public String getEmailAddressContact() {
		return emailAddressContact;
	}
	/**
	 * @param emailAddressContact the emailAddressContact to set
	 */
	public void setEmailAddressContact(String emailAddressContact) {
		this.emailAddressContact = emailAddressContact;
	}
	/**
	 * @return the webAddress
	 */
	public String getWebAddress() {
		return webAddress;
	}
	/**
	 * @param webAddress the webAddress to set
	 */
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	/**
	 * @return the firstNameFiler
	 */
	public String getFirstNameFiler() {
		return firstNameFiler;
	}
	/**
	 * @param firstNameFiler the firstNameFiler to set
	 */
	public void setFirstNameFiler(String firstNameFiler) {
		this.firstNameFiler = firstNameFiler;
	}
	/**
	 * @return the lastNameFiler
	 */
	public String getLastNameFiler() {
		return lastNameFiler;
	}
	/**
	 * @param lastNameFiler the lastNameFiler to set
	 */
	public void setLastNameFiler(String lastNameFiler) {
		this.lastNameFiler = lastNameFiler;
	}
	/**
	 * @return the titleFiler
	 */
	public String getTitleFiler() {
		return titleFiler;
	}
	/**
	 * @param titleFiler the titleFiler to set
	 */
	public void setTitleFiler(String titleFiler) {
		this.titleFiler = titleFiler;
	}
	/**
	 * @return the phoneNumberFiler
	 */
	public String getPhoneNumberFiler() {
		return phoneNumberFiler;
	}
	/**
	 * @param phoneNumberFiler the phoneNumberFiler to set
	 */
	public void setPhoneNumberFiler(String phoneNumberFiler) {
		this.phoneNumberFiler = phoneNumberFiler;
	}
	/**
	 * @return the phoneExtFiler
	 */
	public String getPhoneExtFiler() {
		return phoneExtFiler;
	}

	/**
	 * @param phoneExtFiler the phoneExtFiler to set
	 */
	public void setPhoneExtFiler(String phoneExtFiler) {
		this.phoneExtFiler = phoneExtFiler;
	}

	/**
	 * @return the emailAddressFiler
	 */
	public String getEmailAddressFiler() {
		return emailAddressFiler;
	}
	/**
	 * @param emailAddressFiler the emailAddressFiler to set
	 */
	public void setEmailAddressFiler(String emailAddressFiler) {
		this.emailAddressFiler = emailAddressFiler;
	}
}
