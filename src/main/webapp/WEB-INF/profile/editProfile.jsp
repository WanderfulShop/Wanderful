<%--
  Created by IntelliJ IDEA.
  User: milesraker
  Date: 1/12/23
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
    <form method="post" action="/profile/editProfile">
        <label for="firstName">First Name: </label>
        <input type="text" name="firstName" id="firstName" value=${user.firstName} >
        <label for="lastName">Last Name: </label>
        <input type="text" name="lastName" id="lastName" value=${user.lastName} >
        <label for="school">School: </label>
        <input type="text" name="school" id="school" value=${user.school} >
        <label for="email">Email: </label>
        <input type="text" name="email" id="email" value=${user.email} >
        <input type="submit"/>
    </form>
</body>
</html>
