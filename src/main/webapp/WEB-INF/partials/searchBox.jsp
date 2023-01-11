<%--
  Created by IntelliJ IDEA.
  User: gabriellekhokhar
  Date: 1/10/23
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    #myInput {
      width: 80%; /* Full-width */
      font-size: 16px; /* Increase font-size */
      padding: 12px 20px 12px 40px; /* Add some padding */
      border: 1px solid #ddd; /* Add a grey border */
      margin: 12px; /* Add some space below the input */
    }
  </style>
</head>
<body>
<form class="form-inline my-2 my-lg-0 ms-auto" role="search" method="post" action="/search/wandsearch">
<input type="text" id="myInput" name="username" class="form-control" placeholder="Search wands">
</form>
</body>

</html>
