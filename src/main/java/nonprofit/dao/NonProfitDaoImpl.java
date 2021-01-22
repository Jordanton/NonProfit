package nonprofit.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nonprofit.model.BusinessInfo;
import nonprofit.model.ExemptionInfo;
import nonprofit.model.ListItem;

@Repository
public class NonProfitDaoImpl implements NonProfitDao {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;	
	
	private static final Logger logger = LoggerFactory.getLogger(NonProfitDaoImpl.class);
	private static final String LATAXNP = "'LATAXNP'";
	
	@Override
	@Transactional(rollbackFor = SQLException.class)
	public void register(BusinessInfo businessInfo, ExemptionInfo exemptionInfo) {
		logger.info("Executing query: " + "INSERT INTO " + "LATAX.WEB_EAPPREG_MASTER "
				+ "("
				+ "WEB_FILING_ID, "
				+ "REGISTRATION_NUMBER, "
				+ "OOF_STATUS2, "
				+ "WEB_CONFIRMATION_NBR, "
				+ "FEIN, "
				+ "BUSINESS_DESC, "
				+ "BUSID_LEGAL_NM, "
				+ "BUSID_DBA_NM,"
				+ "BUSACT_START_DT, "
				+ "BUSACT_BUS_TYPE, "
				+ "BA1_STR_NBR, "
				+ "BA1_STR_DIR_PREFIX, "
				+ "BA1_STR_NM, "
				+ "BA1_STR_DIR_SUFFIX, "
				+ "BA1_STR_TYPE, "
				+ "BA2_UNIT_TYPE, "
				+ "BA2_UNIT_NBR, "
				+ "BA3_CITY, "
				+ "BA3_STATE, "
				+ "BA3_ZIPCD, "
				+ "BA2_CAREOF,"
				+ "BA0_COMMERCIAL, "				
				+ "MA1_STR_NBR, "
				+ "MA1_STR_DIR_PREFIX, "
				+ "MA1_STR_NM, "
				+ "MA1_STR_DIR_SUFFIX, "
				+ "MA1_STR_TYPE, "
				+ "MA2_UNIT_TYPE, "
				+ "MA2_UNIT_NBR, "
				+ "MA3_CITY, "
				+ "MA3_STATE, "
				+ "MA3_ZIPCD, "
				+ "MA2_CAREOF,"
				+ "MA0_COMMERCIAL, "				  
				+ "BUSCON_NAME_FIRST, "
				+ "BUSCON_NAME_LAST, "
				+ "BUSCON_TITLE, "
				+ "BUSCON_PHONE_NBR, "
				+ "BUSCON_EMAIL, "
				+ "BUSCON_WEB_ADDRESS, "
				+ "FILER_NAME_FIRST, "
				+ "FILER_NAME_LAST, "
				+ "FILER_TITLE, "
				+ "FILER_PHONE_NBR, "
				+ "FILER_EMAIL, "
				+ "EXEMPTION_ID"
				+ ")"				
				+ " VALUES "
				+ "(" 				
				+ businessInfo.getWebFilingId() + ", "
				+ businessInfo.getRegistrationNumber() + ", "
				+ "'PND', "
				+ businessInfo.getWebConfirmationNumber() + ", "			
				+ businessInfo.getBusinessDescription() + ", "
				+ exemptionInfo.getFein() + ", "
				+ businessInfo.getBusinessLegalName() + ", "
				+ businessInfo.getDbaName() + ", "
				+ businessInfo.getBusinessStartDate() + ", "
				+ businessInfo.getBusinessType() + ", "
				+ businessInfo.getStreetNumber() + ", "
				+ businessInfo.getStreetNumberFraction() + ", "
				+ businessInfo.getDirectionalPrefix() + ", "
				+ businessInfo.getStreetName() + ", "
				+ businessInfo.getDirectionalSuffix() + ", "
				+ businessInfo.getStreetType() + ", "
				+ businessInfo.getUnitType() + ", "
				+ businessInfo.getUnitNumber() + ", "
				+ businessInfo.getCity() + ", "
				+ businessInfo.getState() + ", "
				+ businessInfo.getZipCode() + ", "
				+ businessInfo.getCareOf() + ", "
				+ businessInfo.getLocationType() + ", "			
				+ businessInfo.getStreetNumberMailing() + ", "
				+ businessInfo.getStreetNumberFractionMailing() + ", "
				+ businessInfo.getDirectionalPrefixMailing() + ", "
				+ businessInfo.getStreetNameMailing() + ", "
				+ businessInfo.getDirectionalSuffixMailing() + ", "
				+ businessInfo.getStreetTypeMailing() + ", "
				+ businessInfo.getUnitTypeMailing() + ", "
				+ businessInfo.getUnitNumberMailing() + ", "
				+ businessInfo.getCityMailing() + ", "
				+ businessInfo.getStateMailing() + ", "
				+ businessInfo.getZipCodeMailing() + ", "
				+ businessInfo.getCareOfMailing() + ", "
				+ businessInfo.getLocationTypeMailing() + ", "			  
				+ businessInfo.getFirstNameContact() + ", "
				+ businessInfo.getLastNameContact() + ", "
				+ businessInfo.getTitleContact() + ", "
				+ businessInfo.getPhoneNumberContact() + ", "
				+ businessInfo.getEmailAddressContact() + ", "
				+ businessInfo.getWebAddress() + ", "
				+ businessInfo.getFirstNameFiler() + ", "
				+ businessInfo.getLastNameFiler() + ", "
				+ businessInfo.getTitleFiler() + ", "
				+ businessInfo.getPhoneNumberFiler() + ", "
				+ businessInfo.getEmailAddressFiler() + ", "
				+ exemptionInfo.getExemptionId() + ", "
				+ ")");
		
		String masterQuery = "INSERT INTO  " + "LATAX.WEB_EAPPREG_MASTER "
		+ "("
		+ "WEB_FILING_ID, "
		+ "REGISTRATION_NUMBER, "
		+ "OOF_STATUS2, "
		+ "WEB_CONFIRMATION_NBR, "
		+ "BUSINESS_DESC, "
		+ "FEIN, "
		+ "CREATED_BY, "
		+ "CREATED_DT, "
		+ "POSTMARK_DT, "
		+ "BUSID_LEGAL_NM, "
		+ "BUSID_DBA_NM,"
		+ "BUSACT_START_DT, "
		+ "BUSACT_BUS_TYPE, "
		+ "BA1_STR_NBR, "
		+ "BA1_STR_NBR_FRAC, "
		+ "BA1_STR_DIR_PREFIX, "
		+ "BA1_STR_NM, "
		+ "BA1_STR_DIR_SUFFIX, "
		+ "BA1_STR_TYPE, "
		+ "BA2_UNIT_TYPE, "
		+ "BA2_UNIT_NBR, "
		+ "BA3_CITY, "
		+ "BA3_STATE, "
		+ "BA3_ZIPCD, "
		+ "BA2_CAREOF,"
		+ "BA0_COMMERCIAL, "
		
		+ "MA1_STR_NBR, "
		+ "MA1_STR_NBR_FRAC, "
		+ "MA1_STR_DIR_PREFIX, "
		+ "MA1_STR_NM, "
		+ "MA1_STR_DIR_SUFFIX, "
		+ "MA1_STR_TYPE, "
		+ "MA2_UNIT_TYPE, "
		+ "MA2_UNIT_NBR, "
		+ "MA3_CITY, "
		+ "MA3_STATE, "
		+ "MA3_ZIPCD, "
		+ "MA2_CAREOF,"
		+ "MA0_COMMERCIAL, "
		  
		+ "BUSCON_NAME_FIRST, "
		+ "BUSCON_NAME_LAST, "
		+ "BUSCON_TITLE, "
		+ "BUSCON_PHONE_NBR, "
		+ "BUSCON_EMAIL, "
		+ "BUSCON_WEB_ADDRESS, "
		+ "FILER_NAME_FIRST, "
		+ "FILER_NAME_LAST, "
		+ "FILER_TITLE, "
		+ "FILER_PHONE_NBR, "
		+ "FILER_EMAIL, "
		+ "EXEMPTION_ID"
		+ ")"				
		+ " VALUES "
		+ "(" 				
		+ ":WEB_FILING_ID, "
		+ ":REGISTRATION_NUMBER, "
		+ "'PND', "
		+ ":WEB_CONFIRMATION_NBR, "				
		+ ":BUSINESS_DESC, "
		+ ":FEIN, "
		+ LATAXNP + ", "
		+ "SYSDATE, "
		+ "SYSDATE, "
		+ ":BUSID_LEGAL_NM, "
		+ ":BUSID_DBA_NM,"
		+ ":BUSACT_START_DT, "
		+ ":BUSACT_BUS_TYPE, "
		
		+ ":BA1_STR_NBR, "
		+ ":BA1_STR_NBR_FRAC, "
		+ ":BA1_STR_DIR_PREFIX, "
		+ ":BA1_STR_NM, "
		+ ":BA1_STR_DIR_SUFFIX, "
		+ ":BA1_STR_TYPE, "
		+ ":BA2_UNIT_TYPE, "
		+ ":BA2_UNIT_NBR, "
		+ ":BA3_CITY, "
		+ ":BA3_STATE, "
		+ ":BA3_ZIPCD, "
		+ ":BA2_CAREOF,"
		+ ":BA0_COMMERCIAL, "
		
		+ ":MA1_STR_NBR, "
		+ ":MA1_STR_NBR_FRAC, "
		+ ":MA1_STR_DIR_PREFIX, "
		+ ":MA1_STR_NM, "
		+ ":MA1_STR_DIR_SUFFIX, "
		+ ":MA1_STR_TYPE, "
		+ ":MA2_UNIT_TYPE, "
		+ ":MA2_UNIT_NBR, "
		+ ":MA3_CITY, "
		+ ":MA3_STATE, "
		+ ":MA3_ZIPCD, "
		+ ":MA2_CAREOF, "
		+ ":MA0_COMMERCIAL, "
		  
		+ ":BUSCON_NAME_FIRST, "
		+ ":BUSCON_NAME_LAST, "
		+ ":BUSCON_TITLE, "
		+ ":BUSCON_PHONE_NBR, "
		+ ":BUSCON_EMAIL, "
		+ ":BUSCON_WEB_ADDRESS, "
		+ ":FILER_NAME_FIRST, "
		+ ":FILER_NAME_LAST, "
		+ ":FILER_TITLE, "
		+ ":FILER_PHONE_NBR, "
		+ ":FILER_EMAIL, "
		+ ":EXEMPTION_ID"
		+ ")";	          
			
		MapSqlParameterSource mapSqlParamSrc = new MapSqlParameterSource();
			
		mapSqlParamSrc.addValue("WEB_FILING_ID", businessInfo.getWebFilingId());
		mapSqlParamSrc.addValue("REGISTRATION_NUMBER", businessInfo.getRegistrationNumber());
		mapSqlParamSrc.addValue("WEB_CONFIRMATION_NBR", businessInfo.getWebConfirmationNumber());
		mapSqlParamSrc.addValue("BUSINESS_DESC", businessInfo.getBusinessDescription());
		mapSqlParamSrc.addValue("FEIN", exemptionInfo.getFein());
		mapSqlParamSrc.addValue("BUSID_LEGAL_NM", businessInfo.getBusinessLegalName());
		mapSqlParamSrc.addValue("BUSID_DBA_NM", businessInfo.getDbaName());
		mapSqlParamSrc.addValue("BUSACT_START_DT", businessInfo.getBusinessStartDate());
		mapSqlParamSrc.addValue("BUSACT_BUS_TYPE", businessInfo.getBusinessType());
		  
		mapSqlParamSrc.addValue("BA1_STR_NBR", businessInfo.getStreetNumber());
		mapSqlParamSrc.addValue("BA1_STR_NBR_FRAC", businessInfo.getStreetNumberFraction());
		mapSqlParamSrc.addValue("BA1_STR_DIR_PREFIX", businessInfo.getDirectionalPrefix());
		mapSqlParamSrc.addValue("BA1_STR_NM", businessInfo.getStreetName());
		mapSqlParamSrc.addValue("BA1_STR_DIR_SUFFIX", businessInfo.getDirectionalSuffix());
		mapSqlParamSrc.addValue("BA1_STR_TYPE", businessInfo.getStreetType());
		mapSqlParamSrc.addValue("BA2_UNIT_TYPE", businessInfo.getUnitType());
		mapSqlParamSrc.addValue("BA2_UNIT_NBR", businessInfo.getUnitNumber());
		mapSqlParamSrc.addValue("BA3_CITY", businessInfo.getCity());
		mapSqlParamSrc.addValue("BA3_STATE", businessInfo.getState());
		mapSqlParamSrc.addValue("BA3_ZIPCD", businessInfo.getZipCode());
		mapSqlParamSrc.addValue("BA2_CAREOF", businessInfo.getCareOf());
		mapSqlParamSrc.addValue("BA0_COMMERCIAL", businessInfo.getLocationType());
		  
		mapSqlParamSrc.addValue("MA1_STR_NBR", businessInfo.getStreetNumberMailing());
		mapSqlParamSrc.addValue("MA1_STR_NBR_FRAC", businessInfo.getStreetNumberFractionMailing());
		mapSqlParamSrc.addValue("MA1_STR_DIR_PREFIX", businessInfo.getDirectionalPrefixMailing());
		mapSqlParamSrc.addValue("MA1_STR_NM", businessInfo.getStreetNameMailing());
		mapSqlParamSrc.addValue("MA1_STR_DIR_SUFFIX", businessInfo.getDirectionalSuffixMailing());
		mapSqlParamSrc.addValue("MA1_STR_TYPE", businessInfo.getStreetTypeMailing());
		mapSqlParamSrc.addValue("MA2_UNIT_TYPE", businessInfo.getUnitTypeMailing());
		mapSqlParamSrc.addValue("MA2_UNIT_NBR", businessInfo.getUnitNumberMailing());
		mapSqlParamSrc.addValue("MA3_CITY", businessInfo.getCityMailing());
		mapSqlParamSrc.addValue("MA3_STATE", businessInfo.getStateMailing());
		mapSqlParamSrc.addValue("MA3_ZIPCD", businessInfo.getZipCodeMailing());
		mapSqlParamSrc.addValue("MA2_CAREOF", businessInfo.getCareOfMailing());
		mapSqlParamSrc.addValue("MA0_COMMERCIAL", businessInfo.getLocationTypeMailing());
		  
		//mapSqlParamSrc.addValue("sellers permit number", value)
		  
		mapSqlParamSrc.addValue("BUSCON_NAME_FIRST", businessInfo.getFirstNameContact());
		mapSqlParamSrc.addValue("BUSCON_NAME_LAST", businessInfo.getLastNameContact());
		mapSqlParamSrc.addValue("BUSCON_TITLE", businessInfo.getTitleContact());
		mapSqlParamSrc.addValue("BUSCON_PHONE_NBR", businessInfo.getPhoneNumberContact());
		mapSqlParamSrc.addValue("BUSCON_EMAIL", businessInfo.getEmailAddressContact());
		mapSqlParamSrc.addValue("BUSCON_WEB_ADDRESS", businessInfo.getWebAddress());
		  
		mapSqlParamSrc.addValue("FILER_NAME_FIRST", businessInfo.getFirstNameFiler());
		mapSqlParamSrc.addValue("FILER_NAME_LAST", businessInfo.getLastNameContact());
		mapSqlParamSrc.addValue("FILER_TITLE", businessInfo.getTitleFiler());
		mapSqlParamSrc.addValue("FILER_PHONE_NBR", businessInfo.getPhoneNumberFiler());
		mapSqlParamSrc.addValue("FILER_EMAIL", businessInfo.getEmailAddressFiler());    
		mapSqlParamSrc.addValue("EXEMPTION_ID", exemptionInfo.getExemptionId());
		  
		NamedParameterJdbcTemplate namedParamJdbcTempl = new NamedParameterJdbcTemplate(dataSource);
		
		namedParamJdbcTempl.update(masterQuery, mapSqlParamSrc);
		
		String detailQuery = "INSERT INTO LATAX.WEB_EAPPREG_DETAIL "
				+ "("
				+ "WEB_FILING_ID, "
				+ "REVENUE_TYPE, "
				+ "CREATED_BY, " 				
				+ "CREATED_DT, "				 
				+ "TAX_PERIOD"
				+ ")"
				+ " VALUES "
				+ "("
				+ ":WEB_FILING_ID, "
				+ ":REVENUE_TYPE, "
				+ "'LATAXNP', "
				+ "SYSDATE, "				 
				+ ":TAX_PERIOD"
				+ ")";
		Calendar calendar = Calendar.getInstance();
		String taxPeriod = calendar.get(Calendar.YEAR) + "00A";
		for(String fundClass : exemptionInfo.getFundClass()) {
			mapSqlParamSrc = new MapSqlParameterSource();
			mapSqlParamSrc.addValue("WEB_FILING_ID", businessInfo.getWebFilingId());
			mapSqlParamSrc.addValue("REVENUE_TYPE", fundClass);
			mapSqlParamSrc.addValue("TAX_PERIOD", taxPeriod);
			namedParamJdbcTempl.update(detailQuery, mapSqlParamSrc);		
		}	
	}
	
