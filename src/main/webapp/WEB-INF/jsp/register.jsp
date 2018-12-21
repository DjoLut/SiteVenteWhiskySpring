<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--content-->
<div class=" container">
<div class=" register">
	<h1>Register</h1>
		  	  <form:form id="form" method="POST" modelAttribute="user">
				 <div class="col-md-6 register-top-grid">
					<h3>Personal infomation</h3>
					 <div>
						 <span><form:label path="firstname">First Name</form:label></span>
						<form:input path="firstname" type="text"/>
					 </div>
					 <div>
						 <span><form:label path="lastname">Last Name</form:label></span>
						<form:input path="lastname" type="text"/>
					 </div>
					 <div>
						 <span><form:label path="email">Email Address</form:label></span>
						 <form:input path="email" type="text"/>
					 </div>
					 <div>
						 <span><form:label path="adresse">Address</form:label></span>
						 <form:input path="adresse" type="text"/>
					 </div>
					 <div>
						 <span><form:label path="numberTVA">TVA number</form:label></span>
						 <form:input path="numberTVA" type="text"/>
					 </div>
					 
					 </div>
				     <div class="col-md-6 register-bottom-grid">
						    <h3>Login information</h3>
							 <div>
								 <span><form:label path="username">Login</form:label></span>
								 <form:input path="username" type="text" />
							 </div>
							 <div>
								 <span><form:label path="password">Password</form:label></span>
								<form:input path="password" type="password"/>
							 </div>
							 <div>
								<span>Confirm Password</span>
								<input type="password">
							 </div>
						 	<form:button id="login">Register</form:button>
					 </div>
					 <div class="clearfix"> </div>
				</form:form>
			</div>
</div>