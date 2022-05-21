package com.weifang.oa.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        String servletPath = request.getServletPath();
        //System.out.println(servletPath);

        if ("/index.jsp".equals(servletPath) || "/welcome".equals(servletPath) || "/user".equals(servletPath) ||session != null && session.getAttribute("username") != null) {
            chain.doFilter(request,response);
        } else
            response.sendRedirect(request.getContextPath());
    }
}
