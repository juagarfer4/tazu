<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


	<!-- STYLES -->
	<div id="stylesBox">
		<a class="contact"></a>
		<div class="stylesBack">
			<p>
				<spring:message code="master.page.chooseLanguage" />
			</p>
			<div class="pattern-links">
				<a href="?language=es"><span><img src="images/es.png"
						class="img-responsive" /></span></a> <a href="?language=en"><span><img
						src="images/en.png" class="img-responsive" /></span></a>
			</div>
		</div>
	</div>
	<!-- STYLES -->
	
	
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
		