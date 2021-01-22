<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ************ CONTACT INFO ************ -->
<%-- <fieldset id="sellers-permit">
	<legend class="px-3">Sales Tax Number</legend>
	<div class="form-group row">
		<small class="col-md-12 form-text">If you have a Sales Tax Number (Seller's Permit) enter it here.</small>
	</div>
	<div class="form-group row">
		<div class="col-md-3">
			<label class="col-form-label" for="sellers-permit-number">Seller's Permit Number:</label>	
		</div>
		<div class="col-md-3">
			<form:input class="form-control" type="text" id="sellers-permit-number" path="sellersPermitNumber"/>
		</div>					
	</div>				
</fieldset>	 --%>
<fieldset id="contact-info">
	<legend class="px-3 legend-section">Filer Information</legend>
	<div class="form-group row">
		<div class="col-md-5">
			<div>
				<label class="col-form-label required" for="first-name-contact">First
					Name:</label>
			</div>
			<div>
				<form:input class="form-control" type="text" id="first-name-contact"
					maxlength="30" path="firstNameContact" required="required"
					autocomplete="given-name" />
				<form:errors path="firstNameContact" cssClass="error"
					cssStyle="color: red; font-weight: bold"></form:errors>
			</div>
		</div>
		<div class="col-md-5">
			<div>
				<label class="col-form-label required" for="last-name-contact">Last
					Name:</label>
			</div>
			<div>
				<form:input class="form-control" type="text" id="last-name-contact"
					maxlength="30" path="lastNameContact" required="required"
					autocomplete="family-name" />
				<form:errors path="lastNameContact" cssClass="error"
					cssStyle="color: red; font-weight: bold"></form:errors>
			</div>
		</div>
		<div class="col-md-2">
			<div>
				<label class="col-form-label" for="name-title-contact">Title:</label>
			</div>
			<div>
				<form:input class="form-control" type="text" id="name-title-contact"
					maxlength="20" path="titleContact" autocomplete="off" />
				<form:errors path="titleContact" cssClass="error"
					cssStyle="color: red; font-weight: bold"></form:errors>
			</div>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-md-12">
			<div>
				<label class="col-form-label required" for="phone-number-contact">Phone
					Number:</label>
			</div>
			<div>
				<form:input type="tel" class="form-control phone-input"
					id="phone-number-contact" path="phoneNumberContact" /> 
				<span class="ext-group"><label
					class="col-form-label" for="phone-extension">Extension</label> <form:input
						class="form-control phone-input" type="tel" pattern="^[0-9]{0,4}"
						id="phone-extension" maxlength="4" path="phoneExtContact" /></span>
			</div>
			<div>
				<form:errors path="phoneNumberContact" cssClass="error"
					cssStyle="color: red; font-weight: bold"></form:errors>
			</div>
			<div>
				<form:errors path="phoneNumberContact" cssClass="error"
					cssStyle="color: red; font-weight: bold"></form:errors>
			</div>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-md-5">
			<div>
				<label class="col-form-label required" for="email-address-contact">Email
					Address:</label>
			</div>
			<div>
				<form:input class="form-control" type="email" autocomplete="email"
					id="email-address-contact" path="emailAddressContact"
					required="required" />
				<form:errors path="emailAddressContact" cssClass="error"
					cssStyle="color: red; font-weight: bold"></form:errors>
			</div>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-md-5">
			<label class="col-form-label" for="business-web-address-contact">Business
				Web Address:</label>
			<form:input class="form-control" type="text"
				id="business-web-address-contact" path="webAddress" />
			<form:errors path="webAddress" cssClass="error"
				cssStyle="color: red; font-weight: bold"></form:errors>
		</div>
	</div>
</fieldset>
<!-- ************ FILER INFO ************ -->
<%-- <fieldset id="filer-info" style="display: none">
	<legend class="px-3">Filer Information</legend>
	<div class="form-group row">
		<small class="col-md-12 form-text"> I declare, under penalty
			or perjury under the laws of the State of California that to the best
			of my knowledge the information provided in this application is true,
			correct and complete.</small>
	</div>
	<div class="form-group row">
		<div class="col-md-12 form-check form-check-inline">
			<input type="checkbox" class="form-check-input" id="filer-checkbox" />
			<label class="form-check-label">Check if same as Business
				Contact</label>
		</div>
	</div>
	<div id="filer-div">
		<div class="form-group row">
			<div class="col-md-5">
				<div>
					<label class="col-form-label required" for="first-name-filer">First
						Name:</label>
				</div>
				<div>
					<form:input class="form-control" type="text" id="first-name-filer"
						path="firstNameFiler" required="required" />
				</div>
			</div>
			<div class="col-md-5">
				<div>
					<label class="col-form-label required" for="last-name-filer">Last
						Name:</label>
				</div>
				<div>
					<form:input class="form-control" type="text" id="last-name-filer"
						path="lastNameFiler" required="required" />
				</div>
			</div>
			<div class="col-md-2">
				<div>
					<label class="col-form-label" for="name-title-filer">Title:</label>
				</div>
				<div>
					<form:input class="form-control" type="text" id="name-title-filer"
						path="titleFiler" />
				</div>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-md-12">
				<div>
					<label class="col-form-label required" for="phone-number-filer">Phone
						Number:</label>
				</div>
				<div>
					<span class="text-nowrap"> <span class="font-weight-bold">(</span>
						<form:input class="form-control phone-input" type="number"
							id="phone-number-filer" max="999" path="phoneAreaCodeFiler"
							placeholder="###" required="required" /> <span
						class="font-weight-bold">)</span> <form:input
							class="form-control phone-input" type="number" max="999"
							path="phoneStartFiler" placeholder="###" required="required" />
						<label class="">-</label> <form:input
							class="form-control phone-input" type="number" max="9999"
							path="phoneEndFiler" placeholder="####" required="required" /></span> <span
						class="ext-group"><label class="col-form-label"
						for="phone-extension">Extension</label> <form:input
							class="form-control phone-input" type="number"
							id="phone-extension" max="999999" path="phoneExtFiler" /></span>
				</div>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-md-5">
				<div>
					<label class="col-form-label required" for="email-address-filer">Email
						Address:</label>
				</div>
				<div>
					<form:input class="form-control" type="email" autocomplete="email"
						id="email-address-filer" path="emailAddressFiler"
						placeholder="your@email.com" required="required" />
				</div>
			</div>
		</div>
	</div>
</fieldset> --%>