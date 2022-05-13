package com.weifang.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/*
    session的实现原理：
    在web服务器中有一个session列表，类似于map集合，在这个map集合的key存储的是session id
    这个map集合的value存储的是对应的session对象

    用户发送第一次请求的时候，服务器会创建一个新的session对象，同时给session对象生成一个id，然后web服务器会将session的id发送给浏览器
    浏览器将session的id保存在浏览器的缓存当中

    用户第二次发送请求的时候：会自动将浏览器缓存中的session id自动发送给服务器，服务器获取到session id，然后从session列表中查找到对
    对应的session对象

    为什么关闭浏览器 会话结束？
    关闭浏览器之后，浏览器中保存的session id消失，下次重新打开浏览器止呕，浏览器缓存中没有这个session id 自然找不到服务器中
    对应的session对象，session对象找不到等同于会话结束。

    session对象什么时候被销毁？
    一种销毁是超时销毁
    一种销毁是手动销毁
    浏览器关闭的时候，服务器是不知道的，服务器无法监测到浏览器关闭，所以session的销毁要依靠session超时机制，但也有一种可能，
    系统提供了安全退出，用户可以点击这个按钮，这样服务器就知道你退出了，然后服务器会自动销毁session对象。

    用户第一次请求，服务器生成session对象，同时生成id 将id发送给浏览器
    用户第二次请求，自动地将浏览器内存的id发送给服务器，服务器根据id查找session对象
    关闭浏览器 内存消失 cookie消失 session id消失 会话等同于结束
 */

@WebServlet("/test/session")
public class TestSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("name","zhezhi");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(session);
        //request.getRequestDispatcher("/test/session2").forward(request,response);
        //response.sendRedirect(request.getContextPath()+"/test/session2");
    }
}
