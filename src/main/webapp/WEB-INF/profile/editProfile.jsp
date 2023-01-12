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
    <form method="post" action="profile/edit">
        <input type="text" name="userName" value=${user.userName}/>
        <input type="text" name="firstName" value=${user.firstName}/>
        <input type="text" name="lastName" value=${user.lastName}/>
        <input type="text" name="school" value=${user.school}/>
        <input type="text" name="email" value=${user.email}/>
        <input type="submit"/>
    </form>
</body>
</html>
