<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--header-->
<div class="header">
    <div class="header-top">
        <div class="container">
            <div class="search">
                <form>
                    <input type="text" value="Search " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
                    <input type="submit" value="Go">
                </form>
            </div>
            <div class="header-left">
                <ul>
                    <sec:authorize access="!isAuthenticated()">
                    <li><a href="<spring:url value='login'/>" ><spring:message code="loginEntry"/></a></li>
                    <li><a href="<spring:url value='register'/>" ><spring:message code="register"/></a></li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li><p><spring:message code="welcome"/> <sec:authentication property="principal.username"></sec:authentication></p></li>
                        <li><a href="<spring:url value='logout'/>" ><spring:message code="logout"/></a></li>
                    </sec:authorize>
                </ul>

                <sec:authorize access="isAuthenticated()">
                <div class="cart box_1">
                    <a href="<spring:url value='checkout'/> ">
                        <h3> <div class="total">
                            <span class="simpleCart_total"></span> (<span whiskyorder="simpleCart_quantity" class="simpleCart_quantity"></span> items)</div>
                            <img src="<spring:url value='/images/cart.png' />"></h3>
                    </a>
                    <p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>
                </div>
                </sec:authorize>

                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="container">
        <div class="head-top">
            <div class="logo">
                <a href="<spring:url value='index'/>"><img src="images/logoW.png" alt=""></a>
            </div>
            <div class=" h_menu4">
                <ul class="memenu skyblue">
                    <li class="active grid"><a class="color8" href="<spring:url value='index'/>"><spring:message code="home"/></a></li>
                    <li><a class="color1" href="#"><spring:message code="category"/></a>
                        <div class="mepanel">
                            <div class="row">
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4><a href="<spring:url value='whiskies'/>"><spring:message code="allWhisky"/></a></h4>
                                        <ul>
                                            <li><a href="<spring:url value='whiskies/SingleMalt'/>">Single Malt</a></li>
                                            <li><a href="<spring:url value='whiskies/BlendedMalt'/>">Blended Malt</a></li>
                                            <li><a href="<spring:url value='whiskies/IrishBlend'/>">Irish Blend</a></li>
                                            <li><a href="<spring:url value='whiskies/BlendedWhisky'/>">Blended Whisky</a></li>
                                            <li><a href="<spring:url value='whiskies/Bourbon'/>">Bourbon</a></li>
                                            <li><a href="<spring:url value='whiskies/Rye'/>">Rye</a></li>
                                            <li><a href="<spring:url value='whiskies/WhiskyDeBleNoir'/>">Whisky de Ble Noir</a></li>
                                            <li><a href="<spring:url value='whiskies/Blend'/>">Blend</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <a href="<spring:url value='whisky/22'/>"><img src="images/bottle/macallan-2005-gm.jpg"/></a>
                                    </div>
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <a href="<spring:url value='whisky/47'/>"><img src="images/bottle/poit-dhubh-12-ans.jpg"/></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="grid"><a class="color2" href="#">	Women</a>
                        <div class="mepanel">
                            <div class="row">
                                <div class="col1">
                                    <div class="h_nav">
                                        <ul>
                                            <li><a href="products.html">Accessories</a></li>
                                            <li><a href="products.html">Bags</a></li>
                                            <li><a href="products.html">Caps & Hats</a></li>
                                            <li><a href="products.html">Hoodies & Sweatshirts</a></li>
                                            <li><a href="products.html">Jackets & Coats</a></li>
                                            <li><a href="products.html">Jeans</a></li>
                                            <li><a href="products.html">Jewellery</a></li>
                                            <li><a href="products.html">Jumpers & Cardigans</a></li>
                                            <li><a href="products.html">Leather Jackets</a></li>
                                            <li><a href="products.html">Long Sleeve T-Shirts</a></li>
                                            <li><a href="products.html">Loungewear</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <ul>
                                            <li><a href="products.html">Shirts</a></li>
                                            <li><a href="products.html">Shoes, Boots & Trainers</a></li>
                                            <li><a href="products.html">Shorts</a></li>
                                            <li><a href="products.html">Suits & Blazers</a></li>
                                            <li><a href="products.html">Sunglasses</a></li>
                                            <li><a href="products.html">Sweatpants</a></li>
                                            <li><a href="products.html">Swimwear</a></li>
                                            <li><a href="products.html">Trousers & Chinos</a></li>
                                            <li><a href="products.html">T-Shirts</a></li>
                                            <li><a href="products.html">Underwear & Socks</a></li>
                                            <li><a href="products.html">Vests</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col1">
                                    <div class="h_nav">
                                        <h4>Popular Brands</h4>
                                        <ul>
                                            <li><a href="products.html">Levis</a></li>
                                            <li><a href="products.html">Persol</a></li>
                                            <li><a href="products.html">Nike</a></li>
                                            <li><a href="products.html">Edwin</a></li>
                                            <li><a href="products.html">New Balance</a></li>
                                            <li><a href="products.html">Jack & Jones</a></li>
                                            <li><a href="products.html">Paul Smith</a></li>
                                            <li><a href="products.html">Ray-Ban</a></li>
                                            <li><a href="products.html">Wood Wood</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li><a class="color4" href="<spring:url value='blog'/>">Blog</a></li>
                    <li><a class="color6" href="<spring:url value='contact'/>">Contact</a></li>
                </ul>
            </div>

            <div class="clearfix"> </div>
        </div>
    </div>

</div>

