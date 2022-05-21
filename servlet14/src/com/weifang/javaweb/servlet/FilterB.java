package com.weifang.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("*.do")
//@WebFilter("*.do")  这种属于模糊匹配中的拓展匹配 以*开始 注意这种路径前面不加/
//@WebFilter("/dept/*") 属于前缀匹配 要以/开始
//@WebFilter("/*")        匹配所有路径
public class FilterB implements Filter {

    public FilterB() {
        System.out.println("无参数构造方法执行！");
    }

    /*
            在Filter对象第一次被创建之后调用，并且只调用一次
         */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法执行");
    }

    /*
        只要用户发送一次请求则执行一次 在这个方法中编写过滤规则
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        //在请求的时候添加过滤规则
        System.out.println("doFilter方法开始执行");

        //执行下一个过滤器，如果下一个不是过滤器，则执行目标程序Servlet
        chain.doFilter(request,response);

        //在响应的时候添加过滤规则
        System.out.println("doFilter方法执行结束");
    }

    /*
        在Filter对象被销毁之前调用，并且只调用一次
     */

    @Override
    public void destroy() {
        System.out.println("destroy方法执行");
    }
}
