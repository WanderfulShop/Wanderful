<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}" varStatus="loop">
        <div class="col-md-6">
            <h2>${ad.adTitle}</h2>
            <p>${ad.adDescription}</p>
            <p>${ad.creationDate}</p>
            <form action="ads" method="post">
                <input type="hidden" name="adId" value="${loop.index}">
                <input type="submit"/>
            </form>
<%--
             post request here. Send ad index to AdsIndexServlet via POST
--%>
        </div>
    </c:forEach>
</div>

</body>
</html>
