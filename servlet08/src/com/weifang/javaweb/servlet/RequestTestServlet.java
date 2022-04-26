package com.weifang.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;


public class RequestTestServlet extends HttpServlet {
/*

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(request);//org.apache.catalina.connector.RequestFacade@67804e80
        Map<String, String[]> parameterMap = request.getParameterMap();
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

        //2
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(name);
            out.print(name+"="+ Arrays.toString(parameterValues));
            for (String value :
                    parameterValues) {
                out.print(name+"="+value+"<br>");
            }
        }
    }
}
