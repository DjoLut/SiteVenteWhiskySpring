<%@ include file="include/importTags.jsp" %>

<!--content-->
<div class=" container">
<div class=" register">
	<h1><spring:message code="register"/></h1>
			<form:form id="form" method="POST" modelAttribute="user">
				 <div class="col-md-6 register-top-grid">
					<h3><spring:message code="personalInformation"/></h3>
					 <div>
					 	<spring:bind path="username">
							<span><form:label path="firstname"><spring:message code="firstname"/></form:label></span>
							<form:errors path="firstname"/>
							<form:input path="firstname" type="text"/>
					 	</spring:bind>
					 </div>
					 <div>
						 <span><form:label path="lastname"><spring:message code="lastname"/></form:label></span>
						 <form:errors path="lastname"/>
						<form:input path="lastname" type="text"/>
					 </div>
					 <div>
						 <span><form:label path="email"><spring:message code="email"/></form:label></span>
						 <form:errors path="email"/>
						 <form:input path="email" type="text"/>
					 </div>
					 <div>
						 <span><form:label path="adresse"><spring:message code="adresse"/></form:label></span>
						 <form:errors path="adresse"/>
						 <form:input path="adresse" type="text"/>
					 </div>
					 <div>
						 <span><form:label path="telephone"><spring:message code="phone"/></form:label></span>
						 <form:errors path="telephone"/>
						 <form:input path="telephone" type="tel"/>
					 </div>
					 
					 </div>
				     <div class="col-md-6 register-bottom-grid">
						    <h3><spring:message code="loginInformation"/></h3>
							 <div>
								 <span><form:label path="username"><spring:message code="login"/></form:label></span>
								 <form:errors path="username"/>
								 <form:input path="username" type="text" />
							 </div>
							 <div>
								 <span><form:label path="password"><spring:message code="password"/></form:label></span>
								 <form:errors path="password"/>
								<form:input path="password" type="password"/>
							 </div>
							 <div>
								 <span><form:label path="confPassword"><spring:message code="confPassword"/></form:label></span>
								 <form:errors path="confPassword"/>
								<form:input path="confPassword" type="password"/>
							 </div>
						 	<form:button id="login"><spring:message code="sendButton"/></form:button>
					 </div>
					 <div class="clearfix"> </div>
				</form:form>
			</div>
</div>