<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: sindy
  Date: 27.01.2024
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказ</title>
    <link rel="stylesheet" href="../styles/myStyle.css">
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/order">
    <legend> Пиццу:</legend><br>
    <%
        ArrayList<String> pizzaNames = (ArrayList<String>) request.getAttribute("namesPizza");%>

    <select class="requestInput" name="name_pizza">
        <%for (String name: pizzaNames) {%>
        <option><%=name%></option>
        <%}%>
    </select>
    <legend> Выберите топпинг:</legend>
    <input type="checkbox" name="top" value="оливки" checked> <label>оливки</label><br>
    <input type="checkbox" name="top" value="сыр" checked> <label>сыр</label><br>
    <input type="checkbox" name="top" value="каперсы" checked> <label>каперсы</label><br>
    <input type="checkbox" name="top" value="грибы" checked> <label>грибы</label><br><br>

    <input type="text" name="name" placeholder="имя"><br>
    <input type="text" name="number_phone"  placeholder="номер телефона"><br>
    <input type="text" name="email"  placeholder="емаил"><br>
    <input type="text" name="address"  placeholder="адрес"><br>
    <input type="reset" value="очистить">
    <input type="submit" value="отправить">
</form>
</body>
</html>
