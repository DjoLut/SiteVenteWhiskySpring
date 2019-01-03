<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
        <div class="check">
            <h1><spring:message code="shoppingBag"/> (${panier.size()})</h1>
            <div class="col-md-9 cart-items">
                <c:set var="total" value="${0}" />
                <c:set var="promo" value="${0}" />
                <c:forEach items="${panier}" var="panier">
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
                                            <input type="number" min="1" max="999" value="${panier.value}" name="quantity">
                                            <input type="hidden" value="${panier.key.id}" name="whisky">
                                            <input type="submit" value="Change quantity" />
                                        </form>
                                    </p>
                                </li>
                            </ul>
                            <h3>${(panier.key.price*panier.value)-promotion} &euro;</h3>
                            <div class="clearfix"></div>
					   </div>
					   <div class="clearfix"></div>
                    </div>
                </div>
                    <c:set var="total" value="${total + (panier.key.price*panier.value)}" />
                    <c:set var="promo" value="${promo + promotion}" />
                </c:forEach>
            </div>

            <div class="col-md-3 cart-total">
                <sec:authorize access="isAuthenticated()">
                    <c:if test="${panier.size() != 0}">
                        <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                            <input type="hidden" name="utilisateur" value="<sec:authentication property="principal.username"/>" />
                            <input type="hidden" name="promotion" value="${promo}" />
                            <input type="hidden" name="totalprice" value="${total}" />

                            <input type="hidden" name="business" value="jordan.lutgen.business@hotmail.com">
                            <input type="hidden" name="password" value="EIv6nB2i7eBuAkFRh8RvNDatl0uQeVJTv_wh85uFfPnYh88SPQyDgmelRvCAELjICLLMbTrUQOIqj2K-">
                            <input type="hidden" name="cert_id" value="AcMqbG3VnQLrUd8JudoU1o_Nv5yAfCCm5KbchYw34P2CdeCvmF9AMLvcVFPM9v75Wk5uB1GGbN7S9m8B">
                            <input type="hidden" name="cmd" value="_xclick">
                            <input type="hidden" name="hosted_button_id" value="HMAZCTEMUDKFS">
                            <input type="hidden" name="amount" value="${total-promo}">
                            <input type="hidden" name="item_name" value="whisky">
                            <input type="hidden" name="currency_code" value="EUR">

                            <input type="hidden" name="return" value="http://localhost:8082/whisky/checkout/validate">
                            <input type="hidden" name="cancel_return" value="http://localhost:8082/whisky/checkout">

                            <input id="validate" type="image" name="submit"
                                   src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
                                   alt="PayPal - The safer, easier way to pay online" onclick="return confirm('Voulez-vous confirmer votre commande ?')">
                            <img alt="" width="1" height="1"
                                 src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >
                        </form>
                    </c:if>
                    <c:if test="${panier.size() == 0}">
                        <a class="continue" href="<spring:url value='/whiskies'/>" >Add whiskys</a>
                    </c:if>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <a class="continue" href="<spring:url value='/login'/>" ><spring:message code="loginEntry"/></a>
                </sec:authorize>
                 <div class="price-details">
                     <h3>Price Details</h3>
                     <span>Total</span>
                     <span class="total1">${total} &euro;</span>
                     <span>Discount</span>
                     <span class="total1">-${promo} &euro;</span>
                     <div class="clearfix"></div>
                 </div>
                 <ul class="total_price">
                   <li class="last_price"><h4>TOTAL</h4></li>
                   <li class="last_price"><h4>${total-promo} &euro;</h4></li>
                   <div class="clearfix"> </div>
                 </ul>


                 <div class="clearfix"></div>
            </div>

            <div class="clearfix"> </div>
        </div>
</div>
