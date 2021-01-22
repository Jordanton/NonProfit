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
<title>Introduction</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<div class="container">
		<h3 class="text-center">Non-Profit Registration Requirements</h3>
		<div class="card">
			<div class="card-body">
				<h5 class="font-weight-bold">I. CRITERIA FOR ONLINE
					REGISTRATION OF NON-PROFIT BUSINESS</h5>
				<p>The online registration process requires that you meet all of
					the criteria listed below to be able to use the online process:</p>
				<ul>
					<li>You are only opening one business location at this time.</li>
					<li>You have never registered your business with the City of
						Los Angeles, Office of Finance.</li>
					<li>Your business is physically located within the City limits
						or the business owner or his employees conducts business within
						the City limits.</li>
					<li class="text-danger"><strong>It is strongly
							advised that you have a printer ready or are using a device in
							which you are able to save files.</strong> A temporary business tax
						registration certificate will be issued for you to print and
						display at your place of business. A permanent certificate will be
						sent via mail and should arrive within 4 weeks from completing
						your online registration. <strong>PLEASE PRINT OR SAVE
							THE CERTIFICATE WHEN IT IS SHOWN.</strong></li>
				</ul>
				<p>
					If you do not meet all of the criteria listed above or if you
					prefer, you may instead <a
						href="https://finance.lacity.org/sites/g/files/wph1051/f/Vendor%20Registration%202%20Page%20Packet.pdf">click
						here to fill out the paper form</a> and email it to <a
						href="mailto:Finance.CustomerService@lacity.org">Finance.CustomerService@lacity.org</a>
					This allows you to request a business tax registration but you will
					not immediately get a temporary certificate like you will with this
					application.
				</p>
				<hr />
				<h5 class="font-weight-bold">II. INFORMATION YOU WILL NEED TO
					PROVIDE TO REGISTER A NON-PROFIT BUSINESS ONLINE</h5>
				<p>Through this online registration process you will be asked to
					provide information about your business. Please have the following
					information at hand for your registration:</p>
				<ul>
					<li>Description of your Business activities</li>
					<li>Legal Business Name
						<div class="ml-3">Business Name - Doing Business As (DBA)
							(optional)</div>
					</li>
					<li>Business Start Date or services rendered inside the city
						of Los Angeles. This is the date that <strong>you will
							begin</strong> your business activities within the city of Los Angeles.
					</li>
					<li>Business Type (such as Sole Proprietorship, Partnership,
						Corporation, etc.)</li>
					<li>Primary Business Address
						<div class="ml-3">Mailing Address - if different from your
							primary business address</div>
					</li>
					<li>FEIN/Tax ID number</li>
					<li>Supporting Documents</li>
				</ul>
				<hr />
				<h5 class="font-weight-bold">III. DOCUMENTS YOU WILL NEED FOR
					YOUR APPLICATION</h5>
				<p>
					Digital copies in <strong>PDF or JPEG/PNG image format</strong>
					will be needed for the following documents:
				</p>
				<ul>
					<li>501(c) 3 IRS Tax Exemption letter OR State Tax Exemption
						letter. Only one of these documents is required.</li>
					<li>If your organization's name has changed since it has been
						established, we will need BOTH the original Articles of
						Incorporation letter AND the <strong>Amended</strong> Articles of
						Incorporation letter
					</li>
					<li>Please contact the Exemption Unit at (213) 978-3050 if you need assistance in identifying these documents.</li>
				</ul>
				<hr />
				<h5 class="font-weight-bold">IV. STEPS TO COMPLETE A NEW
					BUSINESS ONLINE REGISTRATION</h5>
				<ol type="1">
					<li>Exemption Form
						<p>You will be asked to provide the organization's type,
							business activities, required documents, and FEIN/Tax ID Number</p>
					</li>
					<li>Business Form
						<p>You will be asked to provide the following information
							needed to register a new business: Legal Business Name, Business
							Name/Doing Business As (optional), Business Start Date, Business
							Type, Primary Business Address, Mailing Address (if different
							from primary business address), Filer's Contact Information.</p>
					</li>
					<li>Confirmation
						<p>You will be asked to confirm your answers application.</p>
					</li>
					<li>Temporary Tax Registration Certificate
						<p>A temporary business tax registration certificate will be
							issued for you to print and display at your place of business. A
							permanent certificate will be sent via mail and should arrive
							within 4 weeks from completing your on-line registration. Please
							remove the temporary certificate and replace it with the
							permanent certificate.</p>
					</li>
				</ol>

			</div>
			<div class="card-footer text-center">
				<button class="btn btn-secondary" onclick="history.back()">Back</button>
				<button class="btn btn-primary"
					onclick="window.location='exemption'">Next</button>
			</div>
		</div>
	</div>
	<!-- /.container -->
	<jsp:include page="footer.jsp" />
	<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/registration.js?v=06252020"/>"></script>
	<script>
		//Exemption form
		if ($('#articles-checkbox').is(':checked')) {
			$('#articles').show();
			$('.articles-files').prop('required', true);
		} else {
			$('#articles').hide();
			$('.articles-files').prop('required', false);
		}
	</script>
</body>
</html>