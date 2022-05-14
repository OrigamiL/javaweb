package com.weifang.oa.web.action;

import com.weifang.oa.util.JDBCUtil;
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

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        if((contextPath + "/user/login").equals(requestURI)){
            doLogin(request,response);
        }else if((contextPath + "/user/logout").equals(requestURI)){
            doLogout(request,response);
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean success = false;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from t_user where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        if (success){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }
        else
            response.sendRedirect(request.getContextPath()+"/error.html");
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();//手动销毁session对象
            //session.removeAttribute("username");
            response.sendRedirect(request.getContextPath());
        }
    }


}
