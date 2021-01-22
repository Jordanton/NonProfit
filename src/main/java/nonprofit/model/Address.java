package nonprofit.model;

//This is the object that we need to use to to integrate with address validation service
//city and state are named as such so that they don't conflict with businessInfo.city and businessInfo.state, Spring will overwrite those values if they are named identically
public class Address {
	private String stdAddress;
	private String firmName; 
	private String cityNew;
	private String stateNew;
	private String zip;
	private String zip4;
	private String matchScore;
	private String stdAddressMailing;
	private String firmNameMailing; 
	private String cityMailingNew;
	private String stateMailingNew;
	private String zipMailing;
	private String zip4Mailing;
	private String matchScoreMailing;
	/**
	 * @return the stdAddress
	 */
	public String getStdAddress() {
		return stdAddress;
	}
	/**
	 * @param stdAddress the stdAddress to set
	 */
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}
	/**
	 * @return the firmName
	 */
	public String getFirmName() {
		return firmName;
	}
	/**
	 * @param firmName the firmName to set
	 */
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	/**
	 * @return the cityNew
	 */
	public String getCityNew() {
		return cityNew;
	}
	/**
	 * @param cityNew the cityNew to set
	 */
	public void setCityNew(String cityNew) {
		this.cityNew = cityNew;
	}
	/**
	 * @return the stateNew
	 */
	public String getStateNew() {
		return stateNew;
	}
	/**
	 * @param stateNew the stateNew to set
	 */
	public void setStateNew(String stateNew) {
		this.stateNew = stateNew;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the zip4
	 */
	public String getZip4() {
		return zip4;
	}
	/**
	 * @param zip4 the zip4 to set
	 */
	public void setZip4(String zip4) {
		this.zip4 = zip4;
	}
	/**
	 * @return the matchScore
	 */
	public String getMatchScore() {
		return matchScore;
	}
	/**
	 * @param matchScore the matchScore to set
	 */
	public void setMatchScore(String matchScore) {
		this.matchScore = matchScore;
	}
	/**
	 * @return the stdAddressMailing
	 */
	public String getStdAddressMailing() {
		return stdAddressMailing;
	}
	/**
	 * @param stdAddressMailing the stdAddressMailing to set
	 */
	public void setStdAddressMailing(String stdAddressMailing) {
		this.stdAddressMailing = stdAddressMailing;
	}
	/**
	 * @return the firmNameMailing
	 */
	public String getFirmNameMailing() {
		return firmNameMailing;
	}
	/**
	 * @param firmNameMailing the firmNameMailing to set
	 */
	public void setFirmNameMailing(String firmNameMailing) {
		this.firmNameMailing = firmNameMailing;
	}
	/**
	 * @return the cityMailingNew
	 */
	public String getCityMailingNew() {
		return cityMailingNew;
	}
	/**
	 * @param cityMailingNew the cityMailingNew to set
	 */
	public void setCityMailingNew(String cityMailingNew) {
		this.cityMailingNew = cityMailingNew;
	}
	/**
	 * @return the stateMailingNew
	 */
	public String getStateMailingNew() {
		return stateMailingNew;
	}
	/**
	 * @param stateMailingNew the stateMailingNew to set
	 */
	public void setStateMailingNew(String stateMailingNew) {
		this.stateMailingNew = stateMailingNew;
	}
	/**
	 * @return the zipMailing
	 */
	public String getZipMailing() {
		return zipMailing;
	}
	/**
	 * @param zipMailing the zipMailing to set
	 */
	public void setZipMailing(String zipMailing) {
		this.zipMailing = zipMailing;
	}
	/**
	 * @return the zip4Mailing
	 */
	public String getZip4Mailing() {
		return zip4Mailing;
	}
	/**
	 * @param zip4Mailing the zip4Mailing to set
	 */
	public void setZip4Mailing(String zip4Mailing) {
		this.zip4Mailing = zip4Mailing;
	}
	/**
	 * @return the matchScoreMailing
	 */
	public String getMatchScoreMailing() {
		return matchScoreMailing;
	}
	/**
	 * @param matchScoreMailing the matchScoreMailing to set
	 */
	public void setMatchScoreMailing(String matchScoreMailing) {
		this.matchScoreMailing = matchScoreMailing;
	}	
}
