package com.weifang.oa.web;

import jakarta.servlet.*;

import java.io.IOException;

public abstract class GenericServlet implements Servlet {

    ServletConfig config;

    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        this.init();
    }

    /**
     * 这个方法是供给子类重写的
     */
    public void init(){
        System.out.println("Generic's init execute!");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    /**
     * 抽象方法，这个方法最常用，所以要求子类必须实现service方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)
           throws ServletException, IOException;


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
