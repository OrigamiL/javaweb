package com.weifang.oa.web.action;

import com.weifang.oa.util.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

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
        String login = request.getParameter("login");

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
        if (success) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            if ("ok".equals(login)) {
                Cookie cookie = new Cookie("user", username);
                cookie.setMaxAge(10 * 24 * 60 * 60);
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else
            response.sendRedirect(request.getContextPath()+"/loginError.html");
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();//手动销毁session对象
            //session.removeAttribute("username");
        }
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie c :
                    cookies) {
                //if(c.getName().equals("user")){
                    c.setMaxAge(0);
                    c.setPath(request.getContextPath());
                    response.addCookie(c);
               // }
            }
            response.sendRedirect(request.getContextPath());
        }else
            response.sendRedirect(request.getContextPath()+"/error.html");

    }


}
