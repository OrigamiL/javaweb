package com.weifang.oa.action;

import com.weifang.oa.util.JDBCUtil;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/dept/*")
public class DeptServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        System.out.println(servletPath);
        System.out.println(contextPath);
        System.out.println(requestURI);
        if((contextPath+"/dept/list").equals(requestURI)){
            doList(request,response);
        }else if((contextPath+"/dept/add").equals(requestURI)){
            doAdd(request,response);
        }else if((contextPath+"/dept/submit").equals(requestURI)){
            doSubmit(request,response);
        }else if((contextPath+"/dept/delete").equals(requestURI)){
            doDel(request,response);
        }else if((contextPath+"/dept/modify").equals(requestURI)){
            doModify(request,response);
        } else if((contextPath+"/dept/detail").equals(requestURI)){
            doDetail(request,response);
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String deptno = request.getParameter("deptno");

        out.print("        <!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <title>部门详情</title>");
        out.print("</head>");
        out.print("<body>");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select dname,loc from t_dept where deptno = "+deptno+"";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("部门编号："+deptno+"");
                out.print("<br>");
                out.print("部门名称："+dname+"");
                out.print("<br>");
                out.print("部门位置："+loc+"");
                out.print("<br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }

        out.print("<input type='button'' onclick='window.history.back()' value='返回'/>");
        out.print("</body>");
        out.print("</html>");
    }

    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("        <!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <title>部门列表</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<script type='text/javascript'>");
        out.print("         function del (dno) {");
        out.print("    var ok = confirm('是否删除？');");
        out.print("    if(ok){");
        out.print("        window.location.href='"+request.getContextPath()+"/dept/delete?deptno='+dno");
        out.print("    }");
        out.print("}");
        out.print("</script>");
        out.print("<h1 align='center'>部门列表</h1>");
        out.print("<hr>");
        out.print("<table align='center' border='1px' width='50%'>");
        out.print("  <tr>");
        out.print("    <th>序号</th>");
        out.print("    <th>部门编号</th>");
        out.print("    <th>部门名称</th>");
        out.print("    <th>操作</th>");
        out.print("  </tr>");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select deptno,dname,loc from t_dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print(" <tr>");
                out.print("   <td>"+(++i)+"</td>");
                out.print("   <td>"+deptno+"</td>");
                out.print("   <td>"+dname+"</td>");
                out.print("   <td><a href='javascript:void(0);' onclick='del("+deptno+")' >删除</a>&nbsp;" +
                        "<a href='"+request.getContextPath()+"/dept/modify?deptno="+deptno+"&dname="+dname+"&loc="+loc+"'>修改</a>&nbsp;" +
                        "<a href='"+request.getContextPath()+"/dept/detail?deptno="+deptno+"'>详情</a></td>");
                out.print(" </tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        out.print("</table>");
        out.print("<a href='/oa2/add.html' >新增</a>");

        out.print("</body>");
        out.print("</html>");

    }
    private void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into t_dept values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            ps.setString(2,dname);
            ps.setString(3,loc);
            count = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if(conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        if(count==1)
            //request.getRequestDispatcher("/list").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        if (count==0)
            //request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
    }
    private void doSubmit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "update t_dept set dname = ?,loc = ? where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setString(3,deptno);
            count = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn!=null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }JDBCUtil.close(conn,ps,rs);
        if (count==1) {
            //request.getRequestDispatcher("/list").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }
        if (count==0){
            //request.getRequestDispatcher("error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }
    private void doDel(HttpServletRequest request, HttpServletResponse response)
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
            //request.getRequestDispatcher("/list").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }
        if (count==0) {
            //request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }
    private void doModify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("        <!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <title>修改部门</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<form action='/oa2/dept/submit' method='post'>");
        out.print("                部门编号<input type='text' name='deptno' value='"+deptno+"' readonly/><br>");
        out.print("                部门名称<input type='text' name='dname' value = '"+dname+"'/><br>");
        out.print("                部门地址<input type='text' name='loc' value = '"+loc+"'/><br>");
        out.print("    <input type='submit' value='修改'><br>");
        out.print("</form>");
        out.print("<input type='button' onclick='window.history.back()' value='返回'/>");
        out.print("</body>");
        out.print("</html>");
    }
}
