package com.weifang.oa.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object sysTime = request.getAttribute("sysTime");
        Object address = request.getAttribute("address");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(sysTime);
        out.print("<br>");
        out.print(address);
    }
}
