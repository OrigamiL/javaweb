package com.weifang.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * ServletConfig
 * 1.ServletConfig是什么？ jakarta.servlet.ServletConfig 是Servlet规范中的一员 是一个接口
 * 2.谁去实现了这个接口？ org.apache.catalina.core.StandardWrapperFacade  Tomcat服务器实现了这个接口
 *      如果把tomcat服务器换成jetty服务器输出ServletConfig对象的时候，输出结果不一定一样，包名类名可能和Tomcat不一样，
 *      但是他们都实现了ServletConfig这个规范。
 * 3.一个Servlet对象中有一个ServletConfig对象（一对一）
 * 4.Tomcat服务器（WEB服务器）创建了ServletConfig对象，创建Servlet对象的时候同时创建了ServletConfig对象
 * 5.ServletConfig接口：
 *      ServletConfig：Servlet对象的配置信息对象
 * 6.ServletConfig对象中包装的信息是什么：
 *      web.xml文件中<servlet></servlet>标签中的配置信息
 *   Tomcat解析web.xml文件，将web.xml文件中<servlet></servlet>标签中的配置信息自动包装到ServletConfig对象中
 */

public class ConfigTestServlet extends GenericServlet {
    /**
     * Called by the servlet container to allow the servlet to respond to a
     * request. See {@link Servlet#service}.
     * <p>
     * This method is declared abstract so subclasses, such as
     * <code>HttpServlet</code>, must override it.
     *
     * @param req the <code>ServletRequest</code> object that contains the
     *            client's request
     * @param res the <code>ServletResponse</code> object that will contain the
     *            servlet's response
     * @throws ServletException if an exception occurs that interferes with the servlet's
     *                          normal operation occurred
     * @throws IOException      if an input or output exception occurs
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ServletConfig config = this.getServletConfig();//获取ServletConfig对象
        out.print("ServletConfig对象是"+config);//一个servlet对象关联一个servletConfig对象
        out.print("<br>");
        out.print("<br>");
        out.print("<servlet-name>"+config.getServletName()+"</servlet-name>");
        out.print("<br>");
        out.print("<br>");
        //通过ServletConfig对象中的两个方法可以获得web.xml中的初始化参数配置信息
        //getInitParameterNames() 获取所有的初始化参数的name
        Enumeration<String> enumeration = config.getInitParameterNames();
        while(enumeration.hasMoreElements()) {
            out.print("<br>");
            String parameterName = enumeration.nextElement();
            //getInitParameter() 通过初始化参数的name获取value
            String parameterVal = config.getInitParameter(parameterName);
            out.print(parameterName + "=" + parameterVal);
            out.print("<br>");
        }
        Enumeration<String> names = this.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = this.getInitParameter(name);
            out.print(name+"="+value+"<br>");
        }
    }
}
