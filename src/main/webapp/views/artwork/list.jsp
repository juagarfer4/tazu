<%--
 * list.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

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


<head>
<link rel="stylesheet" type="text/css" href="styles/firewall/style.css" />
<link rel="stylesheet" type="text/css"
	href="styles/firewall/pinterest-style.css" />
<script type="text/javascript"
	src="styles/freewall/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="styles/freewall/freewall.js"></script>
<style type="text/css">
.free-wall {
	margin: 15px;
}

.brick {
	width: 221.2px;
}

.brick img {
	margin: 0px;
	padding: 0px;
	display: block;
}

#imaginary_container {
	margin-top: 20%; /* Don't copy this */
}

.stylish-input-group .input-group-addon {
	background: white !important;
}

.stylish-input-group .form-control {
	border-right: 0;
	box-shadow: 0 0 0;
	border-color: #ccc;
}

.stylish-input-group button {
	border: 0;
	background: transparent;
}
</style>
</head>

<!-- Main content -->
<div class="page-wrap container">
	<!-- Shop Content -->
	<div role="main" class="main shop">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<form action="${keywordURI}" method="get">
							<div class="input-group stylish-input-group">
								<input type="text" class="form-control" name="keyword"
									placeholder="<spring:message code="artwork.keyword"></spring:message>">
								<span class="input-group-addon"><button type="submit">
										<i class="fa fa-search"></i>
									</button></span>
							</div>
						</form>
					</div>
				</div>
				<div class="space20"></div>
				<div class="row">
					<security:authorize access="hasRole('ARTIST')">

						<div class="table-responsive">
							<display:table name="artworks" id="row"
								requestURI="${requestURI}" pagesize="5"
								class="shop_table cart table-hover table-striped table-condensed">

								<display:column property="title" titleKey="artwork.title" />

								<display:column property="discipline"
									titleKey="artwork.discipline" />

								<display:column titleKey="artwork.heigth">
									<fmt:formatNumber type="number" minFractionDigits="2"
										value="${row.height}" />
								</display:column>

								<display:column titleKey="artwork.width">
									<fmt:formatNumber type="number" minFractionDigits="2"
										value="${row.width}" />
								</display:column>

								<display:column property="moment" titleKey="artwork.moment"
									format="{0,date,dd/MM/yyyy}" />

								<display:column titleKey="artwork.totalcost">
									<fmt:formatNumber type="number" minFractionDigits="2"
										value="${row.totalCost}" />
								</display:column>

								<display:column property="status" titleKey="artwork.status" />

								<display:column titleKey="artwork.options">
									<a href="artwork/display.do?artworkId=${row.id}"> <spring:message
											code="artwork.display" />
									</a>
								</display:column>

								<jstl:if test="${requestURI == 'artwork/artist/myList.do'}">
									<security:authorize access="hasRole('ARTIST')">
										<display:column titleKey="artwork.delete">
											<jstl:if
												test="${row.status=='SALE' && row.carts.isEmpty() == true }">
												<a href="artwork/artist/delete.do?artworkId=${row.id}">
													<spring:message code="artwork.delete" />
												</a>
											</jstl:if>

										</display:column>
									</security:authorize>
								</jstl:if>

								<jstl:if test="${requestURI == 'artwork/artist/myList.do'}">
									<security:authorize access="hasRole('ARTIST')">
										<display:column titleKey="artwork.edit">
											<jstl:if
												test="${row.status=='SALE' && row.carts.isEmpty() == true }">
												<a href="artwork/artist/edit.do?artworkId=${row.id}"> <spring:message
														code="artwork.edit" />
												</a>
											</jstl:if>

										</display:column>
									</security:authorize>
								</jstl:if>
							</display:table>
						</div>
					</security:authorize>
					
					<div class="space40"></div>

					<security:authorize access="hasRole('ARTIST')">
						<input class="btn btn-primary btn-green uppercase pull-right"
							type="button" name="create"
							value="<spring:message code="artwork.create"/>"
							onclick="javascript: window.location.replace('artwork/artist/create.do')" />
					</security:authorize>

					<security:authorize access="!hasRole('ARTIST')">
						<div id="freewall" class="free-wall">

							<div class="products thumb-info-list">
								<div class="col-md-3 product">
									<jstl:forEach items="${artworks}" var="artwork">
										<div class="brick">

											<a href="cart/purchaser/addToCart.do?artworkId=${artwork.id}">
												<span class="onsale"><img src="images/cart.png"
													width="25px" height="25px"
													style="margin-left: 7px; margin-top: 8px" /></span>
											</a> <span class="thumb-info"> <a
												href="artwork/display.do?artworkId=${artwork.id}"> <span
													class="thumb-info-image"> <span
														class="thumb-info-act"> <span
															class="thumb-info-act-left"><em><spring:message
																		code="artwork.info.view"></spring:message></em></span> <span
															class="thumb-info-act-right"><em><i
																	class="fa fa-plus"></i> <spring:message
																		code="artwork.info.details"></spring:message></em></span>
													</span> <img alt="img" class="img-responsive"
														src="artwork/show.do?artworkId=${artwork.id}">
												</span>
											</a> <span class="thumb-info-content"> <a
													href="artwork/display.do?artworkId=${artwork.id}">
														<h4>
															<jstl:out value="${artwork.title}"></jstl:out>
														</h4>
														<h5>
															<span class="amount"> <%-- 																			<jstl:out --%>
																<%-- 																					value="${artwork.totalCost}"></jstl:out> --%>
																<fmt:formatNumber type="number" minFractionDigits="2"
																	value="${artwork.totalCost}" /> <spring:message
																	code="artwork.euro"></spring:message></span>
														</h5>
												</a>
											</span>
											</span>
										</div>
									</jstl:forEach>
								</div>
							</div>
						</div>
					</security:authorize>
	
		
				</div>
			</div>
			
		</div>
	</div>
</div>

						
		<jstl:if
	test="${param.message != null && (param.message == 'artwork.must.be.yours' || param.message == 'artwork.sold' ||  param.message == 'artwork.must.no.cart' )}">
	<jstl:set var="message" value="${param.message}" />

	<div class="error">
		<spring:message code="${message}" />
	</div>
	<br />
</jstl:if>
<!-- Main content -->

<script type="text/javascript">
	var wall = new Freewall("#freewall");
	wall.reset({
		selector : '.brick',
		animate : true,
		cellW : 200,
		cellH : 'auto',
		gutterY : 30,
		gutterX : 30,
		onResize : function() {
			wall.fitWidth();
		}
	});

	wall.container.find('.brick img').load(function() {
		wall.fitWidth();
	});
</script>