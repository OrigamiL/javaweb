package com.weifang.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ServletConfig
 * 1.ServletConfig是什么？ jakarta.servlet.ServletConfig 是Servlet规范中的一员 是一个接口
 * 2.谁去实现了这个接口？ org.apache.catalina.core.StandardWrapperFacade  Tomcat服务器实现了这个接口
 *      如果把tomcat服务器换成jetty服务器输出ServletConfig对象的时候，输出结果不一定一样，包名类名可能和Tomcat不一样，
 *      但是他们都实现了ServletConfig这个规范。
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
    }
}
