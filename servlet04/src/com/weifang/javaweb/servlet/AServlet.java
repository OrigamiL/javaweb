package com.weifang.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 1.ServletContext是接口，是Servlet规范中的一员
 * 2.ServletContext接口是Tomcat服务器（WEB服务器）实现的 org.apache.catalina.core.ApplicationContextFacade
 * 3.ServletContext对象是谁创建的？ServletContext对象在WEB服务器启动的时候创建，是WEB服务器创建的
 *      对于一个webapp来说，ServletContext对象只有一个。
 *      ServletContext对象在服务器关闭的时候销毁。
 * 4.ServletContext就是Servlet对象的环境对象（Servlet对象的上下文对象）
 *      ServletContext对象其实对应的就是整个web.xml文件
 *      放在ServletContext对象中的数据，一定是所有Servlet共享的
 *      50个学生，每一个学生都是一个Servlet，这50个学生都在一个教室中，教室就是ServletContext
 *      一个教室中的空调是所有学生共享的
 *      Tomcat是一个容器，一个容器当中可以放多个webapp，一个webapp对应一个ServletContext对象
 * 5.ServletContext常用方法：
 *      1.public String getInitParameter(String name); 通过初始化参数的name获取value
 *      2.public Enumerate<T> getInitParameterNames(); 获取所有的初始化参数的name
 *      3.public String getContextPath(); 获取应用的根路径
 *      4.public String getRealPath（）; 获取文件的绝对路径   /代表web的根 ../代表上层路径
 *      5.public void log(String message); public void log(String message, Throwable t);
 *      6.public void setAttribute(String name, Object value); //map.put(k,v)
 *      7.public Object getAttribute(String name);  //map.get(k);
 *      8.public void removeAttribute(String name);  //map.remove(k);
 *          会记录到CATALINA_HOME/logs目录中的 localhost.yyyy-MM-dd.log
 *          log目录下都有哪些文件？
 *          catalina.yyyy-MM-dd.log 服务器端的java程序运行的控制信息
 *          localhost.yyyy-MM-dd.log ServletContext对象的log方法记录的日志信息存储到这个文件中
 *          localhost_access_log.yyyy-MM-dd.txt 访问日志
 * 6.ServletContext对象还有另一个名字：应用域（后面还有其他域，例如：请求域、会话域）
 *   如果所有的用户共享一份数据，并且这个数据很少被修改，并且这个数据量很少，可以将这些数据放到ServletContext这个应用域当中
 *   为什么是所有用户共享的数据？  不是共享的没有意义，因为ServletContext这个对象只有一个，只有共享的数据放进去才有意义
 *   为什么数据量要少？  因为数据量比较大的话，太占用堆内存，并且这个对象的生命周期比较长，服务器关闭的时候，才会被销毁，大数据量会影响服务器的性能
 *   为什么这些共享数据很少的修改，或者说几乎不修改？   所有用户共享的数据，如果涉及到修改操作，必然会存在线程并发所带来的的安全问题
 * 所以放在ServletContext对象中的数据一般都是只读的。
 *           数据量小，所有用户共享，又不修改，这样的数据放到ServletContext这个应用域当中，会大大提高效率，因为应用域相当于一个缓存，放到缓存中的数据
 *      下次在用的时候，不需要从数据库中再次获取，大大提升效率。
 *      存  public void setAttribute(String name, Object value); //map.put(k,v)
 *      取  public Object getAttribute(String name);  //map.get(k);
 *      删  public void removeAttribute(String name);  //map.remove(k);
 *
 *
 */

public class AServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //获取ServletContext对象
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print(this.getServletContext());
        ServletContext application = this.getServletContext();
        Enumeration<String> names = application.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = application.getInitParameter(name);
            out.print(name+"="+value);
        }
        out.print("<br>");
        out.print(application.getContextPath());//获取应用的根路径
        out.print("<br>");
        out.print(application.getRealPath("index.jsp"));//获取文件的绝对路径
        out.print("<br>");
        out.print(application.getAttribute("userObj1"));
    }
}
