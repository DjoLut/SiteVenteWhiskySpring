<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--content-->
<div class="container">
	<div class="account">
		<h1><spring:message code="loginInformation"/></h1>
		<div class="account-pass">
		<div class="col-md-8 account-top">
			<form:form id="form" method="POST" modelAttribute="user">
				<form:errors>Login et password obligatoire</form:errors>
				<div>
					<form:label path="username"><spring:message code="firstname"/></form:label>
					<form:input path="username" type="text"/>
				</div>
				<div>
					<form:label path="password"><spring:message code="password"/></form:label>
					<form:input path="password" type="password" />
				</div>
				<div>
					<form:button id="login"><spring:message code="sendButton"/></form:button>
				</div>
			</form:form>
		</div>
		<div class="col-md-4 left-account ">
			<img src="<spring:url value='/images/bottle/loginImage.jpg' />">
			<a href="<spring:url value='/register'/>" class="create"><spring:message code="register"/></a>
			<div class="clearfix"> </div>
		</div>
	<div class="clearfix"> </div>
	</div>
	</div>

</div>
