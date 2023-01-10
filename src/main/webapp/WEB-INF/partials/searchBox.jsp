<%--
  Created by IntelliJ IDEA.
  User: gabriellekhokhar
  Date: 1/10/23
  Time: 1:23 PM
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
  String wand=request.getParameter("wand_name");
  String age=request.getParameter("age");
  String wood=request.getParameter("wood_type");

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
<html>
<head>
  <style>
    #myInput {
      background-position: 10px 12px; /* Position the search icon */
      background-repeat: no-repeat; /* Do not repeat the icon image */
      width: 100%; /* Full-width */
      font-size: 16px; /* Increase font-size */
      padding: 12px 20px 12px 40px; /* Add some padding */
      border: 1px solid #ddd; /* Add a grey border */
      margin-bottom: 12px; /* Add some space below the input */
    }

    #myTable {
      border-collapse: collapse; /* Collapse borders */
      width: 100%; /* Full-width */
      border: 1px solid #ddd; /* Add a grey border */
      font-size: 18px; /* Increase font-size */
    }

    #myTable th, #myTable td {
      text-align: left; /* Left-align text */
      padding: 12px; /* Add padding */
    }

    #myTable tr {
      /* Add a bottom border to all table rows */
      border-bottom: 1px solid #ddd;
    }

    #myTable tr.header, #myTable tr:hover {
      /* Add a grey background color to the table header and on hover */
      background-color: #f1f1f1;
    }
  </style>
</head>
<body>
<input type="text" id="myInput" onkeyup="searchFunction()" placeholder="Search for names..">

<table id="myTable">
  <tr class="header">
    <th style="width:50%;">Wands</th>
    <th style="width:25%">Wood</th>
    <th style="width:25%;">Age</th>
  </tr>
  <tr>
    <td><%=resultSet.getString("wand_name")%></td>
    <td><%=resultSet.getString("age")%></td>
    <td><%=resultSet.getString("wood_type")%></td>
  </tr>
  <tr>
    <td><%=resultSet.getString("wand_name")%></td>
    <td><%=resultSet.getString("age")%></td>
    <td><%=resultSet.getString("wood_type")%></td>
  </tr>
  <tr>
    <td><%=resultSet.getString("wand_name")%></td>
    <td><%=resultSet.getString("age")%></td>
    <td><%=resultSet.getString("wood_type")%></td>
  </tr>
  <tr>
    <td><%=resultSet.getString("wand_name")%></td>
    <td><%=resultSet.getString("age")%></td>
    <td><%=resultSet.getString("wood_type")%></td>
  </tr>
</table>
</body>
<script>
  function myFunction() {
    // Declare variables
    let input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }
</script>
</html>
