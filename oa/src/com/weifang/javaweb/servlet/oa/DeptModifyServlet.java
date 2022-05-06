package com.weifang.javaweb.servlet.oa;

import com.weifang.javaweb.servlet.util.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptModifyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("        <!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <title>修改部门</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<form action='/oa/submit' method='post'>");
        out.print("                部门编号<input type='text' name='deptno' value='"+deptno+"' readonly/><br>");
        out.print("                部门名称<input type='text' name='dname' value = '"+dname+"'/><br>");
        out.print("                部门地址<input type='text' name='loc' value = '"+loc+"'/><br>");
        out.print("    <input type='submit' value='修改'><br>");
        out.print("</form>");
        out.print("<input type='button' onclick='window.history.back()' value='返回'/>");
        out.print("</body>");
        out.print("</html>");
    }
}
