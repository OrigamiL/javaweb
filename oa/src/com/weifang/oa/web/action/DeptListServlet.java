package com.weifang.oa.web.action;

import com.weifang.oa.util.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
        out.print("        window.location.href='"+request.getContextPath()+"/delete?deptno='+dno");
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
                          "<a href='"+request.getContextPath()+"/modify?deptno="+deptno+"&dname="+dname+"&loc="+loc+"'>修改</a>&nbsp;" +
                          "<a href='"+request.getContextPath()+"/detail?deptno="+deptno+"'>详情</a></td>");
                out.print(" </tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
        out.print("</table>");
        out.print("<a href='add.html' >新增</a>");

        out.print("</body>");
        out.print("</html>");
    }


/*    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }*/
}
