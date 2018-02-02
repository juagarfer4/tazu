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

<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Gentallela Alela! |</title>

<!-- Bootstrap core CSS -->

<link href="styles/dashboard/css/bootstrap.min.css" rel="stylesheet">

<link href="styles/dashboard/fonts/css/font-awesome.min.css"
	rel="stylesheet">
<link href="styles/dashboard/css/animate.min.css" rel="stylesheet">

<link href="styles/dashboard/js/datatables/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" />
<link href="styles/dashboard/js/datatables/buttons.bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="styles/dashboard/js/datatables/fixedHeader.bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="styles/dashboard/js/datatables/responsive.bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="styles/dashboard/js/datatables/scroller.bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<!-- Custom styling plus plugins -->
<link href="styles/dashboard/css/custom.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="styles/dashboard/css/maps/jquery-jvectormap-2.0.3.css" />
<link href="styles/dashboard/css/icheck/flat/green.css" rel="stylesheet" />
<link href="styles/dashboard/css/floatexamples.css" rel="stylesheet"
	type="text/css" />

<script src="styles/dashboard/js/jquery.min.js"></script>
<script src="styles/dashboard/js/nprogress.js"></script>

<!--[if lt IE 9]>
        <script src="../assets/js/ie8-responsive-file-warning.js"></script>
        <![endif]-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

</head>


