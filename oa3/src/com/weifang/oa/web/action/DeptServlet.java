package com.weifang.oa.web.action;

import com.weifang.oa.bean.Dept;
import com.weifang.oa.util.JDBCUtil;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dept/*")
public class DeptServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);
        boolean login = false;
        if (session != null) {
            try{
                login = (boolean) session.getAttribute("login");}
            catch (Exception e){
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
            if (login) {
                if ((contextPath + "/dept/list").equals(requestURI)) {
                    doList(request, response);
                } else if ((contextPath + "/dept/delete").equals(requestURI)) {
                    doDel(request, response);
                } else if ((contextPath + "/dept/add").equals(requestURI)) {
                    doAdd(request, response);
                } else if ((contextPath + "/dept/detail").equals(requestURI)) {
                    doDetail(request, response);
                } else if ((contextPath + "/dept/modify").equals(requestURI)) {
                    doModify(request, response);
                }/*else if((contextPath+"/dept/submit").equals(requestURI)){
            doSubmit(request,response);
        } */
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    private void doModify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "update t_dept set dname = ?,loc = ? where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dname);
            ps.setString(2, loc);
            ps.setString(3, deptno);
            count = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }
        JDBCUtil.close(conn, ps, null);
        if (count == 1) {
            //request.getRequestDispatcher("/list").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }
        if (count == 0) {
            //request.getRequestDispatcher("error.html").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/error.html");
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String f = request.getParameter("f");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select dname,loc from t_dept where deptno = " + deptno + "";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                Dept dept = new Dept(deptno, dname, loc);
                request.setAttribute("dept", dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        request.getRequestDispatcher("/" + f + ".jsp").forward(request, response);
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into t_dept values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            ps.setString(2, dname);
            ps.setString(3, loc);
            count = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
        if (count == 1)
            //request.getRequestDispatcher("/list").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/dept/list");
        if (count == 0)
            //request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/error.html");
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete from t_dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            int i = ps.executeUpdate();
            if (i == 1) {
                response.sendRedirect(request.getContextPath() + "/dept/list");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Dept> deptList = new ArrayList<Dept>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select deptno,dname,loc from t_dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                deptList.add(new Dept(deptno, dname, loc));
            }
            request.setAttribute("deptList", deptList);
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
    }
}
