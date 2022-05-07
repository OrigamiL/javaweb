package com.weifang.oa.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet",
            //urlPatterns = {"/hello1","/hello2","/hello3"},
            //loadOnStartup = 1,
                    value = {"/hello4"},//只有一个元素大括号可以省略 如果注解的属性只有一个value value也可以省略

                    initParams = {@WebInitParam(name = "username",value = "root"),
                                  @WebInitParam(name = "password",value = "294753qQ"),})
//name属性 用来指定Servlet名字                               等同于 <servlet-name>
//urlPatterns属性 用来指定Servlet的映射路径，可以指定多个字符串   等同于 <url-pattern>
//loadOnStartup属性 用来指定在服务器启动阶段 是否加载该Servlet  等同于 <load-on-startup>
//initParams 初始化参数
//
//
public class HelloServlet extends HttpServlet {

    public HelloServlet() {
        System.out.println("无参数构造方法执行，HelloServlet加载完成");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String servletName = getServletName();
        String servletPath = request.getServletPath();
        String username = getInitParameter("username");
        String password = getInitParameter("password");
        out.print(servletName+"<br>");
        out.print(servletPath+"<br>");
        out.print(username+"<br>");
        out.print(password+"<br>");
    }
}
