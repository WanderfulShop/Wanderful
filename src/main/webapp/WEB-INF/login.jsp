<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="visuals/main.css">
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>

    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">

        <h1>Welcome Witches and Wizards !</h1>
        <h1>Welcome to Wanderful! Where we have rare wands for everyday wizards.</h1>
        <div style="color:red">${error}</div>
        
        <form action="login" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" value=${username}>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
        <div>
            <form action="register" method="post">
                <input type="hidden" id="register" name="register" value="/register">
                <input type="submit" class="btn btn-secondary btn-block" value="Register">
            </form>
        </div>
    </div>
</body>
</html>
