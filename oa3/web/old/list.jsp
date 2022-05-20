<%@ page import="com.weifang.oa.bean.Dept" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>部门列表</title>
    <%--<base href="http://localhost:8080/oa/">--%><%--base标签，是html标签 该页面下所有不以/开头的路径，之前都会加上base路径--%>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type='text/javascript'>
        function del(dno) {
            var ok = confirm('是否删除？');
            if (ok) {
                window.location.href = '<%=request.getContextPath()%>/dept/delete?deptno=' + dno;
            }
        }
    </script>
</head>


<body><h1 align='center'>部门列表</h1>
<h3>欢迎<%=session.getAttribute("username")%>
</h3>
<a href="<%=request.getContextPath()%>/user/logout">[退出系统]</a>
<hr>
<table align='center' border='1px' width='50%'>
    <tr>
        <th>序号</th>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>操作</th>
    </tr>
    <%
        List<Dept> deptList = (List<Dept>) request.getAttribute("deptList");
        int i = 0;
        for (Dept d :
                deptList) {
    %>
    <tr>
        <td><%=(++i)%>
        </td>
        <td><%=d.getDeptno()%>
        </td>
        <td><%=d.getDname()%>
        </td>
        <td>
            <a href='javascript:void(0)' onclick="del(<%=d.getDeptno()%>)">删除</a>&nbsp;
            <a href='<%=request.getContextPath()%>/dept/detail?f=modify&deptno=<%=d.getDeptno()%>'>修改</a>&nbsp;
            <a href='<%=request.getContextPath()%>/dept/detail?f=detail&deptno=<%=d.getDeptno()%>'>详情</a>
        </td>
    </tr>
    <%
        }
    %>

</table>
<a href='<%=request.getContextPath()%>/add.jsp'>新增</a>

</body>
</html>