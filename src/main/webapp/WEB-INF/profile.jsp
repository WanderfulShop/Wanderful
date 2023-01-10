<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<%--    <jsp:include page=> Lucas navbar goes here--%>

    <div class="container">
        <h1>Welcome, ${sessionScope.user.userName}!</h1>
    </div>
<h1>Ad 1</h1>
<h1>Ad 2</h1>

</body>
</html>
