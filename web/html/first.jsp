<%@ page import="java.util.ArrayList" %><%--这是配置脚本--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    pageContext.setAttribute("name","john");
    request.setAttribute("request","dick");
    session.setAttribute("session","session");
    application.setAttribute("application","application");
%>
<%--这是声明表达式脚本--%>
<%! String name = "jack";%>

<%--这是代码脚本--%>
<%for (int i=0;i<10;i++){
    System.out.println(i);
}
    ArrayList arrayList = new ArrayList<>();
    arrayList.add("hello");
    arrayList.add("world");
    arrayList.add("你好呀");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--取值表达式脚本--%>
<%--
jsp的四大域对象
pageContext：只能在当前jsp页面才能取到
request：一次请求范围内
session: 浏览器开启到关闭
application：服务器开启到关闭
--%>
    <%=name%><br>
    <%=arrayList.get(2)%>
    <%=pageContext.getAttribute("name")%>
    <%=request.getAttribute("request")%>
    <%=session.getAttribute("session")%>
    <%=application.getAttribute("application")%>
</body>
</html>
