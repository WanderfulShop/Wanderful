<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milesraker
  Date: 1/11/23
  Time: 1:21 PM
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
<c:choose>
  <c:when test="${user == null}">
<div>
  <h1 class="text-center mt-4">${noUser}</h1>
</div>
  </c:when>
  <c:otherwise>
<div class="container">
  <h1 class="text-center mt-4">You are viewing, ${user.userName}'s page!</h1>
</div>
<h1 class="text-center">${user.userName}</h1>
<h3 class="text-center"> placeholder IMG</h3>
  </c:otherwise>
</c:choose>
<h2 class="text-center mt-4">Here are the featured Ads for the day: </h2>
<c:forEach var="ad" items="${ad}">
  <div class="ads justify-content-center">
    <h2>${ad.adTitle}</h2>
    <h2>Description: ${ad.adDescription}</h2>
  </div>
</c:forEach>

</body>
</html>