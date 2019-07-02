<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: zhangyang
  Date: 2019/6/22
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%--page指令--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"
          %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--java片段--%>
<%
        //创建日期对象
        Date date = new Date() ;
        //创建SimpleDateFormat对象
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
    String dateStr = sdf.format(date) ;
    //jsp内置对象:9个内置对象: JspWriter out
    /*out.print(dateStr);*/

%>
    <%--jsp的输出表达式--%>
<%=dateStr%>

    <%--定义成员的属性--%>
<%! int i = 10 ;%>
</body>
</html>
