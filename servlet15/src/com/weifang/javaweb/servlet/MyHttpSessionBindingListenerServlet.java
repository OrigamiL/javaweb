package com.weifang.javaweb.servlet;

import com.weifang.javaweb.bean.User1;
import com.weifang.javaweb.bean.User2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/binding")
public class MyHttpSessionBindingListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User1 user1 = new User1("111","zhangsan","123");
        User2 user2 = new User2("222","lisi","123");
        session.setAttribute("user1",user1);
        session.removeAttribute("user1");
      //  session.setAttribute("user2",user2);
    }
}
