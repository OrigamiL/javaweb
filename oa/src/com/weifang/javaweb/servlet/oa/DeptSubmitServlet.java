package com.weifang.javaweb.servlet.oa;

import com.weifang.javaweb.servlet.util.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptSubmitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "update t_dept set dname = ?,loc = ? where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setString(3,deptno);
            count = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn!=null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }JDBCUtil.close(conn,ps,rs);
        if (count==1) {
            request.getRequestDispatcher("/list").forward(request,response);
        }
        if (count==0){
            request.getRequestDispatcher("error.html").forward(request,response);
        }
    }
}
