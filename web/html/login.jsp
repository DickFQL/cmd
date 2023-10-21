<%--
  Created by IntelliJ IDEA.
  User: Mitsuha
  Date: 2023/10/15
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
<%--    Cookie[] cookies = request.getCookies();--%>
<%--    Cookie cookielast = new Cookie("username", "password");--%>
<%--    if (cookies.length!=0)--%>
<%--        for (Cookie cookie: cookies) if (cookie.getName().equals("cookie1")) cookielast=cookie;--%>


<%--%>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1 align="center"> 学生登录</h1>

<form action="http://127.0.0.1:8081/cmd/servletjsp?method=login" method="post">
    <table align="center" border="1px">

        <tr>
            <td>用户名：</td> <td> <input type="text" name="username" ></td>
        </tr>
        <tr>
            <td>密码：</td><td><input type="text" name="password" > </td>
        </tr>
        <tr> <td colspan="13" align="center"> <input type="submit" value="登录"></td></tr>

    </table>

</form>
<table><tr> <td colspan="13" align="center"> <a href="http://127.0.0.1:8081/cmd/html/reg.jsp"> 还没账号，前去注册</a></td></tr></table>
</body>
</html>
