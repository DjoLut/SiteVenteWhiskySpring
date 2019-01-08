<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--content-->
<!---->
<div class="product">
    <div class="container">
            <div class=" bottom-product">
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
                                <input type="hidden" value="1" name="quantity"></input>
                                <input type="hidden" value="${whisky.id}" name="whisky"></input>
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
                </c:forEach>
            </div>

        <div class="clearfix"> </div>

    </div>

</div>

<!---->
