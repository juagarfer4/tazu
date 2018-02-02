
<%--
 * login.jsp
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
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="review/purchaser/create.do" modelAttribute="review">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="purchaser" />
	<form:hidden path="artist" />

	<acme:textbox code="review.purchaser.rating" path="rating" />
	<acme:textbox code="review.purchaser.description" path="description" />

	<jstl:if test="${showError == true}">
		<div class="error">
			<spring:message code="review.purchaser.create.failed" />
		</div>
	</jstl:if>

	<br />

	<acme:submit name="save" code="review.purchaser.save" />
	<acme:cancel url="review/purchaser/list.do"
		code="review.purchaser.back" />

</form:form>