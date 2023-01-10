<%--
  Created by IntelliJ IDEA.
  User: gabriellekhokhar
  Date: 1/10/23
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    String driver = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String database = "wanderful_db";
    String userid = "root";
    String password = "codeup";
    String username=request.getParameter("user_name");
    try {
        Class.forName(driver);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>

<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <h1><%=resultSet.getString("username")%></h1>
</body>
</html>