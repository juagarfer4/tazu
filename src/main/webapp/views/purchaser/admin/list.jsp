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

<display:table name="purchasers" id="row" pagesize="5"
	requestURI="${requestURI}" class="displaytag">

	<acme:displayColumn code="purchaser.admin.name" property="name" />
	<acme:displayColumn code="purchaser.admin.surname" property="surname" />
	<acme:displayColumn code="purchaser.admin.email" property="email" />
	<acme:displayColumn code="purchaser.admin.phone" property="phone" />
	
	<spring:message code="purchaser.admin.options" var="options" />
		<display:column title="${options}">
			<a
				href="review/admin/list.do?purchaserId=<jstl:out value="${row.id}"></jstl:out>">
				<spring:message code="review.list" />
			</a>


		</display:column>
	
</display:table>

<acme:cancel url="welcome/index.do" code="purchaser.admin.back" />
