package com.weifang.oa.web.action;

import com.weifang.oa.util.JDBCUtil;
import com.weifang.oa.util.UserUtil;
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

        if (UserUtil.login(username,password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            if ("ok".equals(login)) {
                Cookie cookie1 = new Cookie("user", username);
                Cookie cookie2 = new Cookie("pwd",password);
                cookie1.setMaxAge(10 * 24 * 60 * 60);
                cookie2.setMaxAge(10 * 24 * 60 * 60);
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else
            response.sendRedirect(request.getContextPath()+"/loginError.jsp");
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
