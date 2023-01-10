<%--
  Created by IntelliJ IDEA.
  User: milesraker
  Date: 1/9/23
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Detailed Ad View" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">

    <div class="col-md-6">
        <h1>${ad.title}</h1>
        <p>${ad.description}</p>
    </div>

</div>
</body>
</html>
