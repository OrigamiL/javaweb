package com.weifang.javaweb.servlet.oa;

import com.weifang.javaweb.servlet.util.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete from t_dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        if (count==1) {
            request.getRequestDispatcher("/list").forward(request,response);
        }
        if (count==0) {
            request.getRequestDispatcher("/error.html").forward(request,response);
        }
    }

}
