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
<c:if test="${not empty session}">
    ${session}
    <head>
        <title>学生列表</title>
    </head>
    <body>
    <h1 align="center"> 学生列表</h1>
    <table align="center" border="1px">
        <tr>
            <th colspan="13" align="center"><a href="http://127.0.0.1:8081/cmd/html/add.jsp">添加</a> </th>
        </tr>
    </table>
    <table align="center" border="1px">
        <tr>
            <th>姓</th>
            <th>名</th>
            <th>用户</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${test}" var="stu">
            <tr>
                <td>${stu.getLastname()}</td>
                <td>${stu.getFirstname()}</td>
                <td>${stu.getUser()}</td>
                <td>${stu.getPassword()}</td>
                <td>
                    <form action="http://127.0.0.1:8081/cmd/servletjsp?method=changeview" method="post">
                        <input type="hidden" name="id" value="${stu.getId()}">
                        <input type="submit" value="修改">
                    </form>
                    <form action="http://127.0.0.1:8081/cmd/servletjsp?method=delete" method="post">
                        <input type="hidden" name="id" value="${stu.getId()}">
                        <input type="submit" value="删除">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    </body>

</c:if>

<c:if test="${empty session}">
    <body>
    <a href="http://127.0.0.1:8081/cmd/html/login.jsp">请前去登录</a>
    </body>
</c:if>
</html>
