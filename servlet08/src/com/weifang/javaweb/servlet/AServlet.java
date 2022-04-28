package com.weifang.javaweb.servlet;

import jakarta.servlet.RequestDispatcher;
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
        //response.sendRedirect("/servlet08/test.html");
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = sdf.format(nowTime);
        request.setAttribute("sysTime",time);
        request.setAttribute("address",request.getRemoteAddr());
        /*
        在AServlet中new一个BServlet，然后调用BServlet对象的doGet方法，把request传进去，
        这个代码虽然可以实现功能，但是Servlet对象不能由程序猿自己来new，自己new的Servlet对象
        生命周期不受Tomcat服务器的管理
        BServlet bServlet = new BServlet();
        bServlet.doGet(request,response);
         */

        //正确方法为使用Servlet当中的转发机制 资源跳转
        /*
        执行了AServlet对象之后，跳转到BServlet
        怎么转发？
        1.获取请求转发器对象
        request.getRequestDispatcher(path);
        相当于把"/b"这个路径包装到请求转发器当中，实际上是把下一个跳转的资源的路径告知给Tomcat
         */
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/test.html");
        //2.调用请求转发器RequestDispatcher的forward方法进行转发
        //转发的时候，这两个参数很重要，request和response都是要传递给下一个资源的
        //  requestDispatcher.forward(request,response);
        request.getRequestDispatcher("/b").forward(request,response);
        //可以转发到一个servlet，也可以转发到一个html，只要是WEb容器中合法的资源即可

    }
}

