<%--
  Created by IntelliJ IDEA.
  User: milesraker
  Date: 1/12/23
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.codeup.adlister.models.Ad"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h2>Featured AD of the day: </h2>
<c:forEach var="ad" items="${ads}">
  <div>
    <h2>${ad.adTitle}</h2>
    <h2>${ad.adDescription}</h2>
  </div>
</c:forEach>
</body>
</html>
