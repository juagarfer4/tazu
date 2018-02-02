<%--
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="tax/administrator/edit.do" modelAttribute="tax">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="artworks"/>
	
	<acme:textbox code="tax.name" path="name"/>
	<acme:textbox code="tax.value" path="value"/>
	
	<acme:submit name="save" code="tax.save"/>
	
	<jstl:if test="${tax.getId()!=0 }">
		<acme:submit name="delete" code="tax.delete"/>
	</jstl:if>	
	
	<input type="button" name="cancel" value="<spring:message code="tax.cancel"/>" onclick="javascript: window.location.replace('tax/administrator/list.do')" />
	
</form:form>