<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Mitsuha
  Date: 2023/10/6
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
<%--    存储全局域对象--%>
    request.setAttribute("name1","dick");
    request.setAttribute("name2","jack");
    HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    objectObjectHashMap.put("hash1","value1");
    objectObjectHashMap.put("hash2","value2");
    request.setAttribute("hashmap",objectObjectHashMap);
%>
<html>
<head>
    <title>el</title>
</head>
<body>
    name:<%=request.getAttribute("name1")%><br>
    name:${name1}<input type="text"><br>
    hashmap:${hashmap}<br>
    logic:${100==100}<br>
    logic:${100+200}<br>
    三目：${500>400?"yes":"no"}<br>
    判断空：${empty hashmap} ${}

</body>
</html>
