<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 25.10.2024
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/w3.css">
    <title>Удаление пользователя</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>
        Person app
    </h1>
</div>
<div class="w3-container w3-padding">

    <%
        if (request.getParameter("id") != null) {
            System.out.println("<div class=\"w3-panel w3-green w3-display-container w3-round \">" +
                    "<span onclick=\"this.parentElement.style.display='none'\" class=\"w3-button w3-display-right w33-round w3-margin-right\">x</span>"
                    + "<h5> Пользователь с id = " + request.getParameter("id") + " удален</h5></div>");
        }
    %>

<div class="w3-card-4">
    <div class="w3-container w3-center w3-red">
        <h2>
            Удаление юзера по id
        </h2>
    </div>
    <div class="w3-padding">
        <form method="post" class="w3-light-grey w3-padding">
            <label> ID
                <input type="text" name="id" class="w3-input w3-border w3-round" style="width: 30%">
                <br>
            </label>
            <button class="w3-button w3-round w3-border" type="submit">Удалить пользователя</button>
        </form>
    </div>
</div>
</div>
</div>
<div class="w3-blue-grey w3-opacity w3-padding">
    <a class="w3-button w3-light-grey w3-round" href="/"> Вернуться на главную </a>
</div>
</div>

</div>


</body>
</html>
