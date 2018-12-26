<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
							<form:input path="firstname" type="text"/>
							<form:errors path="firstname"/>
					 	</spring:bind>
					 </div>
					 <div>
						 <span><form:label path="lastname"><spring:message code="lastname"/></form:label></span>
						<form:input path="lastname" type="text"/>
						 <form:errors path="lastname"/>
					 </div>
					 <div>
						 <span><form:label path="email"><spring:message code="email"/></form:label></span>
						 <form:input path="email" type="text"/>
						 <form:errors path="email"/>
					 </div>
					 <div>
						 <span><form:label path="adresse"><spring:message code="adresse"/></form:label></span>
						 <form:input path="adresse" type="text"/>
						 <form:errors path="adresse"/>
					 </div>
					 <div>
						 <span><form:label path="numberTVA"><spring:message code="TVA"/></form:label></span>
						 <form:input path="numberTVA" type="text"/>
					 </div>
					 
					 </div>
				     <div class="col-md-6 register-bottom-grid">
						    <h3><spring:message code="loginInformation"/></h3>
							 <div>
								 <span><form:label path="username"><spring:message code="login"/></form:label></span>
								 <form:input path="username" type="text" />
								 <form:errors path="username"/>
							 </div>
							 <div>
								 <span><form:label path="password"><spring:message code="password"/></form:label></span>
								<form:input path="password" type="password"/>
								 <form:errors path="password"/>
							 </div>
							 <div>
								 <span><form:label path="confPassword"><spring:message code="confPassword"/></form:label></span>
								<form:input path="confPassword" type="password"/>
								 <form:errors path="confPassword"/>
							 </div>
						 	<form:button id="login"><spring:message code="sendButton"/></form:button>
					 </div>
					 <div class="clearfix"> </div>
				</form:form>
			</div>
</div>