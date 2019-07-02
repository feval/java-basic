<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/2
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el-从域中获取数据</title>
</head>
<body>
<%
    pageContext.setAttribute("akey", "avalue");
    request.setAttribute("bkey","bvalue");
    session.setAttribute("ckey","cvalue");
    application.setAttribute("dkey","dvalue");
%>
<%=pageContext.getAttribute("akey")%>
<%=request.getAttribute("bkey")%>
<%=session.getAttribute("ckey")%>
<%=application.getAttribute("dkey")%>
<hr>
${akey}   -   ${bkey}   -  ${ckey}   -   ${dkey}

</body>
</html>
