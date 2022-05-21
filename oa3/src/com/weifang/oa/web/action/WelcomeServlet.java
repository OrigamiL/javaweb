package com.weifang.oa.web.action;

import com.weifang.oa.bean.User;
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
            if(UserUtil.login(username,password)){
                session.setAttribute("username",username);
                User user = new User(username,password);
                session.setAttribute("user",user);
            }
        }

        if(session.getAttribute("username")!=null){
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }
        else
            request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
