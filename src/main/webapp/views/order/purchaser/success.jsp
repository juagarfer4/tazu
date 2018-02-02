 <%--
 * login.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
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

<div class="page-wrap container">
	<div class="col-md-12 no-padding">
		<div class="row">
			<div class="col-md-12">
				<spring:message code="order.success" />
				<br /> <a href="order/purchaser/list.do"> <input
										class="btn btn-primary btn-green uppercase pull-right"
										type="button" name="back"
										value="<spring:message code="order.back"/> 
										" />
						</a>
			</div>
		</div>
	</div>
</div>