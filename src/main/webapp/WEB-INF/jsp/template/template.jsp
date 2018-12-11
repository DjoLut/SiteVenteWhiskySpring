<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="../include/importTags.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Whisky lives</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <link rel="stylesheet" href="<spring:url value='css/style.css'/>" type="text/css" />

</head>
<body>
    <div>
        <div>
            <tiles:insertAttribute name="main-content" />
        </div>
    </div>
</body>
</html>