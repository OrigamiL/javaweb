package com.weifang.oa.web;

import com.weifang.oa.javabean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User(1,"jack");
        request.setAttribute("user",user);
        //request.getRequestDispatcher("/b").forward(request,response);
        response.sendRedirect("/servlet10/b?user="+user.getName()+"");

    }
}
