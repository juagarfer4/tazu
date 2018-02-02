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
	<div role="main" class="main shop checkout-wrap">
		<div class="row">
			<div class="col-md-12">
				<div class="featured-box featured-box-primary">
					<div class="box-content">
						<div class="table-responsive">
							<table class="shop_table cart">
								<thead>
									<tr>
										<th class="product-title"><spring:message
												code="orderLine.purchaser.ticker"></spring:message></th>
										<th class="product-description"><spring:message
												code="orderLine.purchaser.title"></spring:message></th>
										<th class="product-width"><spring:message
												code="orderLine.purchaser.totalCost"></spring:message></th>
									</tr>
								</thead>
								<tbody>
									<jstl:forEach items="${orderLines}" var="orderLine">

										<tr class="cart_table_item">
											<td class="product-title"><jstl:out
													value="${orderLine.ticker}"></jstl:out></td>
											<td class="product-title"><jstl:out
													value="${orderLine.title}"></jstl:out></td>
											<td class="product-discipline"><span class="amount">
													<%-- 										<jstl:out --%> <%-- 													value="${orderLine.totalCost}"></jstl:out> --%>
													<fmt:formatNumber type="number" minFractionDigits="2"
														value="${orderLine.totalCost}" />
											</span></td>
										</tr>
									</jstl:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="space40"></div>
			<br /> <br /> <br /> <br />
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
										<th>${orderLines[0].order.taxName}</th>
										<td>${orderLines[0].order.taxValue}%<input type="hidden"
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
													<%-- 														value="${orderLines[0].order.totalCost}"></jstl:out>  --%>
													<fmt:formatNumber type="number" minFractionDigits="2"
														value="${orderLines[0].order.totalCost}" /> <spring:message
														code="cart.euro"></spring:message></span></strong></td>
									</tr>
								</tbody>
							</table>
							<jstl:if test="${orderLines[0].order.paid == false }">
								<hr class="tall">
							</jstl:if>
						</div>
					</div>
				</div>
				<!-- end of first -->
				<div class="space40"></div>

				<jstl:if test="${orderLines[0].order.paid == false }">

					<form name='formTpv' method='post'
						action='https://www.sandbox.paypal.com/cgi-bin/webscr'>
						<input name="cmd" type="hidden" value="_cart"> <input
							name="upload" type="hidden" value="1"> <input
							name="business" type="hidden" value="ispptazu@gmail.com">
						<input name="shopping_url" type="hidden"
							value="http://localhost:8080/tazu"> <input
							name="currency_code" type="hidden" value="EUR"> <input
							name="return" type="hidden"
							value="http://localhost:8080/tazu/order/purchaser/success.do">
<!-- 							value="http://ispptazu.cloud.hostnet.nl/order/purchaser/success.do"> -->
						<input type='hidden' name='cancel_return'
							value='http://localhost:8080/tazu/order/purchaser/fail.do'>
<!-- 							value="http://ispptazu.cloud.hostnet.nl/order/purchaser/fail.do"> -->
						<input name="rm" type="hidden" value="2">

						<jstl:forEach items="${orderLines}" var="orderLine" varStatus="s">
							<input name="item_number_${s.index+1}" type="hidden"
								value="${s.index+1}">
							<input name="item_name_${s.index+1}" type="hidden"
								value="${orderLine.title}">
							<input name="amount_${s.index+1}" type="hidden"
								value="${orderLine.totalCost}">
							<input name="quantity_${s.index+1}" type="hidden" value="1">
						</jstl:forEach>

						<button class="btn btn-primary btn-orange uppercase pull-right">
							<spring:message code="orderLine.purchaser.paypal"></spring:message>
						</button>
					</form>

				</jstl:if>
			</div>
		</div>
	</div>
</div>
<!-- Main content -->