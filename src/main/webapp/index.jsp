<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 14.10.2024
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/w3.css">
    <title>My title</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Person app!</h1>
</div>
<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn" onclick="location.href='/list'"> List users </button>
        <button class="w3-btn" onclick="location.href='/add'"> Add user</button>
        <button class="w3-btn" onclick="location.href='/update'"> Update user</button>
        <button class="w3-btn" onclick="location.href='/delete'"> Delete user</button>
    </div>
</div>
</body>
</html>