	@Override
	public int registerFundClass(BigDecimal webFilingId, String fundClass, String taxPeriod) {
		String sqlStatement = "INSERT INTO LATAX.WEB_EAPPREG_DETAIL "
				+ "("
				+ "WEB_FILING_ID, "
				+ "REVENUE_TYPE, "
				+ "CREATED_BY, " 				
				+ "CREATED_DT, "				 
				+ "TAX_PERIOD"
				+ ")"
				+ " VALUES "
				+ "("
				+ ":WEB_FILING_ID, "
				+ ":REVENUE_TYPE, "
				+ "'LATAXNP', "
				+ "SYSDATE, "				 
				+ ":TAX_PERIOD"
				+ ")";
		MapSqlParameterSource mapSqlParamSrc = new MapSqlParameterSource();
		mapSqlParamSrc.addValue("WEB_FILING_ID", webFilingId);
		mapSqlParamSrc.addValue("REVENUE_TYPE", fundClass);
		mapSqlParamSrc.addValue("TAX_PERIOD", taxPeriod);
		NamedParameterJdbcTemplate namedParamJdbcTempl = new NamedParameterJdbcTemplate(dataSource);
		return namedParamJdbcTempl.update(sqlStatement, mapSqlParamSrc);
	}
	
	@Override
	public List<ListItem> getExemptionTypeList() {	
		String query = "SELECT EXEMPTION_ID AS VALUE, EXEMPTION_SUBNAME AS LABEL FROM LATAX.EXEMPTION_DEFN WHERE EXEMPTION_NAME ='Non-Profit'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(ListItem.class));
	}

