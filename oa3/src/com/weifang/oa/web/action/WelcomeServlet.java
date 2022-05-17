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

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        String username = null;
        String password = null;
        if(cookies!=null){
            for (Cookie cookie :
                    cookies) {
                if (cookie.getName().equals("user")) {
                    request.setAttribute("user",cookie.getValue());
                    username = cookie.getValue();
                    //若想让用户直接进入列表页面则执行以下代码
                    //session.setAttribute("username",cookie.getValue());
                }else if (cookie.getName().equals("pwd")){
                    request.setAttribute("pwd",cookie.getValue());
                    password = cookie.getValue();
                }
            }
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            boolean success = false;
            try {
                conn = JDBCUtil.getConnection();
                String sql = "select username,password from t_user where username = ? and password = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                rs = ps.executeQuery();
                if(rs.next()){
                    success = true;
                }
                if(success){
                    session.setAttribute("username",username);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUtil.close(conn,ps,rs);
            }
        }

        if(session.getAttribute("username")!=null){
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }
        else
            request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
