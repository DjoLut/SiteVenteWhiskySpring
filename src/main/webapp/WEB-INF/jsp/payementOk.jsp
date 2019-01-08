<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">
    <div class="blog">
	    <p><spring:message code="payementOk" /></p>
        <p><a href="<spring:url value='/checkout'/> "><spring:message code="cart"/></a></p>
    </div>
</div>