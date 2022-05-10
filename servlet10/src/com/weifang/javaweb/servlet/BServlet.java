package com.weifang.javaweb.servlet;

import com.weifang.javaweb.javabean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object user = request.getAttribute("user");
        String user2 = request.getParameter("user");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (user instanceof User user1) {
            out.print(user1);
        }
        out.print(user);
        out.print(user2);
    }
}
