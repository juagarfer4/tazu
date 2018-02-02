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

<div class="page-wrap container shop-form-wrap">
	<!-- Shop Content -->
	<div role="main" class="main shop checkout-wrap">
		<div class="row">
			<div class="col-md-12">
				<div class="table-responsive">
					<display:table name="reviews" id="row" requestURI="${requestURI}"
						pagesize="5"
						class="shop_table cart table-hover table-striped table-condensed">

						<display:column property="rating"
							titleKey="review.purchaser.rating" />

						<display:column property="description"
							titleKey="review.purchaser.description" />

						<display:column property="artist.name"
							titleKey="review.purchaser.artist" />
					</display:table>
				</div>
			</div>
		</div>
	</div>
</div>