package com.weifang.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = sdf.format(nowTime);
        request.setAttribute("sysTime",time);

        /*
        在AServlet中new一个BServlet，然后调用BServlet对象的doGet方法，把request传进去，
        这个代码虽然可以实现功能，但是Servlet对象不能由程序猿自己来new，自己new的Servlet对象
        生命周期不受Tomcat服务器的管理
        BServlet bServlet = new BServlet();
        bServlet.doGet(request,response);
         */

        //正确方法为使用Servlet当中的转发机制 资源跳转
        
    }
}

