<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="visuals/main.css">
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">

        <h1 class="border bg-secondary text-center opacity-75 text-body rounded-pill">Welcome Witches and Wizards ! <br>Welcome to Wanderful!<br> Where we have rare wands for everyday wizards.</h1>

        <div style="color:red">${error}</div>
        
        <form action="login" method="POST">
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Username</span>
                <input type="text" class="form-control"  aria-label="Username" aria-describedby="basic-addon1" id="username" name="username" value=${username}>>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Password</span>
                <input type="password" class="form-control"  aria-label="Username" aria-describedby="basic-addon1" name="password" >
            </div>
<%--            <div class="form-group">--%>
<%--                <label for="username">Username</label>--%>
<%--                <input id="username" name="username" class="form-control" type="text" value=${username}>--%>
<%--            </div>--%>
<%--            <div class="form-group">--%>
<%--                <label for="password">Password</label>--%>
<%--                <input id="password" name="password" class="form-control" type="password">--%>
<%--            </div>--%>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
        <div>
            <form action="register" method="post">
                <input type="hidden" id="register" name="register" value="register">
                <input type="submit" class="btn btn-secondary btn-block" value="Register">
            </form>
        </div>
    </div>
</body>
</html>
