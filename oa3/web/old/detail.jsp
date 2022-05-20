<%@ page import="java.util.Date" %>
<%@ page import="com.weifang.oa.bean.Dept" %>
<%@page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>部门详情</title>
</head>
<body>
<%
    Dept dept = (Dept)request.getAttribute("dept");
%>
部门编号：<%=dept.getDeptno()%>
<br>
部门名称：<%=dept.getDname()%>
<br>
部门位置：<%=dept.getLoc()%>
<br>
<input type="button" onclick="window.history.back()" value="返回"/>
</body>
</html>