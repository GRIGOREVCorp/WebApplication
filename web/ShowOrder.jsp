<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
            <td><a href="/ProjectV3_war_exploded/DeleteOrderServlet?id=${order.ordercustomerEO.id}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<a href="Checkout.jsp">Оформить заказ</a>
</body>
</html>
