<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--content-->
<div class="blog">
	<h1><spring:message code="description"/></h1>
	<div class="product">
		<div class="container" >
			<div class="col-md-6 register-top-grid">
				<div style="float: right">
					<h2 style="text-align: right; opacity:1; color:black;"><spring:message code="index.info.crea.h"/></h2>
					<p class="nav-bottom" style="width: 300px; text-align: right; opacity:1; color: black;"><spring:message code="index.info.crea.p"/></p>
				</div>
			</div>
			<div class="col-md-6 register-top-grid">
				<img src="<spring:url value='/images/index.Pres.001.jpg'/>" style="max-width: 65%; float: left"/>
			</div>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<!--//content-->