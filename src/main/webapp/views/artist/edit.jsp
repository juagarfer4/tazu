<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="artist/edit.do" modelAttribute="artistForm">
	<form:hidden path="artist.id" />
	<form:hidden path="artist.version" />
	<form:hidden path="artist.userAccount.authorities" />

	<form:hidden path="artist.rating" />
	<form:hidden path="artist.reviews" />
	<form:hidden path="artist.artworks" />

	<!-- Main content -->
	<div class="page-wrap container shop-form-wrap">

		<!-- Shop Content -->
		<div role="main" class="main shop checkout-wrap">

			<div class="row">
				<div class="col-md-12">
					<div class="toggle-content">
						<div class="row">
							<div class="form-group">
								<div class="col-md-12">
									<h4><spring:message code="artist.register.userAccount.info"></spring:message></h4>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:textbox code="artist.username"
										path="artist.userAccount.username" cssClass="form-control" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:password code="artist.password"
										path="artist.userAccount.password" cssClass="form-control" />
								</div>
								<div class="col-md-6">
									<acme:password code="artist.password.repeat"
										path="checkPassword" cssClass="form-control" />
								</div>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="form-group">
								<div class="col-md-12">
									<h4><spring:message code="artist.register.artist.info"></spring:message></h4>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:textbox code="artist.name" path="artist.name"
										cssClass="form-control" />
								</div>
								<div class="col-md-6">
									<acme:textbox code="artist.surname" path="artist.surname"
										cssClass="form-control" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:textbox code="artist.email" path="artist.email"
										cssClass="form-control" />
								</div>
								<div class="col-md-6">
									<acme:textbox code="artist.phone" path="artist.phone"
										cssClass="form-control" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:textbox code="artist.birthDate" path="artist.birthDate"
										cssClass="form-control" />
								</div>
								<div class="col-md-6">
									<acme:textbox code="artist.nationality"
										path="artist.nationality" cssClass="form-control" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-md-6">
									<acme:textbox code="artist.address" path="artist.address"
										cssClass="form-control" />
								</div>
								<div class="col-md-6">
									<acme:textbox code="artist.url" path="artist.URL"
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
							class="btn btn-primary btn-green uppercase pull-right"
							name="save"
							value="<spring:message code="customer.create"></spring:message>" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Main content -->

</form:form>