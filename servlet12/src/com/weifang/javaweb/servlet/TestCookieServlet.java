package com.weifang.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie/cookie2/test")
public class TestCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cookie = new Cookie("productid","21314f");
        Cookie cookie1 = new Cookie("username","jack");
        cookie.setPath(request.getContextPath());
        cookie1.setPath(request.getContextPath());
        cookie.setMaxAge(-1);
       // cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.addCookie(cookie1);


    }
}
