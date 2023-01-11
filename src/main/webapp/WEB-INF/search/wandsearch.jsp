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
</head>

<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div>${noWand}</div>
    <div class="container">
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
            <p>Seller: ${user.userName}</p>
            <p>Contact Seller at: ${user.email}</p>
        </div>

    </div>
</body>
</html>