package com.weifang.oa.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        if(cookies!=null){
            for (Cookie cookie :
                    cookies) {
                if (cookie.getName().equals("user")) {
                    request.setAttribute("user",cookie.getValue());
                    request.setAttribute("pwd","294753qQ");
                    //若想让用户直接进入列表页面则执行以下代码
                    session.setAttribute("username",cookie.getValue());
                }
            }
        }

        if(session.getAttribute("username")!=null){
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }
        else
            request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
