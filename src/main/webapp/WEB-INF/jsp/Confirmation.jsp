<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Confirmation</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />"/>
<link rel="stylesheet"
	href="<c:url value="/resources/css/registration.css?v=08192020" />"/>
<link rel="icon"
	href="<c:url value="/resources/images/LACitySealColor_small.png"/>"/>
<jsp:include page="header.jsp" />
</head>
<body>
	<div class="container" id="confirmation-info">
		<h3 class="text-center">Registration Confirmation</h3>
		<form:form action="register" method="post"
			modelAttribute="businessInfo" onsubmit="document.getElementById('submit').disabled = true; return true;">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-lg-12" id="form-warning">
							<strong>This form has NOT YET BEEN SUBMITTED. <br/>Please
								review your submission and click 'Register' to proceed.
							</strong>
						</div>
					</div>
					<fieldset>
						<legend class="px-3 legend-section">Exemption Information <span class="change-link"><a href="../nonprofit/exemption">Change</a></span></legend>
						<div class="row">
							<label class="col-lg-3">Exemption Type:</label>
							<div class="col-lg-3" id="exemption-id">${exemptionInfo.exemptionId}</div>
						</div>
						<hr/>
						<div class="row">
							<label class="col-lg-3">Fund Class Category:</label>
							<div class="col-lg-3">
								<c:forEach items="${exemptionInfo.fundClass}" var="item">
									<div>${item}</div>
								</c:forEach>
							</div>
						</div>
						<hr/>
						<div class="row">
							<label class="col-lg-3">FEIN/Tax ID:</label>
							<div class="col-lg-3">${exemptionInfo.fein}</div>
						</div>
						<hr/>
						<div class="row">
							<label class="col-lg-3">Files Uploaded:</label>
							<div class="col-lg-3">
								<c:forEach items="${exemptionInfo.fileNames}" var="item">
									<div>${item}</div>
								</c:forEach>
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend class="px-3 legend-section">Business Information <span class="change-link"><a href="../nonprofit/application">Change</a></span></legend>
						<div class="row">
							<label class="col-lg-3">Business Description:</label>
							<div class="col-lg-3">${businessInfo.businessDescription}</div>
						</div>
						<hr/>
						<div class="row">
							<label class="col-lg-3">Legal Name:</label>
							<div class="col-lg-3">${businessInfo.businessLegalName}</div>
						</div>
						<hr/>
						<div class="row">
							<label class="col-lg-3">DBA Name:</label>
							<div class="col-lg-3">${businessInfo.dbaName}</div>
						</div>
						<hr/>
						<div class="row">
							<label class="col-lg-3">Business Type:</label>
							<div class="col-lg-3" id="business-type">${businessInfo.businessType}</div>
						</div>
						<hr/>
						<div class="row">
							<label class="col-lg-3">Business Start Date:</label>
							<div class="col-lg-3">${businessInfo.businessStartDate}</div>
						</div>
						<hr/>
						<div class="row">
							<div class="col-lg-12 text-underline">
								Business Address
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">${businessInfo.streetNumber}
								${businessInfo.streetNumberFraction}
								${businessInfo.directionalPrefix} ${businessInfo.streetName}
								${businessInfo.streetType} ${businessInfo.directionalSuffix}</div>
						</div>
						<div class="row">
							<div class="col-lg-12">
								${businessInfo.unitType} ${businessInfo.unitNumber}
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">${businessInfo.city},
								${businessInfo.state} ${businessInfo.zipCode}</div>
						</div>
						<div class="row">
							<label class="col-lg-3">Location Type:</label>
							<div class="col-lg-3" id="location-type">${businessInfo.locationType}</div>
						</div>
						<hr/>
						<div class="row">
							<div class="col-lg-12 text-underline">
								Mailing Address
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">${businessInfo.streetNumberMailing}
								${businessInfo.streetNumberFractionMailing}
								${businessInfo.directionalPrefixMailing}
								${businessInfo.streetNameMailing}
								${businessInfo.streetTypeMailing}
								${businessInfo.directionalSuffixMailing}</div>
						</div>
						<div class="row">
							<div class="col-lg-12">
								${businessInfo.unitTypeMailing} ${businessInfo.unitNumberMailing}
							</div>
						</div>						
						<div class="row">
							<div class="col-lg-12">${businessInfo.cityMailing},
								${businessInfo.stateMailing} ${businessInfo.zipCodeMailing}</div>
						</div>
						<div class="row">
							<label class="col-lg-3">Location Type:</label>
							<div class="col-lg-3" id="location-type-mailing">${businessInfo.locationTypeMailing}</div>
						</div>
						<hr/>
						<div class="row">
							<div class="col-lg-12 text-underline">
								Filer Information
							</div>
						</div>
						<div class="row">
							<label class="col-lg-3">First Name:</label>
							<div class="col-lg-3">${businessInfo.firstNameContact}</div>
						</div>
						<div class="row">
							<label class="col-lg-3">Last Name:</label>
							<div class="col-lg-3">${businessInfo.lastNameContact}</div>
						</div>
						<div class="row">
							<label class="col-lg-3">Title:</label>
							<div class="col-lg-3">${businessInfo.titleContact}</div>
						</div>
						<div class="row">
							<label class="col-lg-3">Phone:</label>
							<div class="col-lg-2">${businessInfo.phoneNumberContact}</div>
							<label class="col-lg-3">Ext:</label>
							<div class="col-lg-2">${businessInfo.phoneExtContact}</div>
						</div>
						<div class="row">
							<label class="col-lg-3">Email:</label>
							<div class="col-lg-3">${businessInfo.emailAddressContact}</div>
						</div>
						<div class="row">
							<label class="col-lg-3">Business Web Address:</label>
							<div class="col-lg-3">${businessInfo.webAddress}</div>
						</div>
					</fieldset>
				</div>
				<div class="card-footer text-center">
					<button class="btn btn-secondary" type="button" onclick="window.location.href='../nonprofit/address-validation'">Back</button>
					<button class="btn btn-primary" id="submit" type="submit">Register</button>
				</div>
			</div>
		</form:form>
	</div>
	<!-- /.container -->
	<jsp:include page="footer.jsp" />
	<script
		src="<c:url value="/resources/js/jquery.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/registration.js?v=08192020"/>"></script>
	<script>
		var ex = $('#exemption-id');
		if (ex.text() == '13') {
			ex.text('Educational');
		}
		if (ex.text() == '14') {
			ex.text('Charitable Organization');
		}
		if (ex.text() == '15') {
			ex.text('Service Organization');
		}
		if (ex.text() == '16') {
			ex.text('Religious');
		}
		if (ex.text() == '28') {
			ex.text('Undefined');
		}

		var bt = $('#business-type');
		if (bt.text() == 'COR') {
			bt.text('Corporation');
		}
		if (bt.text() == 'LLC') {
			bt.text('LLC');
		}
		if (bt.text() == 'PAR') {
			bt.text('Partnership');
		}
		if (bt.text() == 'SPR') {
			bt.text('Sole Proprietorship');
		}
		if (bt.text() == 'TST') {
			bt.text('Trust');
		}

		var lt = $('#location-type');
		if (lt.text() == 'Y') {
			lt.text('Commercial')
		} else {
			lt.text('Residential')
		}

		lt = $('#location-type-mailing');
		if (lt.text() == 'Y') {
			lt.text('Commercial')
		} else {
			lt.text('Residential')
		}
	</script>
</body>
</html>