<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="css/style.css">
		<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    </head>
    <body>
		<header>
			<div class="logo">
				<a href="index.html"><img class="graficlogo" src="img/logo.png" alt="Logo"></a>
			</div>
			<nav>
				<div class="Author">
					<form name="Authorization">
						<table>
							<tr>
								<td>
									Логин:
								</td>
								<td>
									<input type="text" name="login" value="admin"/>
								</td>
							</tr>
							<tr>
								<td>
									Пароль:
								</td>
								<td>
									<input type="password" name="password" value="admin"/>
								</td>
							</tr>
						</table>
						<div class="button">
							<input type="submit" value="Войти" onclick="form.action='/ProjectV3_war_exploded/Authorization';">
							<input type="submit" value="Зарегистрироваться" onclick="form.action='Registration.jsp';">
						</div>
					</form>
				</div>
			</nav>
		</header>
    </body>
    <% String res = (String) request.getParameter("notFound"); %>
    <% if(res.equals("true")) { %>
	<div class="error2">
    <span class="error">Неверный логин или пароль!</span>
		</div>
    <% } %>
</html>
