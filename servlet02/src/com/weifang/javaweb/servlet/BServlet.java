package com.weifang.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet implements Servlet {
    public BServlet() {
        System.out.println("BServlet无参数构造方法执行了");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("Hello World!");

        response.setContentType("text/html");//设置响应类型要在流输入之前

        PrintWriter out = response.getWriter();
        out.print("Hello Servlet, you are my first servlet!");
        out.print("<h1>Hello Servlet</h1>");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
