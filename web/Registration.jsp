<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="registration">
        <table>
            <tr>
                <td>
                    USERNAME:
                </td>
                <td>
                    <input type="text" name="login"/>
                </td>
            </tr>
            <tr>
                <td>
                    PASSWORD:
                </td>
                <td>
                    <input type="text" name="password"/>
                </td>
            </tr>
            <tr>
                <td>
                    FIRST NAME:
                </td>
                <td>
                    <input type="text" name="firstName"/>
                </td>
            </tr>
            <tr>
                <td>
                    LAST NAME:
                </td>
                <td>
                    <input type="text" name="lastName"/>
                </td>
            </tr>
            <tr>
                <td>
                    MIDDLE NAME:
                </td>
                <td>
                    <input type="text" name="middleName"/>
                </td>
            </tr>
        </table>
        <input type="submit" value="Подтвердить" onclick="form.action='/ProjectV3_war_exploded/Registration';">
    </form>
</body>
</html>
