<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="totalPrice" value="${panier.calculTotalPrice()}" />
<c:set var="totalPromo" value="${panier.calculTotalPromo()}" />

<c:set var="total" value="${totalPrice-totalPromo+(totalPrice-totalPromo<100&&totalPrice-totalPromo!=0?30:0)}" />


<!--header-->
<div class="header">
    <div class="header-top">
        <div class="container">
            <div class="search">

            </div>
            <div class="header-left">
                <spring:url var="localEn" value="">
                    <spring:param name="locale" value="en"/>
                </spring:url>
                <spring:url var="localFr" value="">
                    <spring:param name="locale" value="fr"/>
                </spring:url>
    
                <ul>
                    <li><a href="${localEn}"><img class="icoLang" src="<spring:url value='/images/icoLangEn.png'/>"></a>
                        <a href="${localFr}"><img class="icoLang" src="<spring:url value='/images/icoLangFr.png'/>"></a></li>
                </ul>
                <ul>
                    <sec:authorize access="!isAuthenticated()">
                        <li><a href="<spring:url value='/login'/>" ><spring:message code="loginEntry"/></a></li>
                        <li><a href="<spring:url value='/register'/>" ><spring:message code="register"/></a></li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li><p><spring:message code="welcome"/> <sec:authentication property="principal.username"></sec:authentication></p></li>
                        <li><a href="<spring:url value='/logout'/>" ><spring:message code="logout"/></a></li>
                    </sec:authorize>
                </ul>

                <div class="cart box_1">
                    <a href="<spring:url value='/checkout'/> ">
                        <h3>
                            <div class="total"><spring:message code="cart"/> (${panier.countWhisky()}) <fmt:formatNumber value="${total}" type="currency" currencySymbol="&euro;"/></div>
                            <img src="<spring:url value='/images/cart.png' />">
                        </h3>
                    </a>
                    <p><a href="<spring:url value='/checkout/delete'/>" class="simpleCart_empty"><spring:message code="emptyCart"/></a></p>
                </div>

                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="container">
        <div class="head-top">
            <div class="logo">
                <a href="<spring:url value='/index'/>"><img src="<spring:url value='/images/logoW.png' />" ></a>
            </div>
            <div class=" h_menu4">
                <ul class="memenu skyblue">
                    <li><a class="color3" href="<spring:url value='/index'/>"><spring:message code="home"/></a></li>
                    <li><a class="color1" href="#"><spring:message code="category"/></a>
                        <div class="mepanel">
                            <div class="row">
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4><a href="<spring:url value='/whiskies'/>"><spring:message code="allWhisky"/></a></h4>
                                        <ul>
                                            <li><a href="<spring:url value='/whiskies/Single Malt'/>">Single Malt</a></li>
                                            <li><a href="<spring:url value='/whiskies/Blended Malt'/>">Blended Malt</a></li>
                                            <li><a href="<spring:url value='/whiskies/Irish Blend'/>">Irish Blend</a></li>
                                            <li><a href="<spring:url value='/whiskies/Blended Whisky'/>">Blended Whisky</a></li>
                                            <li><a href="<spring:url value='/whiskies/Bourbon'/>">Bourbon</a></li>
                                            <li><a href="<spring:url value='/whiskies/Rye'/>">Rye</a></li>
                                            <li><a href="<spring:url value='/whiskies/Whisky de Ble Noir'/>">Whisky de Ble Noir</a></li>
                                            <li><a href="<spring:url value='/whiskies/Blend'/>">Blend</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <a href="<spring:url value='/single/22'/>"><img src="<spring:url value='/images/bottle/macallan-2005-gm.jpg' />"/></a>
                                    </div>
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <a href="<spring:url value='/single/47'/>"><img src="<spring:url value='/images/bottle/poit-dhubh-12-ans.jpg' />"/></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li><a class="color4" href="<spring:url value='/description'/>"><spring:message code="description"/></a></li>
                </ul>
            </div>

            <div class="clearfix"> </div>
        </div>
    </div>

</div>

