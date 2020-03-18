<%@ tag description="Simple Wrapper Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Мимимиметр</title>

    <spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/resources/css/creative.css" var="baseCss"/>
    <spring:url value="/resources/vendor/fontawesome-free/css/all.min.css" var="fontAwesome"/>
    <spring:url value="/resources/vendor/jquery/jquery.min.js" var="jqueryJs"/>
    <spring:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" var="bootstrapJs"/>

    <!-- Bootstrap core CSS -->
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <!-- Custom fonts -->
    <link href="${fontAwesome}" rel="stylesheet" type="text/css">

    <!-- Custom styles  -->
    <link href="${baseCss}" rel="stylesheet"/>

</head>
<body>
<div class="container">
    <jsp:doBody/>
</div>

</body>
</html>