	@Override
	public List<ListItem> getStateList() {
		String query = "SELECT STATE AS VALUE, STATE_NAME AS LABEL FROM LATAX.STATE";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(ListItem.class));
	}

	@Override
	public List<ListItem> getUnitTypeList() {		
		String query = "SELECT UNIT_CD AS VALUE, DESCRIPTION AS LABEL FROM LATAX.UNIT_TYPE";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(ListItem.class));
	}
	
	@Override
	public List<ListItem> getStreetTypeList() {		
		String query = "SELECT STREET_CD AS VALUE, DESCRIPTION AS LABEL FROM LATAX.STREET_TYPE";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(ListItem.class));
	}
	
	@Override
	public BigDecimal generateWebFilingId() {
        String query = "SELECT LATAX.next_gun('WEB_FILING_HDR','WEB_FILING_ID') as NxtNbr FROM dual";     	        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);	        
        List<String> result = jdbcTemplate.queryForList(query, String.class);
        return new BigDecimal(result.get(0));	        
	}
	
	@Override
	public String generateRegistrationNumber() {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
										.withSchemaName("LATAX")
										.withCatalogName("PKG_ITS_REGISTRATION")
										.withProcedureName("GET_NEXT_REG_NBR");
	    simpleJdbcCall.declareParameters(new SqlOutParameter("next_reg_nbr",java.sql.Types.VARCHAR));
	    SqlParameterSource namedParameters = new MapSqlParameterSource()
								    		.addValue("table_nm", "REGISTRATION")
								    		.addValue("column_nm", "REGISTRATION_NUMBER");  
	    Map<String, Object> out = simpleJdbcCall.execute(namedParameters);
	    String regNumber = (String) out.get("next_reg_nbr");
	    return regNumber;
	}
}
