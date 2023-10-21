<%@ page import="java.util.ArrayList" %>

<%@page import="jstl.student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    ArrayList<student> student = new ArrayList<>();
    student.add(new student("dick","男",20));
    student.add(new student("john","男",21));
    student.add(new student("sophis","女",20));

    request.setAttribute("student",student);
    session.setAttribute("user",new student());
%>
<html>
<head>
    <title>el表达式</title>
</head>
<body>

<table border="1px">
    <tr>
        <th>用户姓名</th>
        <th>用户性别</th>
        <th>用户年龄</th>
    </tr>

<%--
    items: 表示域中集合的对象
    var: 遍历到的每个对象
--%>
    <c:forEach items="${student}" var="stu">
        <tr>
            <td>${stu.name}</td>
            <td>${stu.sex}</td>
            <td>${stu.age}</td>
        </tr>
    </c:forEach>
</table>

<%--判断表达式--%>
<c:if test="${100==100}">
    执行内容
</c:if>
<c:if test="${100!=100}">
    不执行内容
</c:if>

<c:if test="${empty user}" >
    <a>user为空</a>
</c:if>

</body>
</html>
