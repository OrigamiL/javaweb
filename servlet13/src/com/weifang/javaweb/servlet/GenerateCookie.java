package com.weifang.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie/generate")
public class GenerateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // Cookie cookie = new Cookie("productid","ada2134");
       // cookie.setMaxAge(60);
        //设置cookie的有效期小于0 表示cookie不会被存储 表示不会被存储到硬盘文件中，会放在浏览器运行内存中 跟不调用setMaxAge是同一个效果
        //设置cookie的有效期等于0 表示删除该cookie 主要应用使用这种方式删除浏览器上的同名cookie
       // response.addCookie(cookie);
    }
}
