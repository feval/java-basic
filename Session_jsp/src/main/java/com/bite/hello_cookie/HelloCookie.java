package com.bite.hello_cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * Author:  llf
 * Created in 2019/7/1 16:24
 */
public class HelloCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie c1 = new Cookie("akey", "avalue");
        Cookie c2 = new Cookie("bkey", "bvalue");
        Cookie c3 = new Cookie("ckey", "cvalue");
        c1.setMaxAge(3600);
        c2.setMaxAge(3600);
        c3.setMaxAge(3600);
        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);
        response.getWriter().print("cookie已写回");
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie:cookies) {
                System.out.println(cookie.getName()+"="+cookie.getValue());
            }
        }

    }
}
