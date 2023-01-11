<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="register" method="post">
            <p style="color: red">${error}</p>
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" value=${username}>
            </div>
            <div class="form-group">
                <label for="firstName">First name</label>
                <input id="firstName" name="firstName" class="form-control" type="text" value=${firstName}>
            </div>
            <div class="form-group">
                <label for="lastName">Last name</label>
                <input id="lastName" name="lastName" class="form-control" type="text" value=${lastName}>
            </div>
            <div class="form-group">
                <label for="school">school</label>
                <input id="school" name="school" class="form-control" type="text" value=${school}>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" value=${email}>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password</label>
                <input id="confirmPassword" name="confirmPassword" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</body>
</html>
