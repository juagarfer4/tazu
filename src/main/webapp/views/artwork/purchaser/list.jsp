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


<!-- Main content -->
<div class="page-wrap container shop-form-wrap">
	<!-- Shop Content -->
	<div role="main" class="main shop">
		<div class="row">
			<div class="col-md-12">
				<div class="row featured-boxes">
					<div class="col-md-12">
						<div class="featured-box featured-box-primary">
							<div class="box-content">
								<div class="table-responsive">
									<table class="shop_table cart">
										<thead>
											<tr>
												<th class="product-remove">&nbsp;</th>
												<th class="product-thumbnail">&nbsp;</th>
												<th class="product-title"><spring:message
														code="artwork.purchaser.title"></spring:message></th>
												<th class="product-artist"><spring:message
														code="artwork.purchaser.artist.name.surname"></spring:message></th>
												<th class="product-discipline"><spring:message
														code="artwork.purchaser.discipline"></spring:message></th>
												<th class="product-width"><spring:message
														code="artwork.purchaser.width"></spring:message></th>
												<th class="product-height"><spring:message
														code="artwork.purchaser.height"></spring:message></th>
												<th class="product-price"><spring:message
														code="artwork.purchaser.price"></spring:message></th>
											</tr>
										</thead>
										<tbody>

											<jstl:forEach items="${artworks}" var="artwork">

												<tr class="cart_table_item">
													<td class="product-remove"><a title="Remove this item"
														class="remove" href="#"> <i
															class="icon icon-minus-square"></i>
													</a></td>
													<td class="img-hover-list"><img alt="img" class="img-responsive img-rounded"
										src="artwork/show.do?artworkId=${artwork.id}"></td>
													<td class="product-title"><jstl:out
															value="${artwork.title}"></jstl:out></td>
													<%-- 												<td class="product-description"><jstl:out --%>
													<%-- 															value="${artwork.description}"></jstl:out></td> --%>

													<td class="product-artist"><span class="amount"><jstl:out
																value="${artwork.artist.name}"></jstl:out> <jstl:out
																value="${artwork.artist.surname}"></jstl:out></span></td>
													<td class="product-discipline"><span class="amount"><jstl:out
																value="${artwork.discipline}"></jstl:out></span></td>
													<td class="product-width"><span class="amount"><jstl:out
																value="${artwork.width}"></jstl:out></span></td>
													<td class="product-height"><span class="amount"><jstl:out
																value="${artwork.height}"></jstl:out></span></td>
													<td class="product-price"><span class="amount">
															<%-- 												<jstl:out --%> <%-- 															value="${artwork.totalCost}"></jstl:out> --%>
															<fmt:formatNumber type="number" minFractionDigits="2"
																value="${artwork.totalCost}" /> <spring:message
																code="artwork.euro" />
													</span></td>
													<td class="product-price"><span class="amount"><a
															href="cart/purchaser/delete.do?artworkId=${artwork.id}"><i
																class="icon-remove4"></i></a></span></td>
												</tr>
											</jstl:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br /> <br />
			</div>
			<div class="col-md-9">
				<div id="first">
					<h4>
						<spring:message code="cart.totals"></spring:message>
					</h4>
					<div class="racc">
						<div class="toggle-content">
							<table class="cart-totals">
								<tbody>
									<tr class="taxes">
										<th>${tax.name}</th>
										<td>${tax.value}%<input type="hidden"
											value="free_shipping" name="shipping_method">
										</td>
									</tr>
									<tr class="shipping">
										<th><spring:message code="cart.shipping"></spring:message></th>
										<td><a href="privacy/policy.do"><spring:message
													code="cart.shipping.policy"></spring:message></a><input
											type="hidden" value="free_shipping" name="shipping_method">
										</td>
									</tr>
									<tr class="total">
										<th><strong><spring:message
													code="cart.total.cost"></spring:message></strong></th>
										<td><strong><span class="amount"> <%-- 										<jstl:out --%>
													<%-- 														value="${totalCost}"></jstl:out>  --%> <fmt:formatNumber
														type="number" minFractionDigits="2" value="${totalCost}" />
													<spring:message code="cart.euro"></spring:message></span></strong></td>
									</tr>
								</tbody>
							</table>
							<hr class="tall">
						</div>
					</div>
				</div>
				<!-- end of first -->
				<div class="space40"></div>
				<div class="row featured-boxes">
					<div class="col-md-12">
						<div class="actions-continue">
							<jstl:if
								test="${requestURI == 'artwork/purchaser/listInCart.do'}">
								<jstl:if test="${!(empty artworks)}">

									<a href="order/purchaser/create.do"> <input
										class="btn btn-primary btn-green uppercase pull-right"
										type="button" name="checkout"
										value="<spring:message code="cart.purchaser.order" />" />
									</a>
								</jstl:if>
							</jstl:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jstl:if
	test="${param.message != null && (param.message == 'cart.has.no.artwork' || param.message == 'must.pay.the.previous.order' ||  param.message == 'artwork.is.sold')}">
	<jstl:set var="message" value="${param.message}" />
	<div class="alert alert-danger">
		<span class="message"><spring:message code="${message}" /></span>
	</div>
</jstl:if>
<!-- Main content -->