<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <style>
        .error {
            size: 10px;
            color: red;
        }
    </style>
</head>
<body>
<% String cusId = (String) request.getParameter("cusId"); %>
<table border="1" width="100%">
    <tr>
        <th>№</th>
        <th>Место выдач</th>
        <th>Доставка</th>
        <th>Адрес доставки</th>
        <th>Дата</th>
        <th>Оплата</th>
        <th>Статус</th>
        <th>Выдача</th>
        <th>Действие</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.ordercustomerEO.id}</td>
            <td>${order.placeOfIssue}</td>
            <td>${order.delivery}</td>
            <td>${order.deliveryAddress}</td>

            <td>${order.ordercustomerEO.date}</td>

            <td>${order.orderstatusEO.created}</td>
            <td>${order.orderstatusEO.processing}</td>
            <td>${order.orderstatusEO.finished}</td>
            <td><a href="/ProjectV3_war_exploded/DeleteOrderServlet?id=${order.ordercustomerEO.id}&cusId=<%=cusId%>">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<% String res = (String) request.getParameter("notParameter"); %>
<% if(res.equals("true")) { %>
<span class="error">Заказ не был добавлен! Возможно были введены пустые параметры.</span>
<% } %>
<a href="Checkout.jsp?cusId=<%=cusId%>">Оформить заказ</a>
<a href="Welcom.jsp?cusId=<%=cusId%>">Перейти в личный кабинет</a>
</body>
</html>
