<%@ page import="entity.Person" %>
<%@ page import="java.util.*" %><%--
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
    <title>Обновить пользователя</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>
        Person app!
    </h1>
</div>
<div class="w3-container w3-center w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>
                Пользователи
            </h2>
        </div>
        <p>
            <%
                Map<Integer, Person> personList = (HashMap<Integer, Person>) request.getAttribute("personList");
                Set<Integer> keys = personList.keySet();
                if (!personList.isEmpty() && personList != null) {
                    out.println("<ul class=\"w3-ul\">");
                    for (int key : keys) {
                        out.println("<li class=\"w3-hover-sand\">" + key + " " + personList.get(key) + "</li>");
                    }
                    out.println("</ul>");
                } else {
                    out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
                            "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                            "   <h5>There are no users yet!</h5>\n" +
                            "</div>");
                }
            %>
        </p>
    </div>
</div>
<div class="w3-blue-grey w3-opacity w3-padding">
    <a class="w3-button w3-light-grey w3-round" href="/"> Вернуться на главную </a>
</div>
</body>
</html>
