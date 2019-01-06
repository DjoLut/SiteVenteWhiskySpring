<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
        <div class="check">
            <h1><spring:message code="shoppingBag"/> (${panier.getWhiskys().size()})</h1>
            <div class="col-md-9 cart-items">
                <c:set var="totalPrice" value="${calculTotalPrice}" />
                <c:set var="totalPromo" value="${calculTotalPromo}" />
                <c:forEach items="${panier.getWhiskys()}" var="panier">
				<script>$(document).ready(function(c) {
					$('.close1').on('click', function(c){
						$('.cart-header').fadeOut('slow', function(c){
							$('.cart-header').remove();
						});
						});
					});
			   </script>
                <div class="cart-header">
                    <form action="/whisky/checkout/delete" method="POST">
                        <input type="hidden" value="${panier.key.id}" name="whisky">
                        <input type="submit" id="checkout" value=""/>
                    </form>
                    <div class="cart-sec simpleCart_shelfItem">
                        <div class="cart-item cyc">
                            <img src="<spring:url value='/images/bottle/${panier.key.img}' />" class="img-responsive" alt=""/>
                        </div>
                        <div class="cart-item-info">
                            <h3><a href="<spring:url value='/single/${panier.key.id}'/>">${panier.key.whiskyName}</a><span>${panier.key.alcoholContent} %</span></h3>
                            <ul class="qty">
                                <li>
                                    <p>
                                        Qty : ${panier.value}
                                        <form action="/whisky/checkout/modify" method="POST">
                                            <input type="number" min="1" max="${panier.key.stockQuantity}" value="${panier.value}" name="quantity">
                                            <input type="hidden" value="${panier.key.id}" name="whisky">
                                            <input type="submit" value="<spring:message code="changeQuantity"/>" />
                                        </form>
                                    </p>
                                </li>
                            </ul>
                            <c:if test="${not empty panier.key.promotion}">
                                <h3><fmt:formatNumber value="${panier.key.price*panier.value}" type="currency" currencySymbol="&euro;"/></h3>
                                - <fmt:formatNumber value="${panier.key.promotion/100*panier.key.price*panier.value}" type="currency" currencySymbol=""/>
                            </c:if>
                            <c:if test="${empty panier.key.promotion}">
                                <h3><fmt:formatNumber value="${panier.key.price*panier.value}" type="currency" currencySymbol="&euro;"/></h3>
                            </c:if>
                            <div class="clearfix"></div>
					   </div>
					   <div class="clearfix"></div>
                    </div>
                </div>
                </c:forEach>
            </div>

            <div class="col-md-3 cart-total">
                <sec:authorize access="isAuthenticated()">
                    <c:if test="${panier.size() != 0}">
                        <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                            <input type="hidden" name="business" value="jordan.lutgen.business@hotmail.com">

                            <input type="hidden" name="cmd" value="_xclick">
                            <input type="hidden" name="hosted_button_id" value="HMAZCTEMUDKFS">
                            <c:if test="${(totalPrice-totalPromo) > 99}">
                                <input type="hidden" name="amount" value="${totalPrice-totalPromo}">
                            </c:if>
                            <c:if test="${(totalPrice-totalPromo) < 100}">
                                <input type="hidden" name="amount" value="${totalPrice-totalPromo+30}">
                            </c:if>
                            <input type="hidden" name="item_name" value="whisky">
                            <input type="hidden" name="currency_code" value="EUR">

                            <input type="hidden" name="return" value="http://localhost:8082/whisky/checkout/validate">
                            <input type="hidden" name="cancel_return" value="http://localhost:8082/whisky/checkout">

                            <input id="validate" type="image" name="submit"
                                   src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
                                   alt="PayPal - The safer, easier way to pay online" onclick="return confirm('<spring:message code='confirmation'/>')">
                            <img alt="" width="1" height="1"
                                 src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >
                        </form>
                    </c:if>
                    <c:if test="${panier.size() == 0}">
                        <a class="continue" href="<spring:url value='/whiskies'/>" ><spring:message code="AddWhisky"/></a>
                    </c:if>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <a class="continue" href="<spring:url value='/login'/>" ><spring:message code="loginEntry"/></a>
                </sec:authorize>
                 <div class="price-details">
                     <h3><spring:message code="priceDetails"/></h3>
                     <span><spring:message code="total"/></span>
                     <span class="total1"><fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol=""/> &euro;</span>
                     <span><spring:message code="discount"/></span>
                     <span class="total1">- <fmt:formatNumber value="${totalPromo}" type="currency" currencySymbol=""/> &euro;</span>
                     <span><spring:message code="total"/></span>
                     <span class="total1"><fmt:formatNumber value="${totalPrice-totalPromo}" type="currency" currencySymbol=""/> &euro;</span>
                     <div class="clearfix"></div>
                 </div>
                 <ul class="total_price">
                     <c:if test="${(totalPrice-totalPromo) > 99  and panier.size() != 0}">
                         <li class="last_price"><h4><spring:message code="shippingCost"/></h4></li>
                         <li class="last_price"><h4><spring:message code="freeShippingCost"/></h4></li>
                         <li class="last_price"><h4><spring:message code="total"/></h4></li>
                         <li class="last_price"><h4><fmt:formatNumber value="${totalPrice-totalPromo}" type="currency" currencySymbol=""/> &euro;</h4></li>
                     </c:if>
                     <c:if test="${(totalPrice-totalPromo) < 100 and panier.size() !=0}">
                         <li class="last_price"><h4><spring:message code="shippingCost"/></h4></li>
                         <li class="last_price"><h4>+ 30 &euro;</h4></li>
                         <li class="last_price"><h4><spring:message code="total"/></h4></li>
                         <li class="last_price"><h4><fmt:formatNumber value="${totalPrice-totalPromo+30}" type="currency" currencySymbol=""/> &euro;</h4></li>
                     </c:if>
                     <div class="clearfix"> </div>
                 </ul>


                 <div class="clearfix"></div>
            </div>

            <div class="clearfix"> </div>
        </div>
</div>
