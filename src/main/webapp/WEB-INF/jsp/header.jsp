<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/LATAXStyle.css" />"/>
</head>
<body>
<div>
	<div>
		<a href="http://finance.lacity.org/" target="_blank" title="Home"><img class="logo-1" src="${pageContext.request.contextPath}/resources/images/finance_logo.png"></a>
	</div>    
    <div id="background-opacity"></div>    
    <div>
    	<img class="banner-1" src="${pageContext.request.contextPath}/resources/images/short_hero.jpg">
    </div>      
</div>
<div id="google_translate_element"></div>
</body>
<script src="//navbar.lacity.org/global_nav.js"></script> 
<script type="text/javascript">
	function googleTranslateElementInit() {
	  new google.translate.TranslateElement({pageLanguage: 'en'}, 'google_translate_element');
	}
</script>	
<script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script> 	
</html>