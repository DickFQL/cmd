<%@ page import="java.util.ArrayList" %><%--这是配置脚本--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--取值表达式脚本--%>

    <%=pageContext.getAttribute("name")%>
    <%=request.getAttribute("request")%>
    <%=session.getAttribute("session")%>
    <%=application.getAttribute("application")%>
</body>
</html>
