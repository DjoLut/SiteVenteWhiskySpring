<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                        <a href="<spring:url value="whiskies"/>"><spring:message code="index.Banner1.a"/></a>
                    </div>

                </li>
                <li>

                    <div class="banner-text">
                        <h3>There are many variations </h3>
                        <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor .</p>
                        <a href="single.html">Learn More</a>

                    </div>

                </li>
                <li>
                    <div class="banner-text">
                        <h3>Sed ut perspiciatis unde omnis</h3>
                        <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor .</p>
                        <a href="single.html">Learn More</a>

                    </div>

                </li>
            </ul>
        </div>
    </div>
</div>
        <div class="clearfix"> </div>
<div class="footer">
    <div class="container">
        <div class="footer-top-at">
        
            <div class="col-md-4 amet-sed">
                <h4 style="opacity:1;"><spring:message code="index.info.crea.h"/></h4>
                <p class="nav-bottom" style="opacity:1;"><spring:message code="index.info.crea.p"/></p>
            </div>
            <div class="col-md-4 amet-sed">
                <img src="<spring:url value='images/index.Pres.001.jpg'/>" style="max-width: 540px; width: 100%;"/>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
