<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        <li data-thumb="">
                            <img src="" >
                        </li>
                        <li data-thumb="">
                            <img src="" >
                        </li>
                        <li data-thumb="">
                            <img src="" >
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

                    <form action="/whisky/single/${whisky.id}/add" method="POST">
                        <input type="number" min="1" max="999" value="1" name="quantity">
                        <input type="hidden" value="${whisky.id}" name="whisky">
                        <div class="clearfix"> </div>
                        <input type="submit" value="add" id="login"/>
                    </form>


                </div>
            </div>
            <div class="clearfix"> </div>
			<!---->
            <div class="cd-tabs">
                <nav>
                    <ul class="cd-tabs-navigation">
                        <li><a data-content="fashion"  href="#0">Description </a></li>
                        <li><a data-content="cinema" href="#0" >Additionnal information</a></li>
                    </ul>
			    </nav>
                <p>${translation.descriptions}</p>
                <ul class="cd-tabs-content">
                    <li data-content="fashion" >
                        <div class="facts">
                            <p> There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined </p>
                            <ul>
                                <li>Research</li>
                                <li>Design and Development</li>
                                <li>Porting and Optimization</li>
                                <li>System integration</li>
                                <li>Verification, Validation and Testing</li>
                                <li>Maintenance and Support</li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"> </div>

<!--//content-->
			