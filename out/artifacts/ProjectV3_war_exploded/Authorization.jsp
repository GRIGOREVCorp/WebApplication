<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <input type="submit" value="Войти" onclick="form.action='/ProjectV3_war_exploded/Authorization';">
            <input type="submit" value="Зарегистрироваться" onclick="form.action='Registration.jsp';">
        </form>
    </body>
    <% String res = (String) request.getParameter("notFound"); %>
    <% if(res.equals("true")) { %>
    <span class="error">Wrong login or password!</span>
    <% } %>
</html>
