package com.weifang.oa.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class LoginServlet extends GenericServlet{
    /**
     * 这个方法是供给子类重写的
     */

    @Override
    public void init() {
        System.out.println("LoginServlet's init execute!");
    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println("正在处理用户登录请求....");
        ServletConfig config = this.getServletConfig();
        System.out.println("获得servletConfig："+config);
    }
}
