<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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

                        <a href="<spring:url value='/single/${whisky.id}'/>" class="item_add"><p class="number item_price"><i> </i>${whisky.price} &euro;</p></a>

                    </div>
                </c:forEach>
            </div>

        <div class="clearfix"> </div>
        <nav class="in">
            <ul class="pagination">
                <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">2 <span class="sr-only"></span></a></li>
                <li><a href="#">3 <span class="sr-only"></span></a></li>
                <li><a href="#">4 <span class="sr-only"></span></a></li>
                <li><a href="#">5 <span class="sr-only"></span></a></li>
                <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span> </a> </li>
            </ul>
        </nav>
    </div>

</div>

<!---->
