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

<form:form action="profit/administrator/edit.do" modelAttribute="profit">

	<form:hidden path="id" />
	<form:hidden path="version" />
	
	<acme:textbox code="profit.value" path="value"/>
	<acme:textbox code="profit.lowerLimit" path="lowerLimit"/>
	<acme:textbox code="profit.upperLimit" path="upperLimit"/>
	
	<acme:submit name="save" code="profit.save"/>
	
	<input type="button" name="cancel" value="<spring:message code="profit.cancel"/>" onclick="javascript: window.location.replace('profit/administrator/list.do')" />
	
</form:form>