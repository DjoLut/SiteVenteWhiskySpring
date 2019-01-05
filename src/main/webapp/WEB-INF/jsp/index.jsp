<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="banner">
    <div class="container">

        <script>
            $(function () {
                $("#slider").responsiveSlides({
                    auto: true,
                    nav: true,
                    speed: 500,
                    namespace: "callbacks",
                    pager: true,
                });
            });
        </script>
        <div  whiskyorder="top" class="callbacks_container">
            <ul class="rslides" whiskyorder="slider">
                <li>

                    <div class="banner-text">
                        <h3><spring:message code="index.Banner1"/></h3>
                        <p style="background-image:url(<spring:url value="images/Fond-noir.png"/>); height:100%; flood-opacity: 0.2;"><spring:message code="index.Banner1.p"/></p>
                        <a href="<spring:url value="/whiskies"/>"><spring:message code="index.Banner1.a"/></a>
                    </div>

                </li>
            </ul>
        </div>
    </div>
</div>
<div class="clearfix"> </div>

<div class="product">
    <div class="container">
        <h2 style="opacity:1; color:black; font-family: 'Lato', sans-serif; text-align: center"><spring:message code="promotions"/></h2>
        <br /><br />
        <div class=" bottom-product">
            <c:set var="compteur" value="${0}"/>
            <c:forEach items="${whisky}" var="whisky">
                <c:choose>
                    <c:when test="${whisky.promotion != null and compteur < 6}">
                        <c:set var="compteur" value="${compteur = compteur + 1}"/>
                        <div class="col-md-4 bottom-cd simpleCart_shelfItem">
                            <div class="product-at ">
                                <a href="<spring:url value='/single/${whisky.id}'/>">
                                    <img class="img-responsive" src="<spring:url value='/images/bottle/${whisky.img}' />" >
                                    <div class="pro-grid">
                                        <c:if test="${whisky.stockQuantity > 0}">
                                            <span class="buy-in"><spring:message code="buyNow"/></span>
                                        </c:if>
                                        <c:if test="${whisky.stockQuantity == 0}">
                                            <span class="buy-in"><spring:message code="outOfStock"/></span>
                                        </c:if>
                                    </div>
                                </a>
                            </div>

                            <p class="tun">${whisky.whiskyName}</p>

                            <a href="<spring:url value='/single/${whisky.id}'/>" class="item_add">
                                <p class="number item_price">
                                    <i> </i><del>${whisky.price} &euro;</del> <fmt:formatNumber value="${whisky.price-(whisky.promotion/100*whisky.price)}" type="currency" currencySymbol=""/> &euro;
                                </p>
                            </a>
                        </div>
                    </c:when>
                </c:choose>
            </c:forEach>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<hr style="width:75%; color:black; background-color:black; height:1px;" />

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
