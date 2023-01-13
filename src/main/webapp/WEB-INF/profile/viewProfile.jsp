<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("");
%>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <link rel="stylesheet" type="text/css" href="visuals/main.css">
    <link rel="stylesheet" type="text/css" href="visuals/profile.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"></jsp:include>
    <h1>Hello, ${user.userName}</h1>
    <h2>Profile Information</h2>
    <h3>Full Name: ${user.firstName} ${user.lastName}</h3>
    <p>School: ${user.school}</p>
    <p>Email: ${user.email}</p>
    <h3>placeholder IMG</h3>
    <form action="/profile/viewProfile" method="post">
        <input type="hidden" value="true" name="editProfile">
        <input type="submit" value="Edit Profile"/>
    </form>

<%--<jsp:include page="/WEB-INF/partials/AdsOfTheDay.jsp"></jsp:include>--%>
<h2>Featured AD of the day: </h2>
<c:forEach var="ad" items="${ads}">
    <div>
        <h2>${ad.adTitle}</h2>
        <h2>${ad.adDescription}</h2>
    </div>
</c:forEach>

</body>
</html>
