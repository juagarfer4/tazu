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
				<div class="table-responsive">
					<display:table name="orders" id="row" requestURI="${requestURI}"
						pagesize="5"
						class="shop_table cart table-hover table-striped table-condensed">

						<display:column titleKey="order.purchaser.ref">
							<jstl:out value="#${row.id}"></jstl:out>
						</display:column>

						<display:column titleKey="order.purchaser.totalCost">
							<fmt:formatNumber type="number" minFractionDigits="2"
								value="${row.totalCost}" />
							<jstl:out value="euros"></jstl:out>
						</display:column>

						<display:column titleKey="order.purchaser.moment">
							<fmt:formatDate value="${row.moment}" pattern="dd/MM/yyyy HH:mm" />
						</display:column>

						<display:column titleKey="dashboard.orders.list.payingStatus">
							<jstl:if test="${row.paid}">
								<spring:message code="order.status.paid"></spring:message>
							</jstl:if>
							<jstl:if test="${!row.paid}">
								<spring:message code="order.status.notPaid"></spring:message>
							</jstl:if>
						</display:column>

						<display:column>

							<a href="orderLine/purchaser/list.do?orderId=${row.id}"> <spring:message
									code="order.purchaser.orderLines"></spring:message>
							</a>
						</display:column>
					</display:table>
				</div>
			</div>

		</div>
	</div>
				<jstl:if
	test="${param.message != null && (param.message == 'order.no.yours')}">
	<jstl:set var="message" value="${param.message}" />
	<div class="alert alert-danger">
		<span class="message"><spring:message code="${message}" /></span>
	</div>
	<br />
</jstl:if>
</div>


<!-- Main content -->