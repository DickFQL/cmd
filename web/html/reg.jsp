<%--
  Created by IntelliJ IDEA.
  User: Mitsuha
  Date: 2023/10/16
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center"> 学生注册</h1>

<form action="http://127.0.0.1:8081/cmd/servletjsp?method=reg" method="post">
    <table align="center" border="1px">
        <tr>
            <td>id：</td> <td> <input type="text" name="id" ></td>
        </tr>
        <tr>
            <td>用户名：</td> <td> <input type="text" name="username" ></td>
        </tr>
        <tr>
            <td>密码：</td><td><input type="password" name="password" > </td>
        </tr>
        <tr> <td colspan="13" align="center"> <input type="submit" value="注册"></td></tr>

    </table>

</form>

</body>
</html>
