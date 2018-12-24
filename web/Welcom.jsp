<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
</head>
<body>
<h1>Личный кабинет</h1>
<% String cusId = (String) request.getParameter("cusId"); %>
<p><a href="/ProjectV3_war_exploded/MyOrderServlet?notParameter=false&cusId=<%=cusId%>">Показать мои заказы</a></p>
<p><a href="Checkout.jsp?cusId=<%=cusId%>">Оформить заказ</a></p>
</body>
</html>
