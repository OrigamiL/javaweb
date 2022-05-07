package com.weifang.oa.web;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //获取ServletContext对象
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print(this.getServletContext()+"<br>");
        ServletContext application = this.getServletContext();
        application.log("hello");
        int age = 17;
        if (age < 18) {
            application.log("sorry",new RuntimeException("FBI open the door!"));
        }
        //test ServletContext中的setAttribute and getAttribute
        //准备数据
        User user = new User("zhangsan","1234");
        //存
        application.setAttribute("userObj1",user);
        //取
        Object obj = application.getAttribute("userObj1");
        if(obj instanceof User){
            User user1 = (User)obj;
            out.print("name:"+user1.getName()+"<br>");
            out.print("password:"+user1.getPassword());
        }
        out.print("<br>");
        out.print(Thread.currentThread().getName());
    }
}
