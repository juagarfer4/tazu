<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script>
	document.oncontextmenu = function() {
		return false
	}
</script>

<!-- Main content -->
<div class="page-wrap container shop-form-wrap">
	<!-- Shop Content -->
	<div role="main" class="main shop">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6 img-hover">
						<div>
							<div class="item">
								<jstl:if test="${artwork.picture != null}">
									<img alt="img" class="img-responsive img-rounded"
										src="artwork/show.do?artworkId=${artwork.id}">
								</jstl:if>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="summary entry-summary">
							<h2 class="shorter">
								<jstl:out value="${artwork.title}" />
							</h2>
							<div class="review_num">
								<span class="count"><acme:out code="artwork.discipline"
										path="${artwork.discipline}" /></span>
							</div>
							<div title="Rated 5.00 out of 5" class="star-rating">
								<span style="width: 100%"><strong class="rating">5.00</strong>
									out of 5</span>
							</div>
							<p class="price">
								<span class="amount"> <%-- 								<jstl:out  --%> <%-- 										value="${artwork.totalCost}" /> <spring:message code="artwork.euro"/></span> --%>
									<fmt:formatNumber type="number" minFractionDigits="2"
										value="${artwork.totalCost}" /> <spring:message
										code="artwork.euro" /></span>
							</p>
							<div class="space20"></div>
							<p class="taller">
								<jstl:out value="${artwork.description}" />
							</p>
							<div class="space50"></div>

							<security:authorize access="hasRole('PURCHASER')">
								<jstl:if test="${artwork.status=='SALE'}">

									<a href="cart/purchaser/addToCart.do?artworkId=${artwork.id}"
										class="btn btn-primary btn-sm btn-green uppercase cart-button">
										<spring:message code="artwork.addToCart"></spring:message>
									</a>
								</jstl:if>
							</security:authorize>

							<div class="product_meta">

								<span class="posted_in"><jstl:if
										test="${artwork.tags != null}">
										<jstl:forEach var="tag" items="${tags}">
											<a rel="tag"><jstl:out value="${tag}" /></a>
										</jstl:forEach>
									</jstl:if> </span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="tabs tabs-product">
							<ul class="nav nav-tabs">
								<li><spring:message code="artwork.additional.information" /></li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane active" id="productInfo">
									<div class="space10"></div>
									<div class="table-responsive">
										<table class="table push-top">
											<tbody>
												<tr>
													<th><spring:message code="artwork.artist.name.surname" /></th>
													<td>
														<%-- 												<jstl:out --%> <%-- 														value="${artwork.height}" /> --%>
														<jstl:out value="${artwork.artist.name}" /> <jstl:out
															value="${artwork.artist.surname}" />
													</td>
												</tr>


												<tr>
													<th><spring:message code="artwork.heigth" /></th>
													<td>
														<%-- 												<jstl:out --%> <%-- 														value="${artwork.height}" /> --%>
														<fmt:formatNumber type="number" minFractionDigits="2"
															value="${artwork.height}" />
													</td>
												</tr>
												<tr>
													<th><spring:message code="artwork.width" /></th>
													<td>
														<%-- 												<jstl:out  --%> <%-- 														value="${artwork.width}" /> --%>
														<fmt:formatNumber type="number" minFractionDigits="2"
															value="${artwork.width}" />
													</td>
												</tr>
												<tr>
													<th><spring:message code="artwork.upload.date" /></th>
													<td><fmt:formatDate value="${artwork.moment}"
															pattern="dd/MM/yyyy" /></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Main content -->