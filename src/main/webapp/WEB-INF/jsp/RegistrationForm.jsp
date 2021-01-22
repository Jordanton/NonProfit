<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Registration Form</title>
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
	<div class="container">
		<h3 class="text-center">New Business Registration Application</h3>
		<form:form id="registration-form" class="form-horizontal"
			action="application" method="post" modelAttribute="businessInfo">
			<div class="card">
				<div class="card-body">
					<form:errors cssClass="error"
						cssStyle="color: red; font-weight: bold"></form:errors>
					<div class="form-text form-group">When registering your
						business, be sure to be thorough and provide all necessary
						information to facilitate the registration of your business. Also
						include a telephone number and email address (see Filer section
						below) where we may contact you should any questions arise.</div>
					<div class="form-group row">
						<label class="col-md-12 form-text required">indicates
							required field</label>
					</div>
					<jsp:include page="BusinessDetails.jsp" />
					<jsp:include page="BusinessAddress.jsp" />
					<jsp:include page="ContactInfo.jsp" />
					<hr />
					<div class="form-group row">
						<div class="col-md-12 form-check form-check-inline">
							<input type="checkbox" class="form-check-input" required/> <label
								class="col-md-12 form-check-label required">I certify under penalty of
								perjury under the laws of the State of California, that the
								information I have provided in this application is true and
								correct.</label>
						</div>
					</div>
				</div>
				<div class="card-footer text-center">
					<button class="btn btn-secondary" type="button" onclick="window.location.href='../nonprofit/exemption'">Back</button>
					<button class="btn btn-primary" type="submit" onclick="submitForm()">Review</button>
				</div>
			</div>
		</form:form>
	</div>
	<!-- /.container -->
	<jsp:include page="footer.jsp" />
	<script
		src="<c:url value="/resources/js/jquery.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/jquery.inputmask.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/registration.js?v=08192020"/>"></script>
	<script>
		$('#phone-number-contact').inputmask("(999) 999-9999");
		toggleMailing();
	</script>
</body>
</html>