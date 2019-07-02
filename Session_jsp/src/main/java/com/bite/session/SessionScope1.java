package com.bite.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author:  llf
 * Created in 2019/7/1 13:53
 */
public class SessionScope1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<String> list =new ArrayList<>();
        list.add("losi");
        list.add("javk");
        list.add("marry");

        session.setAttribute("name", "张三");
      //  session.setAttribute("list", list);
        System.out.println("保存数据成功了");
    }
}
