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
    <title>修改学生</title>
</head>
<body>
${changeview.get(0).getId()}
<h1 align="center"> 修改学生</h1>

<form action="http://127.0.0.1:8081/cmd/servletjsp?method=change" method="post">
    <table align="center" border="1px">
        <tr>
            <td>id</td>
            <td>姓</td>
            <td>名</td>
            <td>用户名</td>
            <td>密码</td>
        </tr>
        <c:forEach items="${changeview}" var="change">
            <tr>
                <td><input type="hidden" name="id" value="${change.getId()}"></td>
                <td><input type="text" name="lastname" value="${change.getLastname()}"></td>
                <td><input type="text" name="firstname" value="${change.getFirstname()}"></td>
                <td><input type="text" name="user" value="${change.getUser()}"></td>
                <td><input type="password" name="password" value="${change.getPassword()}"></td>
            </tr>
        </c:forEach>
        <tr><td colspan="13" align="center"><input type="submit" value="修改"></td></tr>
    </table>
</form>


</body>
</html>
