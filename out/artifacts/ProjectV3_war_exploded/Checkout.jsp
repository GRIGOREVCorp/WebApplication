<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String cusId = (String) request.getParameter("cusId"); %>
<form name="Checkout">
    <table>
        <tr>
            <td>
                Место выдачи:
            </td>
            <td>
                <input type="text" name="poi" value="ул."/>
            </td>
        </tr>
        <tr>
            <td>
                Доставка:
            </td>
            <td>
                <input type="text" name="d" value="нет"/>
            </td>
        </tr>
        <tr>
            <td>
                Адрес доставки:
            </td>
            <td>
                <input type="text" name="da" value="нет"/>
            </td>
        </tr>
    </table>
    <input type="hidden" name="cusId" value="<%=cusId%>">
    <input type="submit" value="Завершить оформление заказа" onclick="form.action='/ProjectV3_war_exploded/AddOrderServlet';">
    <input type="submit" value="Перейти в личный кабинет" onclick="form.action='Welcom.jsp';">
</form>
</body>
</html>
