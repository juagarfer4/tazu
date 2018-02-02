<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<form:form action="purchaser/edit.do"
						modelAttribute="purchaserForm">
				<div class="toggle-content">
						<form:hidden path="purchaser.id" />
						<form:hidden path="purchaser.version" />
						<form:hidden path="purchaser.userAccount.authorities" />

						<form:hidden path="purchaser.reviews" />
						<form:hidden path="purchaser.orders" />
						<div class="row">
							<div class="form-group">
								<div class="col-md-12">
									<h4>User account</h4>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:textbox code="purchaser.username"
										path="purchaser.userAccount.username" cssClass="form-control" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:password code="purchaser.password"
										path="purchaser.userAccount.password" cssClass="form-control"
										/>
								</div>
								<div class="col-md-6">
									<acme:password code="purchaser.password.repeat"
										path="checkPassword" cssClass="form-control" />
								</div>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="form-group">
								<div class="col-md-12">
									<h4>Purchaser info</h4>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:textbox code="purchaser.name" path="purchaser.name"
										cssClass="form-control" />
								</div>
								<div class="col-md-6">
									<acme:textbox code="purchaser.surname" path="purchaser.surname"
										cssClass="form-control" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:textbox code="purchaser.email" path="purchaser.email"
										cssClass="form-control" />
								</div>
								<div class="col-md-6">
									<acme:textbox code="purchaser.phone" path="purchaser.phone"
										cssClass="form-control" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:textbox code="purchaser.birthDate"
										path="purchaser.birthDate" cssClass="form-control" />
								</div>
								<div class="col-md-6">
									<acme:textbox code="purchaser.nationality"
										path="purchaser.nationality" cssClass="form-control" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:textbox code="purchaser.address" path="purchaser.address"
										cssClass="form-control" />
								</div>
								<div class="col-md-6">
									<acme:textbox code="purchaser.url" path="purchaser.URL"
										cssClass="form-control" />
								</div>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<span class="remember-box checkbox"> <acme:checkbox
											path="conditions" url="privacy/lopd-lssi.do"
											code="customer.terms" /></span>
								</div>
							</div>
						</div>
					
				</div>
				<!-- end of first -->
				<div class="space40"></div>

				<div class="actions-continue">
					<input type="submit"
						class="btn btn-primary btn-green uppercase pull-right" name="save"
						value="<spring:message code="customer.create"></spring:message>" />
				</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
<!-- Main content -->