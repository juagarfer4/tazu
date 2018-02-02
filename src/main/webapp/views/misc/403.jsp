<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<!--[if IE 8]>			<html class="ie ie8"> <![endif]-->
<!--[if IE 9]>			<html class="ie ie9"> <![endif]-->
<!--[if gt IE 9]><!-->
<html>
<!--<![endif]-->

<!-- Mirrored from chemistry.beantownthemes.com/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 05 Apr 2016 15:49:48 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<!-- /Added by HTTrack -->
<head>

<!-- Meta -->
<meta charset="utf-8">
<meta name="description"
	content="Chemistry - Responsive Muti-Purpose Portfolio Template">
<meta name="author" content="">

<!-- Mobile Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Favicons -->
<link rel="shortcut icon" href="favicon.ico">

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

<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script',
			'https://www.google-analytics.com/analytics.js', 'ga');

	ga('create', 'UA-76488154-1', 'auto');
	ga('send', 'pageview');
</script>

</head>
<body id="home">

	<!-- STYLES -->
	<div id="stylesBox">
		<a class="contact"></a>
		<div class="stylesBack">
			<p>
				<spring:message code="master.page.chooseLanguage" />
			</p>
			<div class="pattern-links">
				<a href="/tazu/?language=es"><span><img src="images/es.png"
						class="img-responsive" /></span></a> <a href="/tazu/?language=en"><span><img
						src="images/en.png" class="img-responsive" /></span></a>
			</div>
		</div>
	</div>
	<!-- STYLES -->

	<div class="top-wrap">
		<div class="overlay-bg"></div>

		
<!-- Header -->
		<header>
			<div class="container">
				<div class="col-md-12">

					<!-- Logo -->
					<h1 class="logo">
						<a href=""><img src="images/logo.png" class="img-responsive"
							alt="img" /></a>
					</h1>

					<!-- Nav Menu -->
					<div id='cssmenu'>
						<ul>
							<li class='last'><a href=""><span><spring:message
											code="master.page.home" /></span></a></li>

							<li class='last'><a href='about.do'><span><spring:message
											code="master.page.aboutus" /></span></a></li>

							<li class='last'><a href="artwork/listOnSale.do"><span><spring:message
											code="master.page.artworks" /></span></a></li>

							<li class='last'><a href="artist/list.do"><span><spring:message
											code="master.page.artist.list" /></span></a></li>

							<!-- 						 ADMIN NAV  -->
							<%-- 					<security:authorize access="hasRole('ADMINISTRATOR')"> --%>

							<%-- 						<li class='has-sub'><a href="#"><span><spring:message code="master.page.artworks" /></span></a> --%>
							<!-- 							<ul> -->
							<%-- 							<li><a href="artwork/administrator/listOnSale.do"> <spring:message code="master.page.onsale" /></a></li> --%>
							<%-- 							<li><a href="artwork/administrator/listOnSale.do"> <spring:message code="master.page.sold" /></a></li> --%>
							<!-- 							</ul> -->
							<!-- 						</li> -->

							<%-- 						<li class='has-sub'><a href="artist/list.do"><span><spring:message code="master.page.artist.list" /></span></a> --%>
							<!-- 							<ul> -->
							<!-- 							</ul> -->
							<!-- 						</li> -->
							<%-- 						<li class='has-sub'><a href="purchaser/administrator/list.do"><span><spring:message code="master.page.purchasers" /></span></a> --%>
							<!-- 							<ul> -->
							<!-- 							</ul> -->
							<!-- 						</li> -->

							<%-- 	        		</security:authorize> --%>


							<!--  PURCHASER NAV  -->
							<security:authorize access="hasRole('PURCHASER')">
								<li class='last'><a href="artwork/purchaser/listInCart.do"><span><spring:message
												code="master.page.purchaser.cart" />(<jstl:out
												value="${cookie.cartAmount.value}"></jstl:out>)</span></a></li>
							</security:authorize>

							<!--  Anonymous NAV  -->
							<security:authorize access="isAnonymous()">
								<li class='last'><a href="security/login.do"><span><spring:message
												code="master.page.login" /> <i class="icon-enter3"></i></span></a>
							</security:authorize>

							<!--  Authenticated NAV  -->
							<security:authorize access="isAuthenticated()">
								<li class='has-sub'><a><span><security:authentication
												property="principal.username" /> <i class="icon-user"></i></span></a>
									<ul>
										<security:authorize access="hasRole('PURCHASER')">
											<li><a href="order/purchaser/list.do"> <spring:message
														code="master.page.purchaser.orders" /></a></li>
											<li><a href="review/purchaser/list.do"> <spring:message
														code="master.page.purchaser.reviews" /></a></li>
										</security:authorize>

										<security:authorize access="hasRole('ARTIST')">
											<li><a href="artwork/artist/myList.do"> <spring:message
														code="master.page.artist.myartworks" /></a></li>
											<li><a href="artwork/artist/create.do"> <spring:message
														code="master.page.artist.uploadartwork" /></a></li>
											<li><a href="orderLine/artist/list.do"> <spring:message
														code="master.page.artist.myorders" /></a></li>
											<li><a href="review/artist/list.do"> <spring:message
														code="master.page.artist.myreviews" /></a></li>
										</security:authorize>

										<li><a href="j_spring_security_logout"> <spring:message
													code="master.page.logout" /> <i class="icon-exit"></i></a></li>
									</ul></li>
							</security:authorize>

						</ul>
					</div>
				</div>
			</div>
			<br>
			<br>
		</header>
		<!-- Header -->

	

		<div class="space40"></div>

	</div>
	<div class="page-wrap container wrap-404">
		<div class="space30"></div>
		<div class="col-md-12 no-padding columns mb0">
			<i class="icon-confused icon-404"></i>
			<h1>
				<spring:message code="panic.lost"></spring:message>
			</h1>
		</div>
	</div>

	<div class="divider"></div>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="col-md-3 footer-widget">
				<h6>
					<spring:message code="master.page.links" />
				</h6>
				<ul class="link-list">
					<li><a href="privacy/cookies.do">&rarr;<spring:message
								code="master.page.cookies" /></a></li>
					<li><a href="privacy/policy.do">&rarr;<spring:message
								code="master.page.policy" />
					</a></li>
					<li><a href="privacy/lopd-lssi.do">&rarr;<spring:message
								code="master.page.terms" /></a></li>
				</ul>
			</div>
			<div class="col-md-3 footer-widget">
				<h6>Contact</h6>
				<p>
					Av. de la Reina Mercedes<br>Escuela Técnica Superior de
					Ingeniería Informática<br>Sevilla
				</p>
			</div>
			<div class="col-md-6 footer-widget">
				<a href=""><img src="images/logo_footer.png"
					class="img-responsive" alt="img" width="150" height="150" /></a>
				<p>
					<spring:message code="master.page.about.info" />
					<spring:message code="master.page.about.info2" />
				</p>
			</div>
		</div>
	</footer>
	<div class="footer-copy">
		<div class="container">
			<div class="col-md-12">
				<p>&copy; Copyright 2016 tazú - ISPP</p>
			</div>
		</div>
	</div>
	<!-- Footer -->
</body>
</html>