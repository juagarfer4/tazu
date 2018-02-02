<%--
 * layout.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<base
	href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="shortcut icon" href="favicon.ico" />

<!-- Mobile Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Google Webfonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,400italic,600,700,600italic,700italic,800,800italic,300italic,300"
	rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Sanchez:400,400italic"
	rel="stylesheet">

<!--[if lt IE 9]>
	<script src="/js/libs/respond.min.js"></script>
	<![endif]-->

<!-- Bootstrap core CSS -->
<link href="styles/css/bootstrap.css" rel="stylesheet">

<!-- Theme Styles CSS-->
<link href="styles/css/style.css" rel="stylesheet">
<link href="styles/css/theme-shop.css" rel="stylesheet">
<link href="styles/css/elements.css" rel="stylesheet">
<link href="styles/fonts/icomoon/iconmoon.css" rel="stylesheet">
<link href="styles/fonts/font-awesome/css/font-awesome.css"
	rel="stylesheet">

<!-- Plugins CSS -->
<link href="styles/js/owl-carousel/owl.carousel.css" rel="stylesheet">
<link href="styles/js/owl-carousel/owl.theme.css" rel="stylesheet">
<link href="styles/js/flexslider/flexslider.css" rel="stylesheet">
<link href="styles/css/isotope.css" rel="stylesheet">
<link href="styles/js/slickNav/slicknav.css" rel="stylesheet">
<link href="styles/js/fancybox/jquery.fancybox.css" rel="stylesheet">


<!--[if lt IE 9]>
	<script src="/js/libs/html5.js"></script>
	<![endif]-->

<link href="styles/styles-box/demo-style-chooser.css" rel="stylesheet">
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<link id="one" rel="stylesheet" href="#">
<link id="two" rel="stylesheet" href="#">
<link id="three" rel="stylesheet" href="#">
<script type="text/javascript" src="styles/styles-box/script.js"></script>

<!-- PAGE FORMAT -->

<title><tiles:insertAttribute name="title" ignore="true" /></title>

</head>

<jstl:set var="req"
	value="${requestScope['javax.servlet.forward.servlet_path']}" />

<body id="home">
	<!-- Si la página en la que se encuentra no es el índice, muestra el header por defecto -->

	<div class="body">
		<jstl:if
			test="${req != '//views/misc/index.jsp' && !req.contains('/dashboard/admin/')}">
			<div class="top-wrap">
				<div class="overlay-bg"></div>
				<tiles:insertAttribute name="header" />
			</div>
		</jstl:if>

		<jstl:if
			test="${req != '//views/misc/index.jsp' && !req.contains('/dashboard/admin/')}">
			<div class="page-wrap container shop-form-wrap">
				<br /> <br />
				<h3>
					<tiles:insertAttribute name="title" />
				</h3>
			</div>
		</jstl:if>

		<tiles:insertAttribute name="body" />

		<jstl:if test="${message != null}">
			<br />
			<div class="alert alert-danger">
			<span class="message"><spring:message code="${message}" /></span>
			</div>
		</jstl:if>

		<security:authorize access="!hasRole('ADMINISTRATOR')">
			<tiles:insertAttribute name="footer" />
		</security:authorize>
	</div>

	<!-- JavaScript -->
	<script src="styles/js/jquery.js"></script>
	<script src="styles/js/bootstrap.js"></script>
	<script src="styles/js/owl-carousel/owl.carousel.js"></script>
	<script src="styles/js/flexslider/jquery.flexslider.js"></script>
	<script src="styles/js/slickNav/jquery.slicknav.min.js"></script>
	<script src="styles/js/jquery.isotope.min.js"></script>
	<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<script src="styles/js/jquery.gmap.js"></script>
	<script src="styles/js/fancybox/jquery.fancybox.pack.js"></script>
	<script src="styles/js/main.js"></script>
	<script src="styles/js/jquery.waterwheelCarousel.js"></script>
	<script src="styles/js/custom-slider.js"></script>

</body>

</html>

<!-- PAGE FORMAT -->