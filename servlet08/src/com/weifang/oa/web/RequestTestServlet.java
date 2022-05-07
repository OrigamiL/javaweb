package com.weifang.oa.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;


/*
总结一下request接口四个非常重要的方法：
    Map<String, String[]> parameterMap = request.getParameterMap();
    Enumeration<String> parameterNames = request.getParameterNames();
    Map<String, String[]> parameterMap = request.getParameterMap();
        String[] parameterValues = request.getParameterValues("name");
        String value = request.getParameter("name");

    request.setRequestDispatcher(path).forward(request,response);转发请求
    request.getRemoteAddr();获取IP
    request.setCharacterEncoding("UTF-8");设置请求体的字符集为utf-8 解决post请求乱码问题 Tomcat10之后不需要
    String contextPath = request.getContextPath();   动态获取应用的根路径     /servlet08
    String requestURI = request.getRequestURI();     获取请求的URI          /servlet08/request
    String servletPath = request.getServletPath();   获取servlet path      /request
    String method = request.getMethod();             获取请求的方式          /POST

    response.setContentType("text/html;charset=UTF-8"); 设置响应内容类型设置，解决乱码问题


 request对象实际上又称为“请求域”对象：
    应用域对象是什么？
        ServletContext（Servlet上下文对象）
        什么情况下会考虑向ServletContext这个应用域中绑定数据呢？
            1.所有用户共享
            2.这个共享的数据很小
            3，这个共享的数据很少的修改操作
            在以上三个条件满足的情况下，使用这个应用域对象，可以大大提高我们的程序执行效率
            实际上向应用域当中绑定数据，就相当于把数据放到了缓存（cache）当中，然后用户访问的时候，直接从缓存中取，减少IO操作
            大大提升系统的性能，所以缓存技术是提高系统性能的重要手段
        ServletContext当中有三个操作域的方法：
            void setAttribute(String name, Object obj); 向域当中绑定数据
            Object getAttribute(String name); 从域当中根据name获取数据
            void removeAttribute(String name); 将域当中绑定的数据移除
    请求域对象是什么？
        “请求域”对象要比“应用域”对象范围小很多，生命周期短很多。 请求域只在一次请求内有效
        一个请求对象request对应一个请求域对象，一次请求结束之后，这个请求域就销毁了
        请求域对象也有这三个方法：
            void setAttribute(String name, Object obj); 向域当中绑定数据
            Object getAttribute(String name); 从域当中根据name获取数据
            void removeAttribute(String name); 将域当中绑定的数据移除
        请求域和应用域的选用原则？
            尽量使用小的域对象，因为小的域对象占用的资源较少。
 */
public class RequestTestServlet extends HttpServlet {
/*

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(request);//org.apache.catalina.connector.RequestFacade@67804e80

    }*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Map<String, String[]> parameterMap = request.getParameterMap();

        out.print(parameterMap+"<br>");
        //1
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> e :
                entries) {
            String key = e.getKey();
            String[] value = e.getValue();
            for (String s : value) {
                out.print(key + "=" + s+"<br>");
            }
        }

        //2.直接通过getParameterNames()方法，直接获取这个Map集合的所有key
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(name);
            out.print(name+"="+ Arrays.toString(parameterValues));
            out.print("<br>");

            for (String value :
                    parameterValues) {
                out.print(name+"="+value+"<br>");
            }
        }
        //3.直接通过name获取value这个一维数组
        String[] usernames = request.getParameterValues("username");
        String[] passwords = request.getParameterValues("password");
        String[] interests = request.getParameterValues("interest");
        out.print(Arrays.toString(usernames)+"<br>");
        out.print(Arrays.toString(passwords)+"<br>");
        out.print(Arrays.toString(interests)+"<br>");

        //4.通过name获取value这个一维数组的第一个元素，这个方法使用最多，因为，这个一维数组中一般只有一个元素
        String username = request.getParameter("username");
        System.out.println(username);
        this.log(username);
        out.print("<br>");
        out.print(request.getContextPath());
        out.print("<br>");
        out.print(request.getMethod());
        out.print("<br>");
        out.print(request.getRequestURI());
        out.print("<br>");
        out.print("servletPath:"+request.getServletPath());
        out.print("<br>");
        out.print("servletName:"+this.getServletName());
    }
}
