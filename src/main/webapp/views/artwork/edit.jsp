<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<input type="hidden" id="profitNumber" value="${ profitNumber}" />
<input type="hidden" id="taxNumber" value="${ taxNumber}" />


<script>
	function totalPrice() {
		m1 = parseFloat(document.getElementById("price").value);
		m2 = parseFloat(document.getElementById("profitNumber").value);
		m3 = parseFloat(document.getElementById("taxNumber").value);

		r = m1 + (m1 * m2) + (m1 * m3);

		cost = roundToTwo(r);

		cost = cost.toFixed(2);

		document.getElementById("resultado").innerHTML = cost + " euros";
	}

	function roundToTwo(num) {
		return +(Math.round(num + "e+2") + "e-2");
	}
</script>

<!-- Main content -->
<div class="page-wrap container contact-wrap">
	<div class="container">
		<div class="col-md-12 no-padding columns">
			<div class="row">
				<div class="col-md-9">
					<form:form action="artwork/artist/edit.do" cssClass="contact-form"
						modelAttribute="artwork" enctype="multipart/form-data"
						method="post">

						<form:hidden path="id" />
						<form:hidden path="version" />
						<form:hidden path="artist" />
						<form:hidden path="moment" />
						<form:hidden path="status" />
						<form:hidden path="ticker" />
						<form:hidden path="tax" />
						<form:hidden path="deleted" />
						<form:hidden path="carts" />

						<div class="row">
							<div class="col-md-6">
								<acme:textbox code="artwork.title" path="title" />
								<acme:textbox code="artwork.discipline" path="discipline" />
								<acme:textbox code="artwork.tags.edit" path="tags" />
							</div>
							<div class="col-md-6">
								<acme:textbox code="artwork.heigth" path="height"/>
								<acme:textbox code="artwork.width" path="width"/>
								<form:label path="price">
									<spring:message code="artwork.price" />
								</form:label>
								<form:input path="price" onChange='totalPrice()'/>
								<form:errors cssClass="error" path="price" />
							</div>
						</div>
						<acme:textarea code="artwork.description" path="description" />

						<div class="input-group">
							<span class="input-group-btn">
								<button id="fake-file-button-browse" type="button"
									class="btn btn-primary btn-sm btn-gray uppercase">
									<spring:message code="artwork.picture" />
									<i class="fa fa-folder-open-o"></i>
								</button>
							</span>

							<form:input id="files-input-upload" path="picture" type="file"
								cssStyle="display: none" />
							<form:errors path="picture" cssClass="error" />


							<input type="text" id="fake-file-input-name" disabled="disabled"
								class="form-control">
						</div>

						<script type="text/javascript">
							// Fake file upload
							document.getElementById('fake-file-button-browse')
									.addEventListener(
											'click',
											function() {
												document.getElementById(
														'files-input-upload')
														.click();
											});

							document
									.getElementById('files-input-upload')
									.addEventListener(
											'change',
											function() {
												document
														.getElementById('fake-file-input-name').value = this.value;

												document
														.getElementById(
																'fake-file-button-upload')
														.removeAttribute(
																'disabled');
											});
						</script>

						<br />

						<button type="submit" id="sendMessage" name="save"
							class="btn btn-primary btn-green uppercase pull-right">
							<spring:message code="artwork.save"></spring:message>
						</button>
					</form:form>

				</div>
				<aside class="col-md-3">
					<div class="side-widget contact-info">
						<h4>
							<spring:message code="artwork.total.cost.with.tax" />
						</h4>
						<h1>
							<div id="resultado">
								<spring:message code="artwork.waiting.price" />
							</div>
						</h1>
					</div>
				</aside>
			</div>
		</div>
	</div>
</div>
<!-- Main content -->