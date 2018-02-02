<%--
 * action-1.jsp
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
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<display:table name="profits" id="row" pagesize="5" requestURI="${requestUri}" class="displaytag">
	
	<spring:message code="profit.value" var="value" />
<%-- 	<display:column title="${value}" property="value" /> --%>
	<display:column  titleKey="value"> <fmt:formatNumber type="number" minFractionDigits="2" value="${row.value}" /></display:column>
	
	<spring:message code="profit.lowerLimit" var="lowerLimit" />
	<display:column title="${lowerLimit}" property="lowerLimit" />
	
	<spring:message code="profit.upperLimit" var="upperLimit" />
	<display:column title="${upperLimit}" property="upperLimit" />
	
	<security:authorize access="hasRole('ADMINISTRATOR')">
		<spring:message code="profit.edit" var="edit" />
		<display:column title="${edit}">
			<input type="button" name="edit" value="<spring:message code="profit.edit" />" 
				onclick="javascript: window.location.assign('profit/administrator/edit.do?profitId=${row.id}')" />
		</display:column>
	</security:authorize>
</display:table>