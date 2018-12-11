<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="../include/importTags.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Whisky lives</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:700italic,400,300,700' rel='stylesheet' type='text/css'>
    <!--[if lte IE 8]><script src="<spring:url value='js/html5shiv.js'/>"></script><![endif]-->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="<spring:url value='js/skel.min.js'/>"></script>
    <script src="<spring:url value='js/skel-panels.min.js'/>"></script>
    <script src="<spring:url value='js/init.js'/>"></script>
    <noscript>
        <link rel="stylesheet" href="<spring:url value='css/skel-noscript.css'/>" type="text/css" />
        <link rel="stylesheet" href="<spring:url value='css/style-desktop.css'/>" type="text/css" />
        <link rel="stylesheet" href="<spring:url value='css/style.css'/>" type="text/css" />
        <link rel="stylesheet" href="<spring:url value='css/style-mobile.css'/>" type="text/css" />
        <link rel="stylesheet" href="<spring:url value='css/style-1000px.css'/>" type="text/css" />
    </noscript>
    <!--[if lte IE 8]><link rel="stylesheet" href="<spring:url value='css/ie/v8.css'/>" /><![endif]-->
    <!--[if lte IE 9]><link rel="stylesheet" href="<spring:url value='css/ie/v9.css'/>" /><![endif]-->
</head>
<body>
    <div>
        <div>
            <tiles:insertAttribute name="main-content" />
        </div>
    </div>
</body>
</html>