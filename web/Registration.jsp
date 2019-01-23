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
				<div class="Reg">
	<form name="registration">
        <table>
            <tr>
                <td>
                    <p class="textTable">ЛОГИН:</p>
                </td>
                <td>
                    <input type="text" name="login"/>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="textTable">ПАРОЛЬ:</p>
                </td>
                <td>
                    <input type="text" name="password"/>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="textTable">ИМЯ:</p>
                </td>
                <td>
                    <input type="text" name="firstName"/>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="textTable">ФАМИЛИЯ:</p>
                </td>
                <td>
                    <input type="text" name="lastName"/>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="textTable">ОТЧЕСТВО:</p>
                </td>
                <td>
                    <input type="text" name="middleName"/>
                </td>
            </tr>
        </table>
		<div class="button">
			<input type="submit" value="Подтвердить" onclick="form.action='/ProjectV3_war_exploded/Registration';">
		</div>
	</form>
				</div>
			</nav>
		</header>    
</body>
</html>