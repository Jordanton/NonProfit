package nonprofit.dao;

import java.math.BigDecimal;
import java.util.List;

import nonprofit.model.BusinessInfo;
import nonprofit.model.ExemptionInfo;
import nonprofit.model.ListItem;

public interface NonProfitDao {
	public void register(BusinessInfo businessInfo, ExemptionInfo exemptionInfo);
	
	public List<ListItem> getStateList();

	public List<ListItem> getUnitTypeList();
	
	public List<ListItem> getStreetTypeList();
	
	public BigDecimal generateWebFilingId();
	
	public String generateRegistrationNumber();
	
	public List<ListItem> getExemptionTypeList();

	public int registerFundClass(BigDecimal webFilingId, String fundClass, String taxPeriod);
}
