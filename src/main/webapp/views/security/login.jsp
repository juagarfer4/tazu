
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
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="j_spring_security_check" modelAttribute="credentials">

	<!-- Main content -->
	<div class="page-wrap container shop-form-wrap">

		<!-- Shop Content -->
		<div class="row">
			<div class="col-md-12">
				<div class="row featured-boxes">
					<div class="col-md-6">
						<div class="featured-box default">
							<div class="box-content">
								<h4 class="review-head">
									<spring:message code="enter.login.title"></spring:message>
								</h4>
								<div class="space20"></div>
								<form id="contactForm">
									<div class="row">
										<div class="form-group">
											<div class="col-md-12">
												<acme:textbox code="security.username"
													cssClass="form-control" path="username" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="form-group">
											<div class="col-md-12">
												<acme:password code="security.password"
													cssClass="form-control" path="password" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<input type="submit"
												value="<spring:message code="security.login" />"
												class="btn btn-primary btn-green uppercase pull-right" />
										</div>
									</div>
								</form>
							</div>
						</div>
						<br />
						<jstl:if test="${param.result == 'success'}">
							<div class="success">
								<br />
								<spring:message code="customer.success.register" />
							</div>
						</jstl:if>
						<br />
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-3">
						<div class="featured-box default">
							<div class="box-content">
								<h4 class="review-head">
									<spring:message code="enter.register.title"></spring:message>
								</h4>
								<div class="space20"></div>
								<p>
									<a href="artist/register.do">&rarr; <spring:message
											code="enter.register.artist"></spring:message></a>
								</p>
								<p>
									<a href="purchaser/register.do">&rarr; <spring:message
											code="enter.register.purchaser"></spring:message></a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jstl:if test="${showError == true}">
		<div class="alert alert-danger">
			<span class="message"><spring:message
					code="security.login.failed" /></span>
		</div>
	</jstl:if>
	<!-- Main content -->

</form:form>