<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Error</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />	
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />"/>
<link rel="stylesheet"
	href="<c:url value="/resources/css/registration.css?v=08192020" />"/>
<link rel="icon"
	href="<c:url value="/resources/images/LACitySealColor_small.png"/>"/>
<style>
	#footer {
		position:absolute;
		bottom:0;
	}
</style>
<jsp:include page="header.jsp"/>
</head>
<body>
	<div class="container">
		<div class="mt-3 alert alert-danger">
			An unexpected error occurred when accessing the application or the application is unavailable. Please try again later.
		</div>
	</div>	
	<!-- /.container -->
	<div id="footer">
		<jsp:include page="footer.jsp"/>	
	</div>	
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