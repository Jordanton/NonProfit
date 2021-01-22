<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<!-- ************ BUSINESS INFO ************ -->
<fieldset id="business-details">
	<legend class="px-3 legend-section">Business Details</legend>
	<div class="form-group row">
		<label class="col-md-3 col-form-label required" for="business-description">Business Description:</label>
		<div class="col-md-6">
			<form:input class="form-control" id="business-description" maxlength="60" path="businessDescription" required="required"></form:input>
			<form:errors path="businessDescription" cssClass="error" cssStyle="color:red; font-weight: bold"></form:errors>
			<small class="form-text text-muted">You have <span id="characters-remaining">60</span> characters remaining.</small>
		</div>
	</div>		
	<div class="form-group row">
		<div class="col-md-3">
			<label class="col-form-label required" for="legal-business-name">Legal Business Name:</label>	
			<label class="form-text text-danger">Do not use DBA (Fictitious Name) here</label>										
		</div>
		<div class="col-md-6">
			<form:input class="form-control" type="text" id="legal-business-name" path="businessLegalName" required="required"/>
			<form:errors path="businessLegalName" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>
		</div>
	</div>		
	<div class="form-group row">
		<div class="col-md-3">
			<label class="col-form-label" for="dba-name">DBA Name:</label>	
			<small class="form-text text-muted">If applicable</small>										
		</div>
		<div class="col-md-6">
			<form:input class="form-control" type="text" id="dba-name" path="dbaName"/>
			<form:errors path="dbaName" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>
		</div>		
	</div>		
	<%-- <div class="form-group row">
		<div class="col-md-3">
			<label class="col-form-label required" for="start-date">Business Start Date</label>
			<small class="form-text text-muted" for="start-date">Please enter the date that <strong>you will begin</strong> rendering services within the city of Los Angeles</small>
		</div>		
		<div class="col-md-4">
			<form:input class="form-control" type="date" id="start-date" path="businessStartDate" required="required"/>
			<form:errors path="businessStartDate" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>
		</div>
	</div> --%>
	<div class="form-group row">
		<label class="col-md-3 col-form-label required" for="business-type">Business Type:</label>
		<div class="col-md-4">
			<form:select class="form-control" id="business-type" path="businessType" required="required">
				<form:option selected="selected" value="">Select</form:option>
				<form:option value="COR">Corporation</form:option>
				<form:option value="LLC">LLC</form:option>
				<form:option value="PAR">Partnership</form:option>
				<form:option value="SPR">Sole Proprietorship</form:option>
				<form:option value="TST">Trust</form:option>
			</form:select>			
			<form:errors path="businessType" cssClass="error" cssStyle="color: red; font-weight: bold"></form:errors>											
		</div>
		<ul class="form-text text-muted list-style">
			<li>Corporation/Limited Liability Company(LLC) - The business has filed formal papers with the state to become a corporation or LLC</li>
			<li>Partnership - 2 or more persons with a formal partnership agreement</li>
			<li>Sole Proprietorship -  a single person operating the business</li>
			<li>Trust - an entity created to hold assets for the benefit of certain persons or entities</li>
		</ul>	
	</div>
</fieldset>	