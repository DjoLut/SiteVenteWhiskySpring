<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@ include file="../jsp/include/header.jsp" %>
	
<!--content-->
<div class=" container">
<div class=" register">
	<h1>Register</h1>
		  	  <form:form whiskyorder="form" method="POST" action="/whiskyEntity/register/send" modelAttribute="user">
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
								 <span><form:label path="username">login</form:label></span>
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
							 <imput type="submit" value="submit"/>
							
					 </div>
					 <div class="clearfix"> </div>
				</form:form>
			</div>
</div>
<!--//content-->
<div class="footer">
				<div class="container">
			<div class="footer-top-at">
			
				<div class="col-md-4 amet-sed">
				<h4>MORE INFO</h4>
				<ul class="nav-bottom">
						<li><a href="#">How to whiskyorder</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="contact.html">Location</a></li>
						<li><a href="#">Shipping</a></li>
						<li><a href="#">Membership</a></li>	
					</ul>	
				</div>
				<div class="col-md-4 amet-sed ">
				<h4>CONTACT US</h4>
				
					<p>
Contrary to popular belief</p>
					<p>The standard chunk</p>
					<p>office:  +12 34 995 0792</p>
					<ul class="social">
						<li><a href="#"><i> </i></a></li>						
						<li><a href="#"><i class="twitter"> </i></a></li>
						<li><a href="#"><i class="rss"> </i></a></li>
						<li><a href="#"><i class="gmail"> </i></a></li>
						
					</ul>
				</div>
				<div class="col-md-4 amet-sed">
					<h4>Newsletter</h4>
					<p>Sign Up to get all news update
and promo</p>
					<form>
						<input type="text" value="" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
						<input type="submit" value="Sign up">
					</form>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="footer-class">
		<p >© 2015 New store All Rights Reserved | Design by  <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
		</div>
		</div>
</body>
</html>
			