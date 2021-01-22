<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Certificate</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/registration.css?v=08192020" />" />
<link rel="icon"
	href="<c:url value="/resources/images/LACitySealColor_small.png"/>" />
</head>
<style>
@media print {
	.container {
		width: auto;
	}
}
</style>
<body>
	<div class="m-3 d-print-none">
		<div class="text-center">
			Your registration is complete. You are <strong>strongly</strong>
			advised to print a copy of this certificate at this time. An official
			certificate will be issued after review.
		</div>
	</div>
	<div class="container" id="certificate-container">
		<div id="certificate-items">
			<div class="row">
				<h5 class="col-md-12 col-sm-12 text-center">
					<strong>THIS CERTIFICATE MUST BE POSTED AT PLACE OF
						BUSINESS</strong>
				</h5>
			</div>
			<div class="row">
				<h5 class="col-md-12 col-sm-12 text-center">
					<strong>City of Los Angeles TEMPORARY Tax Registration
						Certificate</strong>
				</h5>
			</div>
			<hr />
			<div class="row">
				<label class="col-md-6 col-sm-6 text-center">BUSINESS TAX</label> <label
					class="col-md-6 col-sm-6 text-center">APPLICATION DATE:
					${currentDate}</label>
			</div>
			<div class="row" id="table-div">
				<table class="table table-sm table-bordered text-center">
					<thead>
						<tr>
							<th>BUSINESS ACCOUNT NO.</th>
							<th>FUND CLASS</th>
							<th>DESCRIPTION</th>
							<th>STARTED</th>
							<th>STATUS</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${businessInfo.registrationNumber}</td>
							<td><c:forEach items="${exemptionInfo.fundClass}" var="item">
							    	${item} 
								</c:forEach></td>
							<td>${businessInfo.businessDescription}</td>
							<td>${businessInfo.businessStartDate}</td>
							<td>Pending</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="row">
				<label class="col-md-4 col-sm-4">${businessInfo.businessLegalName}</label>
				<label class="col-md-4 col-sm-4 offset-md-4 offset-sm-4">Expiration
					Date: ${expirationDate }</label>
			</div>
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="address-label">Primary Business Address:</div>
					<div>${businessInfo.streetNumber}
						${businessInfo.streetNumberFraction}
						${businessInfo.directionalPrefix} ${businessInfo.streetName}
						${businessInfo.directionalSuffix} ${businessInfo.streetType}</div>
					<div>${businessInfo.unitType}${businessInfo.unitNumber}</div>
					<div>${businessInfo.city}, ${businessInfo.state} ${businessInfo.zipCode}</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="address-label">Mailing Address:</div>
					<div>${businessInfo.streetNumberMailing}
						${businessInfo.streetNumberFractionMailing}
						${businessInfo.directionalPrefixMailing}
						${businessInfo.streetNameMailing}
						${businessInfo.directionalSuffixMailing}
						${businessInfo.streetTypeMailing}</div>
					<div>${businessInfo.unitTypeMailing}
						${businessInfo.unitNumberMailing}</div>
					<div>${businessInfo.cityMailing}, ${businessInfo.stateMailing} ${businessInfo.zipCodeMailing}</div>
				</div>
			</div>
			<hr />
			<div class="row">
				<label class="col-md-12 col-sm-12">ISSUED BY: OFFICE OF
					FINANCE REGISTRATION WEBSITE</label>
			</div>
			<hr />
			<div class="row">
				<label class="col-md-12 col-sm-12 text-center text-underline">PLEASE
					READ ALL INFORMATION CAREFULLY</label>
			</div>
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<small><span class="font-weight-bold">Sections
							21.08(b) / 21.7.6(4) Los Angeles Municipal Code</span><br> "This
						business tax registration certificate (and/or) Transient Occupancy
						Registration Certificate signifies that the person named on the
						face hereof has fulfilled the requirements of Article 1 of Chapter
						II of the Los Angeles Municipal Code (and/or) the Uniform
						Transient Occupancy Tax Ordinance, by registering with the
						Director of Finance for the purpose of paying business tax for the
						classification of business for which this certificate is issued
						(and/or) collecting from transients the Transient Occupancy Tax
						and remitting said tax to the Director of Finance. This
						certificate does not authorize the person to conduct any unlawful
						business or to conduct any lawful business in an illegal (or)
						unlawful manner or to conduct within the City of Los Angeles the
						business for which this certificate has been issued, nor to
						operate a hotel, without strictly complying with all the
						provisions of the ordinances of said City (or) all local
						applicable laws, including but not limited to those requiring a
						permit from any board, commission, department or office of the
						City. THIS BUSINESS TAX REGISTRATION CERTIFICATE (AND/OR)
						CERTIFICATE DOES NOT CONSTITUTE A PERMIT. Any failure to comply
						with the requirements of Article 1 of Chapter II of the Los
						Angeles Municipal Code shall constitute grounds for suspension of
						this certificate."<br></small>
				</div>
				<div class="col-md-12 col-sm-12">
					<small>This certificate is void upon any change of
						ownership or location. Annual taxes are due and payable January
						1st each year and delinquent if not paid on or before the last day
						of February each year. Quarterly taxes are due and payable on the
						first day of January, April, July, and October of each year, and
						delinquent if not paid on or before the last day of the month due.</small>
				</div>
			</div>
			<hr />
			<div class="row">
				<div class="col-md-12 col-sm-12 text-center">
					<label>STATE BOARD OF EQUALIZATION NOTICE</label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<small>Sales or use tax may apply to your business
						activities. You may seek written advice regarding the application
						of tax to your particular business by writing to the nearest State
						Board of Equalization office.</small>
				</div>
			</div>
		</div>
	</div>
	<div class="text-center d-print-none">
		<button class="btn btn-secondary" type="button"
			onclick="window.location.href='../nonprofit/'">Return to
			Start</button>
		<button class="btn btn-info" type="button" onclick="window.print()">Print</button>
	</div>
	<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/registration.js?v=08192020"/>"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.0.272/jspdf.debug.js"></script>
	<script type="text/javascript">
		$(document).ready(function genPDF() {
			html2canvas(document.getElementById("certificate-container"), {
				windowWidth : 800,
				onrendered : function(canvas) {
					var img = canvas.toDataURL("image/png", 1);
					var doc = new jsPDF("1", "mm", "a4");
					doc.addImage(img, "JPEG", 10, 10, 190, 150);
					doc.save("Certificate.pdf");
				}
			});
		});
	</script>
</body>
</html>