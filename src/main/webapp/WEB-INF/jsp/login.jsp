<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--content-->
<div class="container">
	<div class="account">
		<h1>Account</h1>
		<div class="account-pass">
		<div class="col-md-8 account-top">
			<form:form id="form" method="POST" modelAttribute="user">
				<div>
					<form:label path="username">Login</form:label>
					<form:input path="username" type="text"/>
				</div>
				<div>
					<form:label path="password">Password</form:label>
					<form:input path="password" type="password" />
				</div>
				<div>
					<form:button id="login">Login</form:button>
				</div>
			</form:form>
		</div>
		<div class="col-md-4 left-account ">
			<a href="<spring:url value='register'/>" class="create">Create an account</a>
			<div class="clearfix"> </div>
		</div>
	<div class="clearfix"> </div>
	</div>
	</div>

</div>
