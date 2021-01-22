package nonprofit.model;

import java.util.List;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class ExemptionInfo {
	
	@Pattern(regexp="^(13|14|15|16|28)", message="Invalid value")
	private String exemptionId;
	private	List<String> fundClass;	
	private MultipartFile[] file;
	@NotBlank
	@Pattern(regexp="^[0-9]{9}$", message="Invalid value")
	private String fein;
	private List<String> fileNames;
	private boolean nameChanged;
	
	
	/**
	 * @return the exemptionId
	 */
	public String getExemptionId() {
		return exemptionId;
	}
	
	/**
	 * @param exemptionId the exemptionId to set
	 */
	public void setExemptionId(String exemptionId) {
		this.exemptionId = exemptionId;
	}

	/**
	 * @return the fundClass
	 */
	public List<String> getFundClass() {
		return fundClass;
	}

	/**
	 * @param fundClass the fundClass to set
	 */
	public void setFundClass(List<String> fundClass) {
		this.fundClass = fundClass;
	}

	/**
	 * @return the file
	 */
	public MultipartFile[] getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}

	/**
	 * @return the fein
	 */
	public String getFein() {
		return fein;
	}

	/**
	 * @param fein the fein to set
	 */
	public void setFein(String fein) {
		this.fein = fein;
	}

	/**
	 * @return the fileNames
	 */
	public List<String> getFileNames() {
		return fileNames;
	}

	/**
	 * @param fileNames the fileNames to set
	 */
	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}

	/**
	 * @return the nameChanged
	 */
	public boolean isNameChanged() {
		return nameChanged;
	}

	/**
	 * @param nameChanged the nameChanged to set
	 */
	public void setNameChanged(boolean nameChanged) {
		this.nameChanged = nameChanged;
	}	
}
