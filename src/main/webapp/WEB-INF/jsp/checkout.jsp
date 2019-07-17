<%@ include file="include/importTags.jsp" %>

<div class="container">
        <div class="check">
            <h1><spring:message code="shoppingBag"/> (${mainPanier.getWhiskys().size()})</h1>
            <div class="col-md-9 cart-items">
                <c:set var="totalPrice" value="${mainPanier.calculTotalPrice()}" />
                <c:set var="totalPromo" value="${mainPanier.calculTotalPromo()}" />
                <c:forEach items="${mainPanier.getWhiskys()}" var="mainPanier">
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
                        <input type="hidden" value="${mainPanier.key.id}" name="whisky">
                        <input type="submit" id="checkout" value=""/>
                    </form>

                    <div class="cart-sec simpleCart_shelfItem">
                        <div class="cart-item cyc">
                            <img src="<spring:url value='/images/bottle/${mainPanier.key.img}' />" class="img-responsive" alt=""/>
                        </div>
                        <div class="cart-item-info">
                            <h3><a href="<spring:url value='/single/${mainPanier.key.id}'/>">${mainPanier.key.whiskyName}</a><span>${mainPanier.key.alcoholContent} %</span></h3>
                            <ul class="qty">
                                <li>
                                    <p>
                                        <spring:message code="quantity"/> : ${mainPanier.value}

                                    <form action="/whisky/checkout/modify" method="POST">
                                        <input type="number" min="1" max="${mainPanier.key.stockQuantity}" value="${mainPanier.value}" name="quantity"
                                               oninvalid="this.setCustomValidity('<spring:message code='badQuantity'/>${mainPanier.key.stockQuantity}')"
                                               oninput="this.setCustomValidity('')"
                                               alt="<spring:message code='badQuantity'/>${mainPanier.key.stockQuantity}}"
                                               title="<spring:message code='badQuantity'/>${mainPanier.key.stockQuantity}">
                                        <input type="hidden" value="${mainPanier.key.id}" name="whisky">
                                        <input type="submit" value="<spring:message code="changeQuantity"/>" />
                                    </form>
                                    </p>
                                </li>
                            </ul>
                            <c:if test="${not empty mainPanier.key.promotion}">
                                <h3><fmt:formatNumber value="${mainPanier.key.price*mainPanier.value}" type="currency" currencySymbol="&euro;"/></h3>
                                - <fmt:formatNumber value="${mainPanier.key.promotion/100*mainPanier.key.price*mainPanier.value}" type="currency" currencySymbol=""/>
                            </c:if>
                            <c:if test="${empty mainPanier.key.promotion}">
                                <h3><fmt:formatNumber value="${mainPanier.key.price*mainPanier.value}" type="currency" currencySymbol="&euro;"/></h3>
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
                    <c:if test="${mainPanier.size() != 0}">
                        <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post" onsubmit="return window.open('http://localhost:8082/whisky/checkout/validate')">
                            <input type="hidden" name="business" value="jordan.lutgen.business@hotmail.com">

                            <input type="hidden" name="cmd" value="_xclick">
                            <input type="hidden" name="hosted_button_id" value="HMAZCTEMUDKFS">
                            <c:if test="${(totalPrice-totalPromo) >= 100}">
                                <input type="hidden" name="amount" value="${totalPrice-totalPromo}">
                            </c:if>
                            <c:if test="${(totalPrice-totalPromo) < 100}">
                                <input type="hidden" name="amount" value="${mainPanier.totalPriceWhisky()}">
                            </c:if>
                            <input type="hidden" name="item_name" value="whisky">
                            <input type="hidden" name="lc" value="<spring:message code='urlLanguage'/>">
                            <input type="hidden" name="currency_code" value="EUR">

                            <input type="hidden" name="return" value="http://localhost:8082/whisky/payementOk">
                            <input type="hidden" name="cancel_return" value="http://localhost:8082/whisky/payementOk">

                            <input id="validate" type="image" name="submit"
                                   src="https://www.paypalobjects.com/<spring:message code='urlLanguage'/>/i/btn/btn_buynow_LG.gif"
                                   alt="<spring:message code='paypalAlt'/>" onclick="return confirm('<spring:message code='confirmation'/>')">
                            <img alt="" width="1" height="1"
                                 src="https://www.paypalobjects.com/<spring:message code='urlLanguage'/>/i/scr/pixel.gif" >
                        </form>
                    </c:if>
                    <c:if test="${mainPanier.size() == 0}">
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
                     <c:if test="${(totalPrice-totalPromo) >= 100  and mainPanier.size() != 0}">
                         <li class="last_price"><h4><spring:message code="shippingCost"/></h4></li>
                         <li class="last_price"><h4><spring:message code="freeShippingCost"/></h4></li>
                         <li class="last_price"><h4><spring:message code="total"/></h4></li>
                         <li class="last_price"><h4><fmt:formatNumber value="${totalPrice-totalPromo}" type="currency" currencySymbol=""/> &euro;</h4></li>
                     </c:if>
                     <c:if test="${(totalPrice-totalPromo) < 100 and mainPanier.size() !=0}">
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
