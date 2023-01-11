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
<div>${noUser}</div>
<div class="container">
  <h1>You are viewing, ${user.userName}'s page!</h1>
</div>
<h1>${user.userName}</h1>
</body>
</html>