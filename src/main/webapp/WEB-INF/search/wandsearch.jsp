<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gabriellekhokhar
  Date: 1/10/23
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your search result" />
    </jsp:include>
    <style>

        .container {
            text-align: center;
            font-family: "Papyrus", "Copperplate", monospace;
            font-weight: bolder;
        }
    </style>
</head>

<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <c:choose>
        <c:when test="${wand == null}">
    <div class="block ms-auto me-auto mt-4">
        <h1 class="text-center">${noWand}</h1>
    </div>
        </c:when>
        <c:otherwise>
    <div class="container mt-4">
        <h1>You are viewing, ${wand.wandName}!</h1>
    </div>

    <div class="container">

        <div class="col-md-6">
            <h1>${ad.adTitle}</h1>
            <p>${ad.adDescription}</p>
            <p>${ad.creationDate}</p>
            <p>Wand Name: ${wand.wandName}</p>
            <p>Core Material: ${wand.coreMaterial}</p>
            <p>Wood Type: ${wand.woodType}</p>
            <p>Category: ${wand.useCategory}</p>
            <p>Age: ${wand.age}</p>
            <p>Seller: ${seller.userName}</p>
            <p>Contact Seller at: ${seller.email}</p>
        </div>

    </div>
        </c:otherwise>
    </c:choose>
<%--    <h2 class="text-center mt-4">Here are the featured Ads for the day: </h2>--%>
<%--    <c:forEach var="ad" items="${ad}">--%>
<%--        <div class="ads">--%>
<%--            <h2>${ad.adTitle}</h2>--%>
<%--            <h2>Description: ${ad.adDescription}</h2>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
</body>
</html>