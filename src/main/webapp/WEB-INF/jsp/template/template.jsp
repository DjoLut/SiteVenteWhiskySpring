<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ include file="../include/importTags.jsp" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Whisky alive</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="New Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
        Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

    <link type="text/css" href="<spring:url value='/css/style.css'/>" rel="stylesheet" media="all" />
    <link type="text/css" href="<spring:url value='/css/memenu.css'/>" rel="stylesheet" media="all" />
    <link type="text/css" href="<spring:url value='/css/flexslider.css'/>" rel="stylesheet" media="all" />
    <link type="text/css" href="<spring:url value='/css/bootstrap.css'/>" rel="stylesheet" media="all" />

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<spring:url value='js/jquery.min.js'/>"></script>
    <!-- Custom Theme files -->

    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--fonts-->
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
    <!-- start menu -->
    <script type="text/javascript" src="<spring:url value='js/memenu.js'/>"></script>
    <script>$(document).ready(function(){$(".memenu").memenu();});</script>
    <script src="<spring:url value='js/simpleCart.min.js'/>"> </script>

</head>
<body>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ include file="../include/header.jsp" %>
    <tiles:insertAttribute name = "main-content" />
<%@ include file="../include/footer.jsp" %>
</body>
</html>