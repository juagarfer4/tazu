<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!-- Main content -->
<div class="page-wrap container">
	<div class="col-md-12 no-padding">
		<div class="row">
			<div class="col-md-6">
				<!-- Video content -->
				<div class="video">
					<iframe src="https://www.youtube.com/embed/o14faM1qTdY?autoplay=0"
						class="full-video" height="300"></iframe>
				</div>
				<!-- Video content -->
			</div>
			<div class="col-md-6">
				<h4>
					<spring:message code="about.info.title"></spring:message>
				</h4>
				<p>
					<spring:message code="about.info"></spring:message>
				</p>
				<div class="space20"></div>
				<p>
					<spring:message code="about.info2"></spring:message>
				</p>
				<p>
					<spring:message code="about.info3"></spring:message>
				</p>
			</div>
		</div>
	</div>

	<div class="divider"></div>
	<div class="space30"></div>

	<!-- Team content -->
	<h3 class="head-title"><spring:message code="about.meet.team"></spring:message></h3>
	<div class="row team-wrap">
		<div class="col-md-12 no-padding">
			<div class="col-md-6">
				<div class="team-author">
					<img src="images/demo/team/fran.png" alt="img" />
				</div>
				<div class="team-info">
					<h4>Francisco J. Macías</h4>
					<h6>
						<em><spring:message code="about.role.pm"></spring:message></em>
					</h6>
					<p>
						<a target="target" href="mailto:framacgar2@alum.us.es"><i
							class="fa fa-envelope-o"></i> framacgar2@alum.us.es</a>
					</p>
					<p>
						<a target="target"
                            href="https://es.linkedin.com/in/francisco-josé-macías-garcía-99117a110"><i
                            class="fa fa-linkedin"></i> Francisco José Macías García</a>
					</p>
					<p>
						 <br />
					</p>
					<br /> <br /> <br />
				</div>
			</div>
			<div class="col-md-6">
				<div class="team-author">
					<img src="images/demo/team/vladi.png" alt="img" />
				</div>
				<div class="team-info">
					<h4>Vladimir Rico</h4>
					<h6>
						<em><spring:message code="about.role.spokesman"></spring:message></em>
					</h6>
					<p>
						<a target="target" href="mailto:vlaricheb@alum.us.es"><i
							class="fa fa-envelope-o"></i> vlaricheb@alum.us.es</a>
					</p>
					<p>
						<a target="target"
                            href="https://es.linkedin.com/in/vladimir-rico-hebles-2a9478117"><i
                            class="fa fa-linkedin"></i> Vladimir Rico Hebles</a>
					</p>
					<p>
						 <br />
					</p>
					<br /> <br /> <br />
				</div>
			</div>
			<div class="col-md-6">
				<div class="team-author">
					<img src="images/demo/team/juan.png" alt="img" />
				</div>
				<div class="team-info">
					<h4>Juan García-Quismondo</h4>
					<h6>
						<em><spring:message code="about.role.analyst"></spring:message></em>
					</h6>
					<p>
						<a target="target" href="mailto:juagarfer4@alum.us.es"><i
							class="fa fa-envelope-o"></i> juagarfer4@alum.us.es</a>
					</p>
					<p>
						 <a target="target" href="https://github.com/juagarfer4"><i
                            class="icon-github3"></i> juagarfer4</a>
					</p>
					<p>
						<br />
					</p>
					<br /> <br /> <br />
				</div>
			</div>
			<br /> <br />
			<div class="col-md-6">
				<div class="team-author">
					<img src="images/demo/team/robe.png" alt="img" />
				</div>
				<div class="team-info">
					<h4>Roberto Jiménez</h4>
					<h6>
						<em><spring:message code="about.role.designer"></spring:message></em>
					</h6>
					<p>
						<a target="target" href="mailto:robjimcas@alum.us.es"><i
							class="fa fa-envelope-o"></i> robjimcas@alum.us.es</a>
					</p>
					<p>
						<a target="target"
							href="https://es.linkedin.com/in/roberto-jiménez-5150a5b6"><i
							class="fa fa-linkedin"></i> Roberto Jiménez Castillo</a>
					</p>
					<p>
						<br />
					</p>
					<br /> <br /> <br />
				</div>
			</div>
			<br /> <br />
			<div class="col-md-6">
				<div class="team-author">
					<img src="images/demo/team/alfre.png" alt="img" />
				</div>
				<div class="team-info">
					<h4>Alfredo Menéndez</h4>
					<h6>
						<em><spring:message code="about.role.developer"></spring:message></em>
					</h6>
					<p>
						<a target="target" href="mailto:alfmencha@alum.us.es"><i
							class="fa fa-envelope-o"></i> alfmencha@alum.us.es</a>
					</p>
					<p>
						<a target="target" href="https://github.com/alfmencha"><i
                            class="icon-github3"></i> alfmencha </a>
					</p>
					<p>
						<br />
					</p>
					<br /> <br /> <br />
				</div>
			</div>
			<br /> <br />
			<div class="col-md-6">
				<div class="team-author">
					<img src="images/demo/team/ruben.png" alt="img" />
				</div>
				<div class="team-info">
					<h4>Rubén Ramírez</h4>
					<h6>
						<em><spring:message code="about.role.developer"></spring:message></em>
					</h6>
					<p>
						<a target="target" href="mailto:rubramver@alum.us.es"><i
							class="fa fa-envelope-o"></i> rubramver@alum.us.es</a>
					</p>
					<p>
					</p>
					<p>
						<a target="target"
							 href="https://es.linkedin.com/in/rubenramirezvera"><i
                            class="fa fa-linkedin"></i> Rubén Ramírez Vera</a>
					</p>
					<br /> <br /> <br />
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Main content -->