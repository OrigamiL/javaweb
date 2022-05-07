package com.weifang.oa.web;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet2 extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String driver = this.getInitParameter("driver");
        String url = this.getInitParameter("url");
        String user = this.getInitParameter("user");
        String password = this.getInitParameter("password");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
            String sql = "insert into t_student value(7,'zhezhi')";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            sql = "select * from t_student where no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,7);
            rs = ps.executeQuery();
            while (rs.next()){
                out.print(rs.getString("no")+":"+rs.getString("name")+"<br>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
