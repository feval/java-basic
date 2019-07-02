<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/2
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车页面</title>
</head>
<body>
<table border="1px" align="center" width="30%">
    <tr>
        <td>商品名称</td>
        <td>商品数量</td>
    </tr>
    <%
        Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("cart");
        if (map == null) {
            out.print("<tr><td colspan='2'>购物车空空如也,可以再逛逛~~~~</td></tr>");
        } else {
            for (String name : map.keySet()) {
                out.print("<tr>");
                out.print("<td>");
                out.print(name);
                out.print("</td>");
                out.print("<td>");
                out.print(map.get(name));
                out.print("</td>");
            }
        }
    %>
    <hr>
    <center>
        <a href="/product_list.jsp">继续购物&nbsp;&nbsp;&nbsp;</a>
        <a href="/clearCart">清空购物车&nbsp;&nbsp;&nbsp;</a>
    </center>
</table>
</body>
</html>
