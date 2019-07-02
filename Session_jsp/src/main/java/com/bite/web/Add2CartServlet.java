package com.bite.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:将商品添加到购物车中
 * Author:  llf
 * Created in 2019/7/2 19:18
 */
public class Add2CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("name");

        name = new String(name.getBytes("ISO-8859-1"),"UTF-8");

        Map<String,Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");

        Integer count=null;
        if(map==null) {
            map=new HashMap<>();
            count=1;
            request.getSession().setAttribute("cart",map);
        }else {
            count = map.get(name);
            if (count==null) {
                count=1;
            }else{
                count++;
            }
        }
        map.put(name,count);
        writer.print("当前商品<b>"+name+"</b>已成功添加到购物车");
        writer.print("您可以选择<a href='product_list,jsp'>继续购物</a>&nbsp;&nbsp");
        writer.print("<a href='/cart,jsp'>查看购物车</a>");
    }
}
