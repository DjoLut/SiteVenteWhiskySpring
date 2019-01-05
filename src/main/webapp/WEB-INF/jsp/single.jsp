<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--content-->
<!---->
<div class="product">
    <div class="container">
        <div class="col-md-9 product-price1">
            <div class="col-md-5 single-top">
                <div class="flexslider">
                    <ul class="slides">
                        <li data-thumb="<spring:url value='/images/bottle/${whisky.img}' />">
                            <img src="<spring:url value='/images/bottle/${whisky.img}' />" >
                        </li>
                    </ul>
                </div>
                <!-- FlexSlider -->
                <script defer src="<spring:url value='/js/jquery.flexslider.js' />"></script>
                <link type="text/css" href="<spring:url value='/css/flexslider.css'/>" rel="stylesheet" media="screen" />

                <script>
                    // Can also be used with $(document).ready()
                    $(window).load(function() {
                      $('.flexslider').flexslider({
                        animation: "slide",
                        controlNav: "thumbnails"
                      });
                    });
                </script>
            </div>
            <div class="col-md-7 single-top-in simpleCart_shelfItem">
                <div class="single-para ">
                    <h4>${whisky.whiskyName}</h4>

                    <div class="clearfix"> </div>
							
                    <h5 class="item_price">${whisky.price} &euro;</h5>

                    <p>${whisky.alcoholContent} %</p>

                    <p>${whisky.categorie.nom}</p>

                    <p>${whisky.country}</p>

                    <c:if test="${whisky.stockQuantity > 0}" >
                        <form action="/whisky/single/${whisky.id}/add" method="POST">
                            <input type="number" min="1" max="${whisky.stockQuantity}" value="1" name="quantity">
                            <input type="hidden" value="${whisky.id}" name="whisky">
                            <div class="clearfix"> </div>
                            <input type="submit" value="<spring:message code="add"/>" id="login"/>
                        </form>
                    </c:if>
                    <c:if test="${whisky.stockQuantity == 0}">
                        <p><spring:message code="outOfStock"/></p>
                    </c:if>

                </div>
            </div>
            <div class="clearfix"> </div>
			<!---->
            <div class="cd-tabs">
                <nav>
                    <ul class="cd-tabs-navigation">
                        <li><a data-content="fashion"  href="#0"><spring:message code="description"/></a></li>
                    </ul>
			    </nav>
                <ul class="cd-tabs-content">
                    <li data-content="fashion" >
                        <div class="facts">
                            <p>${translation.descriptions}</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"> </div>

<!--//content-->
			