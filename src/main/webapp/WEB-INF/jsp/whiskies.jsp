<%@ include file="include/importTags.jsp" %>

<!--content-->
<!---->
<div class="product">
    <div class="container">
        <div style="padding-bottom: 30px; float:right;">
            <div>
                <form:form id="buttonOrdreAlpha" action="/whisky/whiskies/orderName" method="POST" modelAttribute="order">
                    <form:button id="alpha" class="triWhiskies" value="name" path="alpha"><spring:message code="triNom"/></form:button>
                </form:form>
            </div>
        </div>
        <div style="padding-bottom: 30px">
            <form:form id="buttonOrdreAlpha" action="/whisky/whiskies/orderPrice" method="POST" modelAttribute="order">
                <form:button id="price" class="triWhiskies" value="price" path="price"><spring:message code="triPrix"/></form:button>
            </form:form>
        </div>
        <div class="clearfix"> </div>
        
            <div class=" bottom-product">
                <c:set var="compteur" value="0"/>
                <c:forEach items="${whisky}" var="whisky">
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
    
                        <!-- FORM A FAIRE -->
                        <c:if test="${panier.whiskyAjoutable(whisky) > 0}" >
                            <form action="/whisky/whiskies/add" method="POST">
                                <input type="hidden" value="1" name="quantity" />
                                <input type="hidden" value="${whisky.id}" name="whisky" />
                                <div class="clearfix"> </div>
                                <c:if test="${whisky.promotion == null}">
                                    <input style="width:100%" value="<fmt:formatNumber value="${whisky.price}" type="currency" currencySymbol="&euro;"/>" type="submit" class="login" onclick="return alert('<spring:message code='whiskyAdd'/>')">
                                </c:if>
                                <c:if test="${whisky.promotion != null}">
                                    <input style="width:100%; height:200%;" value="<fmt:formatNumber value="${whisky.price}" type="currency" currencySymbol="&euro;"/> - <fmt:formatNumber value="${whisky.promotion/100*whisky.price}" type="currency" currencySymbol="&euro;"/> = <fmt:formatNumber value="${whisky.price-(whisky.promotion/100*whisky.price)}" type="currency" currencySymbol="&euro;"/>" type="submit" class="login" onclick="return alert('<spring:message code='whiskyAdd'/>')">
                                </c:if>
                            </form>
                        </c:if>

                        <c:if test="${panier.whiskyAjoutable(whisky) <= 0}">
                            <a href="<spring:url value='/single/${whisky.id}'/>" class="item_add"><p class="number item_price"><spring:message code="outOfStock"/></p></a>
                        </c:if>
                    </div>
                    <c:set var="compteur" value="${compteur = compteur + 1}"/>
                    <c:if test="${compteur%3==0 && compteur!=0}">
                        <div class="clearfix"> </div>
                    </c:if>
                </c:forEach>
            </div>

        <div class="clearfix"> </div>

    </div>

</div>

<!---->
