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

<jstl:if test="${not empty cart.artworks}">

<div class="table-responsive">
<display:table name="cart" id="row" pagesize="5"
	requestURI="${requestURI}" class="displaytag">
	
	
<%-- 	<acme:displayColumn code="cart.purchaser.totalCost" property="totalCost" /> --%>
	<display:column  titleKey="cart.purchaser.totalCost"> <fmt:formatNumber type="number" minFractionDigits="2" value="${row.totalCost}" /></display:column>
	
	
	<display:column titleKey="cart.purchaser.options">
			<a href="artwork/purchaser/listInCart.do?cartId=${row.id}"> <spring:message code="cart.purchaser.artworks"/> </a>
			<br/>
			<a href="order/purchaser/create.do"> <spring:message code="cart.purchaser.order"/> </a>
	</display:column>
	
	
</display:table>
</div>
</jstl:if>

<jstl:if test="${empty cart.artworks}">

<spring:message code="cart.purchaser.empty" ></spring:message>
<br/><br/>
</jstl:if>
<acme:cancel url="welcome/index.do" code="cart.purchaser.back" />
