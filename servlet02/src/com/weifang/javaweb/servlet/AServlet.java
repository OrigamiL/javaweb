package com.weifang.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class AServlet implements Servlet {
    public AServlet() {
        System.out.println("AServlet无参数构造方法执行了");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        /*
          init方法只会执行一次
          在对象第一次被创建之后执行
         */
        System.out.println(servletConfig);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void destroy() {
        /*
        destroy方法也只执行一次
        tomcat服务器在销毁对象之前会调用一次destroy方法
        destroy方法在执行的时候，对象的内存还没有被销毁，即将被销毁
        destroy方法中可以编写销毁前的准备
        比如：服务器管别的时候，对象开启了一些资源，这些资源可能是流，可能是数据库连接，这些代码就可以写在destroy方法中
         */

        System.out.println("AServlet's destroy method execute");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        /*
        service方法是处理用户请求的核心方法
        只要用户发送一次请求，service方法就会执行一次
         */

        System.out.println("AServlet's service method execute");
    }

    @Override
    public String getServletInfo() {
        return null;
    }


}
