package com.weifang.oa.oa;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class List extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Map<Object,Object> map = responseData();
        out.print(map);
    }
    public Map<Object,Object> responseData() {
        ServletContext servletContext = this.getServletContext();
        // String driver = (String) servletContext.getInitParameter("driver");
        String url = (String) servletContext.getInitParameter("url");
        String user = (String) servletContext.getInitParameter("user");
        String password = (String) servletContext.getInitParameter("password");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<Object, Object> map = null;
        try {
            conn = JDBCUtil.getConnection(url, user, password);
            String sql = "select * from t_dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            map = new HashMap<>();
            int count = 0;
            while (rs.next()) {
                count++;
                Map<Object, Object> map1 = new HashMap<>();
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                map1.put("deptno", deptno);
                map1.put("dname", dname);
                map1.put("loc", loc);
                map.put(count,map1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return map;
    }
}
