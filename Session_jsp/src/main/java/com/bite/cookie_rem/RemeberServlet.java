package com.bite.cookie_rem;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Description:记录用户访问的具体时间
 * Author:  llf
 * Created in 2019/7/1 16:42
 */
public class RemeberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        Cookie cookie = getCookieByName("lastTime", request.getCookies());

        if (cookie==null) {
            writer.println("这是您的第一次访问");
        }else{
            //不为空，获取cookie内容，然后展示访问时间
            String value = cookie.getValue();
            //将内容转换成long类型
            long time = Long.parseLong(value) ;
            //创建日期对象
            Date date = new Date(time) ;
            //展示访问时间
            writer.print("您上一次访问的时间是："+date.toLocaleString());
        }
        cookie=new Cookie("lastTime",new Date().getTime()+"");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        writer.print("系统时间已写回");
    }

    private Cookie getCookieByName(String lastTime, Cookie[] cookies) {
        if (cookies!=null) {
            for (Cookie cookie:cookies) {
                if (lastTime.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
