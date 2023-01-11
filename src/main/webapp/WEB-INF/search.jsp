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
    <h1>${user_name.}</h1>
</body>
</html>