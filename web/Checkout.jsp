<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
    <input type="submit" value="Завершить оформление заказа" onclick="form.action='/ProjectV3_war_exploded/AddOrderServlet';">
</form>
</body>
</html>