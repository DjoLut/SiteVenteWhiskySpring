<%@ include file="include/importTags.jsp" %>

<!--content-->
<div class="container">
	<div class="account">
		<h1><spring:message code="loginInformation"/></h1>
		<div class="account-pass">
		<div class="col-md-8 account-top">
			<c:if test="${param.error == 'true'}">
				<div style="color: red">
					<spring:message code="loginfailed"/><br />
					<spring:message code="badUserOrPass"/>
				</div>
			</c:if>
			<form:form id="form" method="POST" modelAttribute="user">
				<div>
					<form:label path="username"><spring:message code="login"/></form:label>
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
