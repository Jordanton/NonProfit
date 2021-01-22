<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Address Confirmation</title>
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
		<form:form id="address-validation" class="form-horizontal"
			action="address-validation" method="post" modelAttribute="address">
			<div id="invisible-form" style="display: hidden;">
				<form:hidden id="stdAddress" path="stdAddress"></form:hidden>
				<form:hidden id="city-new" path="cityNew"></form:hidden>
				<form:hidden id="state-new" path="stateNew"></form:hidden>
				<form:hidden id="zip-new" path="zip"></form:hidden>
				<form:hidden id="stdAddress-mailing" path="stdAddressMailing"></form:hidden>
				<form:hidden id="city-mailing-new" path="cityMailingNew"></form:hidden>
				<form:hidden id="state-mailing-new" path="stateMailingNew"></form:hidden>
				<form:hidden id="zip-mailing-new" path="zipMailing"></form:hidden>
			</div>
			<h3 class="text-center">Address Confirmation</h3>
			<div class="card">
				<div class="card-body">
					<label>Select a matching address or click Continue to
						proceed as is.</label>
					<div class="row">
						<div class="col-lg-12">
							<label>Business Address:</label>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">${businessInfo.streetNumber}
							${businessInfo.streetNumberFraction}
							${businessInfo.directionalPrefix} ${businessInfo.streetName}
							${businessInfo.streetType} ${businessInfo.directionalSuffix}</div>
					</div>
					<div class="row">
						<div class="col-lg-12">${businessInfo.unitType}
							${businessInfo.unitNumber}</div>
					</div>
					<div class="row">
						<div class="col-lg-12">${businessInfo.city},
							${businessInfo.state} ${businessInfo.zipCode}</div>
					</div>
					<c:if test="${empty addressMatches }">
						<div class="row">
							<div class="col-lg-12">
								<hr />
								No suggestions found for this address.
								<hr />
							</div>
						</div>
					</c:if>
					<table class="table table-sm text-left">
						<tbody>
							<c:forEach items="${addressMatches}" var="a" varStatus="item">
								<tr>
									<td>
										<div class="row">
											<div class="mx-3">
												<input type="radio" name="address-business"
													class="address-selector" id="${item.index}-select" />
											</div>
											<div id="${item.index}-item">
												<div id="${item.index}-line1">${a.stdAddress}</div>
												<div>${businessInfo.unitType}
													${businessInfo.unitNumber}</div>
												<span id="${item.index}-city">${a.cityNew}</span> <span
													id="${item.index}-state">${a.stateNew}</span>, <span
													id="${item.index}-zip">${a.zip}</span> - <span
													id="${item.index}-zip4">${a.zip4}</span>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<c:if test="${ businessInfo.oneAddress == false }">
						<div class="row">
							<div class="col-lg-12">
								<label>Mailing Address:</label>
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
							<div class="col-lg-12">${businessInfo.unitTypeMailing}
								${businessInfo.unitNumberMailing}</div>
						</div>
						<div class="row">
							<div class="col-lg-12">${businessInfo.cityMailing},
								${businessInfo.stateMailing} ${businessInfo.zipCodeMailing}</div>
						</div>
						<c:if test="${empty addressMatchesMailing }">
							<div class="row">
								<div class="col-lg-12">
									<hr />
									No suggestions found for this address.
									<hr />
								</div>
							</div>
						</c:if>
						<table class="table table-sm text-left" id="mailing-address-table">
							<tbody>
								<c:forEach items="${addressMatchesMailing}" var="m"
									varStatus="item">
									<tr>
										<td>
											<div class="row">
												<div class="mx-3">
													<input type="radio" name="address-mailing"
														class="address-selector-mailing"
														id="${item.index}-select-mailing" />
												</div>
												<div id="${item.index}-item-mailing">
													<div id="${item.index}-line1-mailing">${m.stdAddress}</div>
													<div>${businessInfo.unitTypeMailing}
														${businessInfo.unitNumberMailing}</div>
													<span id="${item.index}-city-mailing">${m.cityNew}</span> <span
														id="${item.index}-state-mailing">${m.stateNew}</span>, <span
														id="${item.index}-zip-mailing">${m.zip}</span> - <span
														id="${item.index}-zip4-mailing">${m.zip4}</span>
												</div>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
				</div>
				<div class="card-footer text-center">
					<button class="btn btn-secondary" type="button"
						onclick="window.location.href='../nonprofit/application'">Back</button>
					<button class="btn btn-primary" type="submit" onclick="submitAddress()">Continue</button>
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
</body>
</html>