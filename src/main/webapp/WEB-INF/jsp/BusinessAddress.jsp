<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ************ BUSINESS ADDRESS ************ -->
<fieldset id="business-address">
	<legend class="px-3 legend-section">Primary Business Address</legend>
	<div class="form-group row">
		<div class="col-md-3">
			<label class="col-form-label required text-nowrap" for="street-number">Street Number:</label>	
			<form:input class="form-control" type="number" pattern="^[0-9]{1,10}$" id="street-number" path="streetNumber" required="required"/>
			<small class="form-text text-muted">i.e. 250 for '250 N Main St.'</small>										
			<form:errors path="streetNumber" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>
		</div>				
		<div class="col-md-3">
			<label class="col-form-label " for="street-number-fraction">Fractional:</label>	
			<form:input class="form-control" id="street-number-fraction" maxlength="5" pattern="^[0-9]{1,2}\/[0-9]{1,2}$" path="streetNumberFraction"/>
			<small class="form-text text-muted">i.e. 1/2 for '250 1/2 N Main St.'</small>										
			<form:errors path="streetNumberFraction" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>								
		</div>
		<div class="col-md-3">
			<label class="col-form-label text-nowrap" for="directional-prefix">Directional Prefix:</label>	
			<form:select class="form-control" id="directional-prefix" maxlength="2" path="directionalPrefix">
				<form:option value="" selected="selected">Select</form:option>
	            <form:option value="N">N</form:option>
	            <form:option value="NE">NE</form:option>
	            <form:option value="E">E</form:option>
	            <form:option value="SE">SE</form:option>
	            <form:option value="S">S</form:option>
	            <form:option value="SW">SW</form:option>
	            <form:option value="W">W</form:option>			            
			</form:select>
			<small class="form-text text-muted">i.e. N for '200 N Main'</small>									
			<form:errors path="directionalPrefix" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>												
		</div>	
	</div>		
	<div class="form-group row">
		<div class="col-md-6">
			<label class="col-form-label required" for="street-name">Street Name:</label>	
			<form:input class="form-control" id="street-name" maxlength="45" path="streetName" required="required"/>
			<small class="form-text text-muted">i.e. Main for '250 Main St.'</small>										
			<form:errors path="streetName" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>													
		</div>			
		<div class="col-md-3">
			<label class="col-form-label text-nowrap" for="directional-suffix">Directional Suffix:</label>	
			<form:select class="form-control" id="directional-suffix" path="directionalSuffix">
				<form:option value="" selected="selected">Select</form:option>
	            <form:option value="N">N</form:option>
	            <form:option value="NE">NE</form:option>
	            <form:option value="E">E</form:option>
	            <form:option value="SE">SE</form:option>
	            <form:option value="S">S</form:option>
	            <form:option value="SW">SW</form:option>
	            <form:option value="W">W</form:option>			            
			</form:select>
			<small class="form-text text-muted">i.e. W for '300 Century West'</small>										
			<form:errors path="directionalSuffix" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>									
		</div>	
		<div class="col-md-3">
			<label class="col-form-label" for="street-type">Street Type:</label>	
			<form:select class="form-control" id="street-type" path="streetType">
				<form:option value="">Select</form:option>
				<form:options items="${streetType}" itemValue="value" itemLabel="label"/>           
			</form:select>
			<small class="form-text text-muted">i.e. Ave for 'Bristol Ave.'</small>										
			<form:errors path="streetType" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>													
		</div>									
	</div>
	<div class="form-group row">
		<div class="col-md-4">
			<label class="col-form-label" for="unit-type">Unit Type <span class="text-danger">(PO Box not acccepted)</span>:</label>	
			<form:select class="form-control" id="unit-type" path="unitType">
				<form:option value="">Select</form:option> 
				<form:options items="${unitType}" itemValue="value" itemLabel="label"/>           
			</form:select>
			<small class="form-text text-muted">i.e. Apartment</small>										
			<form:errors path="unitType" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>										
		</div>
		<div class="col-md-2">
			<label class="col-form-label" for="city">Unit Number:</label>	
			<form:input class="form-control" type="number" pattern="^[0-9]{0,10}$" id="unit-number" path="unitNumber"/>
			<small class="form-text text-muted">i.e. 5 for 'Apartment 5'</small>										
			<form:errors path="unitNumber" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>									
		</div>	
	</div>		
	<div class="form-group row">
		<div class="col-md-6">
			<label class="col-form-label required" for="city">City:</label>	
			<form:input class="form-control" type="text" id="city" maxlength="25" path="city" required="required"/>
			<form:errors path="city" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>											
		</div>
		<div class="col-md-3">
			<label class="col-form-label required" for="state">State:</label>	
			<form:select class="form-control" id="state" path="state" required="required">
				<form:options items="${stateList}" itemValue="value" itemLabel="label"/>
			</form:select>
			<form:errors path="state" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>									
		</div>
		<div class="col-md-3">
			<label class="col-form-label required" for="zip-code">Zip Code:</label>	
			<form:input class="form-control" type="number" pattern="^[0-9]{5}$" id="zip-code" maxlength="5" path="zipCode" required="required"/>
			<form:errors path="zipCode" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>
		</div>
	</div>	
	<div class="form-group row">
		<div class="col-md-3">
			<label class="col-form-label" for="care-of">Care Of (C/O):</label>	
			<form:input class="form-control" type="text" id="care-of" path="careOf"/>
			<form:errors path="careOf" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>			
		</div>
	</div>
	<div class="form-group row">
		<div class="col-md-3">
			<label class="col-form-label required">Location Type:</label>
		</div>
	 	<div class="col-md-3 form-check form-check-inline">
			<form:radiobutton class="form-check-input" id="location-type" value="Y" path="locationType" required="required"/>
			<label class="form-check-label">Commercial Location</label>
		</div>
		<div class="col-md-3 form-check form-check-inline">
			<form:radiobutton class="form-check-input" value="N" path="locationType"/>
			<label class="form-check-label">Residence</label>
		</div>
		<form:errors path="locationType" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>
	</div>
