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
<style type="text/css">
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

<div class="page-wrap container shop-form-wrap">

	<!-- Shop Content -->
	<div role="main" class="main shop checkout-wrap">

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
				<div class="table-responsive">

					<display:table name="artists" id="row" requestURI="${requestURI}"
						pagesize="5"
						class="shop_table cart table-hover table-striped table-condensed">

						<display:column property="name" titleKey="artist.name" />

						<display:column property="surname" titleKey="artist.surname" />

						<spring:message var="artistRatingHeader" code="artist.rating" />
						<display:column title="${artistRatingHeader}" sortable="rating">

							<jstl:choose>
								<jstl:when test="${row.reviews.size() == 0}">

									<spring:message code="artist.review.not.reviewed" />
								</jstl:when>
								<jstl:otherwise>
									<%-- 									<jstl:out value="${row.rating}" /> --%>
									<fmt:formatNumber type="number" minFractionDigits="2"
										value="${row.rating}" />
								</jstl:otherwise>
							</jstl:choose>

						</display:column>

						<display:column titleKey="artist.artworks.options">
							<a href="artwork/listByArtist.do?artistId=${row.id}"> <spring:message
									code="artist.artworks" />
							</a> |

													<a href="review/list.do?artistId=${row.id}"> <spring:message
									code="artist.reviews" />
							</a>
							<security:authorize access="hasRole('PURCHASER')">
							|
								<a href="review/purchaser/create.do?artistId=${row.id}"> <spring:message
										code="review.purchaser.create" />
								</a>
							</security:authorize>
						</display:column>
					</display:table>

				</div>
			</div>
		</div>
	</div>
</div>