<body class="nav-md">

	<div class="container body">


		<div class="main_container">

			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">

					<div class="navbar nav_title" style="border: 0;">
						<a href=""><img src="images/logo.png" class="img-responsive"
							alt="img" /></a>
					</div>
					<div class="clearfix"></div>

					<!-- menu prile quick info -->
					<div class="profile">
						<div class="profile_info">
							<span><spring:message code="menu.welcome"></spring:message></span>
							<h2>
								<security:authentication property="principal.username" />
							</h2>
						</div>
						<div class="nav toggle">
							<a data-toggle="tooltip" data-placement="top" href="?language=en">
								<span><img src="images/en.png" width="40%" height="40%"
									class="img-responsive" /></span>
							</a> <a data-toggle="tooltip" data-placement="top"
								href="?language=es"> <span><img src="images/es.png"
									width="40%" height="40%" class="img-responsive" /></span></a>
						</div>
					</div>
					<br /> <br /> <br /> <br />
					<!-- /menu prile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">

						<div class="menu_section">
							<h3>
								<spring:message code="menu.title"></spring:message>
							</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-users"></i> <spring:message
											code="menu.users"></spring:message><span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu" style="display: none">
										<li><a href="dashboard/admin/purchasers.do"><spring:message
													code="menu.purchasers"></spring:message></a></li>
										<li><a href="dashboard/admin/artists.do"><spring:message
													code="menu.artists"></spring:message></a></li>
									</ul></li>
								<li><a><i class="fa fa-paint-brush"></i> <spring:message
											code="menu.artworks"></spring:message> <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu" style="display: none">
										<li><a href="dashboard/admin/onSaleArtworks.do"><spring:message
													code="menu.onSaleArtworks"></spring:message></a></li>
										<li><a href="dashboard/admin/soldArtworks.do"><spring:message
													code="menu.soldArtworks"></spring:message></a></li>
									</ul></li>
								<li><a href="dashboard/admin/orders.do"><i
										class="fa fa-calculator"></i> <spring:message
											code="menu.orders"></spring:message></a>
									<ul class="nav child_menu" style="display: none">
									</ul></li>
								<li><a href="dashboard/admin/listtax.do"><i
										class="fa fa-money"></i> <spring:message code="menu.tax"></spring:message></a>
									<ul class="nav child_menu" style="display: none">
									</ul></li>
								<li><a href="dashboard/admin/listprofit.do"><i
										class="fa fa-line-chart"></i> <spring:message
											code="menu.profits"></spring:message></a>
									<ul class="nav child_menu" style="display: none">
									</ul></li>
							</ul>
						</div>
					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a href="j_spring_security_logout" data-toggle="tooltip"
							data-placement="top"
							title="<spring:message code="dashboard.logout"></spring:message>">
							<span class="glyphicon glyphicon-off" aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">

				<div class="nav_menu">
					<nav class="" role="navigation">
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>
					</nav>
				</div>

			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">

				<div class="clearfix"></div>

				<div class="row">

					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>
									<spring:message code="dashboard.profit.list.title"></spring:message>
								</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">

								<div class="table-responsive">
									<table id="datatable-responsive"
										class="table table-striped table-bordered table-hover table-condensed nowrap"
										cellspacing="0" width="100%">
										<thead>
											<tr>
												<th><spring:message code="profit.value"></spring:message></th>
												<th><spring:message code="profit.lowerLimit"></spring:message></th>
												<th><spring:message code="profit.upperLimit"></spring:message></th>
												<th><spring:message code="dashboard.tax.options"></spring:message></th>
											</tr>
										</thead>
										<tbody>

											<jstl:forEach items="${profits}" var="profit">
												<tr>
													<td><jstl:out value="${profit.value}%"></jstl:out></td>
													<td><jstl:out value="${profit.lowerLimit}"></jstl:out></td>
													<td><jstl:out value="${profit.upperLimit}"></jstl:out></td>
													<td><security:authorize
															access="hasRole('ADMINISTRATOR')">

															<a
																href="dashboard/admin/editprofit.do?profitId=${profit.id}"><spring:message
																	code="tax.edit" /></a>

														</security:authorize></td>
												</tr>
											</jstl:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /page content -->

	</div>

	<div id="custom_notifications" class="custom-notifications dsp_none">
		<ul class="list-unstyled notifications clearfix"
			data-tabbed_notifications="notif-group">
		</ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>

	<!-- Datatables-->
	<script src="styles/dashboard/js/datatables/jquery.dataTables.min.js"></script>
	<script src="styles/dashboard/js/datatables/dataTables.bootstrap.js"></script>
	<script src="styles/dashboard/js/datatables/dataTables.buttons.min.js"></script>
	<script src="styles/dashboard/js/datatables/buttons.bootstrap.min.js"></script>
	<script src="styles/dashboard/js/datatables/jszip.min.js"></script>
	<script src="styles/dashboard/js/datatables/pdfmake.min.js"></script>
	<script src="styles/dashboard/js/datatables/vfs_fonts.js"></script>
	<script src="styles/dashboard/js/datatables/buttons.html5.min.js"></script>
	<script src="styles/dashboard/js/datatables/buttons.print.min.js"></script>
	<script
		src="styles/dashboard/js/datatables/dataTables.fixedHeader.min.js"></script>
	<script src="styles/dashboard/js/datatables/dataTables.keyTable.min.js"></script>
	<script
		src="styles/dashboard/js/datatables/dataTables.responsive.min.js"></script>
	<script
		src="styles/dashboard/js/datatables/responsive.bootstrap.min.js"></script>
	<script src="styles/dashboard/js/datatables/dataTables.scroller.min.js"></script>

	<script src="styles/dashboard/js/bootstrap.min.js"></script>

	<!-- pace -->
	<script src="styles/dashboard/js/pace/pace.min.js"></script>
	<script>
		var handleDataTableButtons = function() {
			"use strict";
			0 !== $("#datatable-buttons").length
					&& $("#datatable-buttons").DataTable({
						dom : "Bfrtip",
						buttons : [ {
							extend : "copy",
							className : "btn-sm"
						}, {
							extend : "csv",
							className : "btn-sm"
						}, {
							extend : "excel",
							className : "btn-sm"
						}, {
							extend : "pdf",
							className : "btn-sm"
						}, {
							extend : "print",
							className : "btn-sm"
						} ],
						responsive : !0
					})
		}, TableManageButtons = function() {
			"use strict";
			return {
				init : function() {
					handleDataTableButtons()
				}
			}
		}();
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#datatable').dataTable();
			$('#datatable-keytable').DataTable({
				keys : true
			});
			$('#datatable-responsive').DataTable();
			$('#datatable-scroller').DataTable({
				ajax : "js/datatables/json/scroller-demo.json",
				deferRender : true,
				scrollY : 380,
				scrollCollapse : true,
				scroller : true
			});
			var table = $('#datatable-fixed-header').DataTable({
				fixedHeader : true
			});
		});
		TableManageButtons.init();
	</script>

	<!-- gauge js -->
	<script type="text/javascript"
		src="styles/dashboard/js/gauge/gauge.min.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/gauge/gauge_demo.js"></script>
	<!-- bootstrap progress js -->
	<script
		src="styles/dashboard/js/progressbar/bootstrap-progressbar.min.js"></script>
	<script src="styles/dashboard/js/nicescroll/jquery.nicescroll.min.js"></script>
	<!-- icheck -->
	<script src="styles/dashboard/js/icheck/icheck.min.js"></script>
	<!-- daterangepicker -->
	<script type="text/javascript"
		src="styles/dashboard/js/moment/moment.min.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/datepicker/daterangepicker.js"></script>
	<!-- chart js -->
	<script src="styles/dashboard/js/chartjs/chart.min.js"></script>

	<script src="styles/dashboard/js/custom.js"></script>

	<!-- flot js -->
	<!--[if lte IE 8]><script type="text/javascript" src="js/excanvas.min.js"></script><![endif]-->
	<script type="text/javascript"
		src="styles/dashboard/js/flot/jquery.flot.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/flot/jquery.flot.pie.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/flot/jquery.flot.orderBars.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/flot/jquery.flot.time.min.js"></script>
	<script type="text/javascript" src="styles/dashboard/js/flot/date.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/flot/jquery.flot.spline.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/flot/jquery.flot.stack.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/flot/curvedLines.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/flot/jquery.flot.resize.js"></script>
	<script>
		$(document).ready(
				function() {
					// [17, 74, 6, 39, 20, 85, 7]
					//[82, 23, 66, 9, 99, 6, 2]
					var data1 = [ [ gd(2012, 1, 1), 17 ],
							[ gd(2012, 1, 2), 74 ], [ gd(2012, 1, 3), 6 ],
							[ gd(2012, 1, 4), 39 ], [ gd(2012, 1, 5), 20 ],
							[ gd(2012, 1, 6), 85 ], [ gd(2012, 1, 7), 7 ] ];

					var data2 = [ [ gd(2012, 1, 1), 82 ],
							[ gd(2012, 1, 2), 23 ], [ gd(2012, 1, 3), 66 ],
							[ gd(2012, 1, 4), 9 ], [ gd(2012, 1, 5), 119 ],
							[ gd(2012, 1, 6), 6 ], [ gd(2012, 1, 7), 9 ] ];
					$("#canvas_dahs").length
							&& $.plot($("#canvas_dahs"), [ data1, data2 ], {
								series : {
									lines : {
										show : false,
										fill : true
									},
									splines : {
										show : true,
										tension : 0.4,
										lineWidth : 1,
										fill : 0.4
									},
									points : {
										radius : 0,
										show : true
									},
									shadowSize : 2
								},
								grid : {
									verticalLines : true,
									hoverable : true,
									clickable : true,
									tickColor : "#d5d5d5",
									borderWidth : 1,
									color : '#fff'
								},
								colors : [ "rgba(38, 185, 154, 0.38)",
										"rgba(3, 88, 106, 0.38)" ],
								xaxis : {
									tickColor : "rgba(51, 51, 51, 0.06)",
									mode : "time",
									tickSize : [ 1, "day" ],
									//tickLength: 10,
									axisLabel : "Date",
									axisLabelUseCanvas : true,
									axisLabelFontSizePixels : 12,
									axisLabelFontFamily : 'Verdana, Arial',
									axisLabelPadding : 10
								//mode: "time", timeformat: "%m/%d/%y", minTickSize: [1, "day"]
								},
								yaxis : {
									ticks : 8,
									tickColor : "rgba(51, 51, 51, 0.06)",
								},
								tooltip : false
							});

					function gd(year, month, day) {
						return new Date(year, month - 1, day).getTime();
					}
				});
	</script>

	<!-- worldmap -->
	<script type="text/javascript"
		src="styles/dashboard/js/maps/jquery-jvectormap-2.0.3.min.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/maps/gdp-data.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/maps/jquery-jvectormap-world-mill-en.js"></script>
	<script type="text/javascript"
		src="styles/dashboard/js/maps/jquery-jvectormap-us-aea-en.js"></script>
	<!-- pace -->
	<script src="styles/dashboard/js/pace/pace.min.js"></script>
	<script>
		$(function() {
			$('#world-map-gdp').vectorMap({
				map : 'world_mill_en',
				backgroundColor : 'transparent',
				zoomOnScroll : false,
				series : {
					regions : [ {
						values : gdpData,
						scale : [ '#E6F2F0', '#149B7E' ],
						normalizeFunction : 'polynomial'
					} ]
				},
				onRegionTipShow : function(e, el, code) {
					el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
				}
			});
		});
	</script>
	<!-- skycons -->
	<script src="styles/dashboard/js/skycons/skycons.min.js"></script>
	<script>
		var icons = new Skycons({
			"color" : "#73879C"
		}), list = [ "clear-day", "clear-night", "partly-cloudy-day",
				"partly-cloudy-night", "cloudy", "rain", "sleet", "snow",
				"wind", "fog" ], i;

		for (i = list.length; i--;)
			icons.set(list[i], list[i]);

		icons.play();
	</script>

	<!-- dashbord linegraph -->
	<script>
		Chart.defaults.global.legend = {
			enabled : false
		};

		var data = {
			labels : [ "Symbian", "Blackberry", "Other", "Android", "IOS" ],
			datasets : [ {
				data : [ 15, 20, 30, 10, 30 ],
				backgroundColor : [ "#BDC3C7", "#9B59B6", "#455C73", "#26B99A",
						"#3498DB" ],
				hoverBackgroundColor : [ "#CFD4D8", "#B370CF", "#34495E",
						"#36CAAB", "#49A9EA" ]

			} ]
		};

		var canvasDoughnut = new Chart(document.getElementById("canvas1"), {
			type : 'doughnut',
			tooltipFillColor : "rgba(51, 51, 51, 0.55)",
			data : data
		});
	</script>
	<!-- /dashbord linegraph -->
	<!-- datepicker -->
	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							var cb = function(start, end, label) {
								console.log(start.toISOString(), end
										.toISOString(), label);
								$('#reportrange span').html(
										start.format('MMMM D, YYYY') + ' - '
												+ end.format('MMMM D, YYYY'));
								//alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
							}

							var optionSet1 = {
								startDate : moment().subtract(29, 'days'),
								endDate : moment(),
								minDate : '01/01/2012',
								maxDate : '12/31/2015',
								dateLimit : {
									days : 60
								},
								showDropdowns : true,
								showWeekNumbers : true,
								timePicker : false,
								timePickerIncrement : 1,
								timePicker12Hour : true,
								ranges : {
									'Today' : [ moment(), moment() ],
									'Yesterday' : [
											moment().subtract(1, 'days'),
											moment().subtract(1, 'days') ],
									'Last 7 Days' : [
											moment().subtract(6, 'days'),
											moment() ],
									'Last 30 Days' : [
											moment().subtract(29, 'days'),
											moment() ],
									'This Month' : [ moment().startOf('month'),
											moment().endOf('month') ],
									'Last Month' : [
											moment().subtract(1, 'month')
													.startOf('month'),
											moment().subtract(1, 'month')
													.endOf('month') ]
								},
								opens : 'left',
								buttonClasses : [ 'btn btn-default' ],
								applyClass : 'btn-small btn-primary',
								cancelClass : 'btn-small',
								format : 'MM/DD/YYYY',
								separator : ' to ',
								locale : {
									applyLabel : 'Submit',
									cancelLabel : 'Clear',
									fromLabel : 'From',
									toLabel : 'To',
									customRangeLabel : 'Custom',
									daysOfWeek : [ 'Su', 'Mo', 'Tu', 'We',
											'Th', 'Fr', 'Sa' ],
									monthNames : [ 'January', 'February',
											'March', 'April', 'May', 'June',
											'July', 'August', 'September',
											'October', 'November', 'December' ],
									firstDay : 1
								}
							};
							$('#reportrange span').html(
									moment().subtract(29, 'days').format(
											'MMMM D, YYYY')
											+ ' - '
											+ moment().format('MMMM D, YYYY'));
							$('#reportrange').daterangepicker(optionSet1, cb);
							$('#reportrange').on('show.daterangepicker',
									function() {
										console.log("show event fired");
									});
							$('#reportrange').on('hide.daterangepicker',
									function() {
										console.log("hide event fired");
									});
							$('#reportrange')
									.on(
											'apply.daterangepicker',
											function(ev, picker) {
												console
														.log("apply event fired, start/end dates are "
																+ picker.startDate
																		.format('MMMM D, YYYY')
																+ " to "
																+ picker.endDate
																		.format('MMMM D, YYYY'));
											});
							$('#reportrange').on('cancel.daterangepicker',
									function(ev, picker) {
										console.log("cancel event fired");
									});
							$('#options1').click(
									function() {
										$('#reportrange').data(
												'daterangepicker').setOptions(
												optionSet1, cb);
									});
							$('#options2').click(
									function() {
										$('#reportrange').data(
												'daterangepicker').setOptions(
												optionSet2, cb);
									});
							$('#destroy').click(
									function() {
										$('#reportrange').data(
												'daterangepicker').remove();
									});
						});
	</script>
	<script>
		NProgress.done();
	</script>
	<!-- /datepicker -->
	<!-- /footer content -->
</body>

</html>