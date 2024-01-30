<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Заказ" %></h1>
<br/>
<div class="container">
  <div class="menu">
<a href="${pageContext.request.contextPath}/order">Заказать пиццу</a>
</div>
<div class="menu">
<a href="${pageContext.request.contextPath}/order">Корзина</a>
</div>
</div>
</body>
</html>