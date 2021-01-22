<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/registration.css?v=08192020" />" />
<link rel="icon"
	href="<c:url value="/resources/images/LACitySealColor_small.png"/>" />
<title>Business Activities</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<div class="container">
		<h3 class="text-center">Non-Profit Exemption Application</h3>
		<form:form class="form-horizontal" id="exemption-form"
			onSubmit="return submitExemption()" modelAttribute="exemptionInfo"
			method="post" action="exemption" enctype="multipart/form-data">
			<div class="card">
				<div class="card-body">
					<form:errors cssClass="error"
						cssStyle="color: red; font-weight: bold"></form:errors>
					<div class="form-group row">
						<label class="col-12 form-text required">indicates
							required field</label>
					</div>
					<fieldset>
						<legend class="px-3 legend-section">Business Activities</legend>
						<div class="form-group row">
							<div class="col-md-4">
								<label class="col-form-label required">Applicant is:</label> <label
									class="col-form-label text-muted">This is the exemption
									that you will be requesting.</label>
							</div>
							<div class="col-md-3">
								<form:select class="form-control" id="exemption-id"
									path="exemptionId" required="required">
									<form:option value="">Select</form:option>
									<form:options items="${exemptionType}" itemValue="value"
										itemLabel="label" />
								</form:select>
								<form:errors path="exemptionId" cssClass="error"
									cssStyle="color: red; font-weight: bold"></form:errors>
							</div>
						</div>
						<hr />
						<jsp:include page="BusinessActivities.jsp" />
					</fieldset>
					<fieldset>
						<legend class="px-3 legend-section">Tax Information and
							Supporting Documents</legend>
						<div class="form-group row">
							<div class="col-md-12">
								<label class="form-check-label required">Please attach a
									copy of either your 501(c)3 IRS Exemption Letter or your State
									Tax Exemption Letter. </label>
							</div>
						</div>
						<form:errors path="file" cssClass="error"
							cssStyle="color: red; font-weight: bold"></form:errors>
						<div class="form-group row">
							<div class="col-12">
								<div>
									<label>Internal Revenue Service Tax Exemption Letter
										(877-829-5500)</label> <br /> <label>State of California
										Franchise Tax Exemption Letter (800-852-5711)</label> <br /> <input
										type="file" id="exemption-file" name="file"
										accept="image/*,.pdf" required onchange="checkFileSize('#exemption-file')" data-toggle="tooltip" data-placement="right" title="File does not meet restrictions"/>
								</div>
								<label class="form-text text-danger">Only PDF files or
									PNG, JPEG/JPG images are accepted.  Size limit per file: 10MB</label>
							</div>
						</div>
						<%-- <div class="form-group row">
							<div class="col-md-9 offset-md-3 form-check">
								<label class="form-text text-muted">OR</label>
							</div>
						</div> -->
						<!-- <div class="form-group row">
							<div class="col-md-9 offset-md-3 form-check">
								<div>
									<label>State of California Franchise Tax Exemption
										Letter (800-852-5711)</label> <br /> <input type="file"
										id="state-exemption-file" name="file" accept="image/*,.pdf"
										required />
								</div>
							</div>
						</div> --%>
						<div class="form-group row">
							<div class="mx-3">
								<label class="required">FEIN/Tax ID Number:</label>
								<form:input class="form-control" type="text" id="fein"
									path="fein" maxlength="9" placeholder="XXXXXXXXX"
									required="required" pattern="^[0-9]{9}$" />
								<label class="form-text text-muted">Please enter WITHOUT
									dashes</label>
								<form:errors path="fein" cssClass="error"
									cssStyle="color: red; font-weight: bold"></form:errors>
							</div>
						</div>
						<div class="form-group row">
							<label class="form-text col-md-12"> If the current name
								of your organization has changed since the IRS or State
								Franchise Tax Exempt Letters were provided, you must submit
								copies of the Articles of Incorporation, and amended Articles of
								Incorporation showing the current name of the organization. </label>
						</div>
						<div class="form-group row">
							<div class="form-check form-check-inline row checkbox-highlight">
								<form:checkbox path="nameChanged" id="articles-checkbox"
									class="form-check-input fund-class-input"
									data-toggle="collapse" data-target="#articles" />
								<label class="form-check-label">Check here if your
									organization's name has been changed.</label>
							</div>
						</div>
						<div id="articles" class="collapse">
							<div class="form-group row">
								<div class="col-md-9 offset-md-3 form-check">
									<div>
										<label class="required">Original Articles of
											Incorporation</label> <br /> <input type="file"
											class="articles-files" id="articles-1" name="file" accept="image/*,.pdf" onchange="checkFileSize('#articles-1')" data-toggle="tooltip" data-placement="right" title="File does not meet restrictions"/>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-9 offset-md-3 form-check">
									<div>
										<label class="required">Amended Articles of
											Incorporation</label> <br /> <input type="file"
											class="articles-files" id="articles-2" name="file" accept="image/*,.pdf" onchange="checkFileSize('#articles-2')" data-toggle="tooltip" data-placement="right" title="File does not meet restrictions"/>
									</div>
								</div>
							</div>
							<label class="form-text text-danger">Only PDF files or
									PNG, JPEG/JPG images are accepted.  Size limit per file: 10MB</label>
						</div>
					</fieldset>
				</div>
				<div class="form-group row">
					<div class="g-recaptcha m-auto" data-sitekey="${siteKey}" data-callback="enableSubmit" data-expired-callback="disableSubmit"></div>
				</div>
				<div class="card-footer text-center">
					<button class="btn btn-secondary" type="button"
						onclick="window.location.href='../nonprofit/'">Back</button>
					<button id="submit-button" class="btn btn-danger cursor-not-allowed" type="submit" disabled>Next</button>
				</div>
			</div>
		</form:form>
	</div>
	<!-- /.container -->
	<jsp:include page="footer.jsp" />
	<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/registration.js?v=08192020"/>"></script>
	<script>
		//Exemption form
		if ($('#articles-checkbox').is(':checked')) {
			$('#articles').show();
			$('.articles-files').prop('required', true);
		} else {
			$('#articles').hide();
			$('.articles-files').prop('required', false);
		}
		
		$(function() {
			$('[data-toggle="tooltip"]').tooltip({trigger: 'manual'})
		})		
	</script>
	<script src="https://www.google.com/recaptcha/api.js"></script>
</body>
</html>