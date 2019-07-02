<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/2
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>el表达式</title>
</head>
<body>
<%--jsp脚本--%>
<%
    List<String> list=new ArrayList<>();
    list.add("aa");
    list.add("bb");
    list.add("cc");
    session.setAttribute("list",list);
%>
<%=((List)session.getAttribute("list")).get(1)%>
</body>
</html>
