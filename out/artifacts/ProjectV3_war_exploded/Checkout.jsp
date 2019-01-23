<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <title>Title</title>
        <link rel="stylesheet" href="css/style.css">
		<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    </head>
<body>
<% String cusId = (String) request.getParameter("cusId"); %>
<header>
    <div class="login">
        <a class="registration" href="Authorization.jsp?notFound=false">выйти</a>
    </div>
			<div class="logo">
				<a href="index.html"><img class="graficlogo" src="img/logo.png" alt="Logo"></a>
			</div>
			<nav>
				<div class="topnav" id="myTopnav">
					<a href="/ProjectV3_war_exploded/MyOrderServlet?notParameter=false&cusId=<%=cusId%>">Показать мои заказы</a>
					<a href="Checkout.jsp?cusId=<%=cusId%>">Оформить заказ</a>
					<a id="menu" href="#" class="icon">&#9776;</a>
				</div>
			</nav>
		</header>
		<nav class="Check">
<form name="Checkout">
    <table class="ChTable">
        <tr>
            <td>
                <p class="textTable">Место выдачи:</p>
            </td>
            <td>
                <input type="text" name="poi" value="ул."/>
            </td>
        </tr>
        <tr>
            <td>
                <p class="textTable">Доставка:</p>
            </td>
            <td>
                <input type="text" name="d" value="нет"/>
            </td>
        </tr>
        <tr>
            <td>
                <p class="textTable">Адрес доставки:</p>
            </td>
            <td>
                <input type="text" name="da" value="нет"/>
            </td>
        </tr>
    </table>
    <input type="hidden" name="cusId" value="<%=cusId%>">
	<div class="button">
		<input type="submit" value="Завершить оформление заказа" onclick="form.action='/ProjectV3_war_exploded/AddOrderServlet';">
	</div>
	</form>
</nav>
</body>
</html>