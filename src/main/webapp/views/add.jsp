<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 14.10.2024
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/w3.css">
    <title>Добавление нового пользователя</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>
        Person app
    </h1>
</div>

<div class="w3-container w3-padding">
    <%
        if (request.getAttribute("userName") != null) {
            out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round w3-border\">×</span>\n" +
                    "   <h5>Пользователь '" + request.getAttribute("userName") + "' был добавлен!</h5>\n" +
                    "</div>");
        }
    %>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>
                Добавление пользователя
            </h2>
        </div>
    <form method="post" class="w3-light-grey w3-padding">
        <label> Имя:
            <input type="text" name="name" class="w3-input w3-border w3-round" style="width: 30%">
            <br>
        </label>
        <label> Пол:
            <input type="text" name="gender" class="w3-input w3-border w3-round" style="width: 30%">
            <br>
        </label>
        <label> Дата рождения:
            <input type="text" name="date" class="w3-input w3-border w3-round" style="width: 30%">
            <br>
        </label>
        <button type="submit"> Добавить пользователя </button>
    </form>
    </div>
</div>
    <div class="w3-blue-grey w3-opacity w3-padding">
        <a class="w3-button w3-light-grey w3-round" href="/"> Вернуться на главную </a>
    </div>
</div>
</body>
</html>
