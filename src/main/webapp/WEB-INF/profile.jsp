<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<%--    <jsp:include page=> Lucas navbar goes here--%>
<h1>Hello, ${user.userName}</h1>
<h2>Profile Information</h2>
<h3>Full Name: ${user.firstName}</h3>
<h3>placeholder IMG</h3>

<h2>Here are the featured Ads for the day: </h2>
<c:forEach var="ad" items="${ad}">
    <div class="ads">
        <h2>${ad.adTitle}</h2>
        <h2>Description: ${ad.adDescription}</h2>
    </div>
</c:forEach>
<%--<dl>--%>
<%--    <dt>Date listing was created</dt>--%>
<%--    <dd>${ad.creationDate}</dd>--%>
<%--    <dt>AD title</dt>--%>
<%--    <dd>${ad.adTitle}</dd>--%>
<%--    <dt>Description</dt>--%>
<%--    <dd>${ad.adDescription}</dd>--%>
<%--</dl>--%>





</body>
</html>
