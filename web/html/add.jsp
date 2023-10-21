<%--
  Created by IntelliJ IDEA.
  User: Mitsuha
  Date: 2023/10/6
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>添加学生</title>
</head>
<body>
<h1 align="center"> 添加学生</h1>
<form action="http://127.0.0.1:8081/cmd/servletjsp?method=add" method="post">
    <table align="center" border="1px">
        <tr>
            <td>id</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>姓</td>
            <td><input type="text" name="lastname"></td>
        </tr>
        <tr>
            <td>名</td>
            <td><input type="text" name="firstname"></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="user"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
           <td colspan="13" align="center"><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>


</body>
</html>