</fieldset>
			
<!-- ************ MAILING ADDRESS ************ -->	
<fieldset id="mailing-address">
	<legend class="px-3 legend-section">Mailing Address</legend>
	<div class="form-group row">
		<div class="col-md-12 form-check form-check-inline">
		<form:checkbox class="form-check-input" id="mailing-address-checkbox" path="oneAddress"/>
		<label class="form-check-label">Check if same as Business Address</label>
		</div>
	</div>
	<div id="mailing-address-form">
		<div class="form-group row">
			<div class="col-md-3">
				<label class="col-form-label required  text-nowrap" for="street-number-mailing">Street Number:</label>	
				<form:input class="form-control" type="number" pattern="^[0-9]{1,10}$" id="street-number-mailing" path="streetNumberMailing" required="required"/>
				<small class="form-text text-muted">i.e. 250 for '250 N Main St.'</small>
				<form:errors path="streetNumberMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>
			</div>				
			<div class="col-md-3">
				<label class="col-form-label " for="street-number-fraction-mailing">Fractional:</label>	
				<form:input class="form-control" id="street-number-fraction-mailing" maxlength="5" pattern="^[0-9]{1,2}\/[0-9]{1,2}$" path="streetNumberFractionMailing"/>
				<small class="form-text text-muted">i.e. 1/2 for '250 1/2 N Main St.'</small>
				<form:errors path="streetNumberFractionMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>								
			</div>
			<div class="col-md-3">
				<label class="col-form-label text-nowrap" for="directional-prefix-mailing">Directional Prefix:</label>	
				<form:select class="form-control" id="directional-prefix-mailing" maxlength="2" path="directionalPrefixMailing">
					<form:option value="" selected="selected">Select</form:option>
		            <form:option value="N">N</form:option>
		            <form:option value="NE">NE</form:option>
		            <form:option value="E">E</form:option>
		            <form:option value="SE">SE</form:option>
		            <form:option value="S">S</form:option>
		            <form:option value="SW">SW</form:option>
		            <form:option value="W">W</form:option>			            
				</form:select>
				<small class="form-text text-muted">i.e. N for '200 N Main'</small>
				<form:errors path="directionalPrefixMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>												
			</div>	
		</div>		
		<div class="form-group row">
			<div class="col-md-6">
				<label class="col-form-label required" for="street-name-mailing">Street Name:</label>	
				<form:input class="form-control" id="street-name-mailing" maxlength="45" path="streetNameMailing" required="required"/>
				<small class="form-text text-muted">i.e. Main for '250 Main St.'</small>
				<form:errors path="streetNameMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>													
			</div>			
			<div class="col-md-3">
				<label class="col-form-label text-nowrap" for="directional-suffix-mailing">Directional Suffix:</label>	
				<form:select class="form-control" id="directional-suffix-mailing" path="directionalSuffixMailing">
					<form:option value="" selected="selected">Select</form:option>
		            <form:option value="N">N</form:option>
		            <form:option value="NE">NE</form:option>
		            <form:option value="E">E</form:option>
		            <form:option value="SE">SE</form:option>
		            <form:option value="S">S</form:option>
		            <form:option value="SW">SW</form:option>
		            <form:option value="W">W</form:option>			            
				</form:select>
				<small class="form-text text-muted">i.e. W for '300 Century West'</small>
				<form:errors path="directionalSuffixMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>									
			</div>	
			<div class="col-md-3">
				<label class="col-form-label" for="street-type-mailing">Street Type:</label>	
				<form:select class="form-control" id="street-type-mailing" path="streetTypeMailing">
					<form:option value="">Select</form:option>
					<form:options items="${streetType}" itemValue="value" itemLabel="label"/>           
				</form:select>
				<small class="form-text text-muted">i.e. Ave for 'Bristol Ave.'</small>	
				<form:errors path="streetTypeMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>													
			</div>									
		</div>
		<div class="form-group row">
			<div class="col-md-4">
				<label class="col-form-label" for="unit-type-mailing">Unit Type:</label>	
				<form:select class="form-control" id="unit-type-mailing" path="unitTypeMailing">
					<form:option value="">Select</form:option> 
					<form:options items="${unitTypeMailing}" itemValue="value" itemLabel="label"/>           
				</form:select>
				<small class="form-text text-muted">i.e. Apartment</small>	
				<form:errors path="unitTypeMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>										
			</div>
			<div class="col-md-2">
				<label class="col-form-label" for="unit-number-mailing">Unit Number:</label>	
				<form:input class="form-control" type="number" pattern="^[0-9]{0,10}$" id="unit-number-mailing" path="unitNumberMailing"/>
				<small class="form-text text-muted">i.e. 5 for 'Apartment 5'</small>
				<form:errors path="unitNumberMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>									
			</div>	
		</div>		
		<div class="form-group row">
			<div class="col-md-6">
				<label class="col-form-label required" for="city-mailing">City:</label>	
				<form:input class="form-control" type="text" id="city-mailing" maxlength="25" path="cityMailing" required="required"/>
				<form:errors path="cityMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>											
			</div>
			<div class="col-md-3">
				<label class="col-form-label required" for="state-mailing">State:</label>	
				<form:select class="form-control" id="state-mailing" path="stateMailing" required="required">
					<form:options items="${stateList}" itemValue="value" itemLabel="label"/>
				</form:select>
				<form:errors path="stateMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>									
			</div>
			<div class="col-md-3">
				<label class="col-form-label required" for="zip-code-mailing">Zip Code:</label>	
				<form:input class="form-control" type="number" pattern="^[0-9]{5}$" id="zip-code-mailing" maxlength="5" path="zipCodeMailing" required="required"/>
				<form:errors path="zipCodeMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>
			</div>
		</div>	
		<div class="form-group row">
			<div class="col-md-3">
				<label class="col-form-label" for="care-of-mailing">Care Of (C/O):</label>	
				<form:input class="form-control" type="text" id="care-of-mailing" path="careOfMailing"/>
				<form:errors path="careOfMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>			
			</div>
		</div>
		<div class="form-group row">
			<div class="col-md-3">
				<label class="col-form-label required">Location Type:</label>
			</div>
		 	<div class="col-md-3 form-check form-check-inline">
				<form:radiobutton class="form-check-input" id="location-type-mailing" value="Y" path="locationTypeMailing" required="required"/>
				<label class="form-check-label">Commercial Location</label>
			</div>
			<div class="col-md-3 form-check form-check-inline">
				<form:radiobutton class="form-check-input" value="N" path="locationTypeMailing"/>
				<label class="form-check-label">Residence</label>
			</div>
			<form:errors path="locationTypeMailing" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>
		</div>
	</div>	
</fieldset>	