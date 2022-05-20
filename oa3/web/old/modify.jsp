<%@ page import="com.weifang.oa.bean.Dept" %>
<%@page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改部门</title>
</head>
<body>
<%
    String contextPath = request.getContextPath();
    Dept dept = (Dept) request.getAttribute("dept");
%>
<form action="<%=contextPath%>/dept/modify" method="post">
    部门编号<input type="text" name="deptno" value="<%=dept.getDeptno()%>" readonly/><br>
    部门名称<input type="text" name="dname" value="<%=dept.getDname()%>"/><br>
    部门地址<input type="text" name="loc" value="<%=dept.getLoc()%>"/><br>
    <input type="submit" value="修改"><br>
</form>
<input type="button" onclick="window.history.back()" value="返回"/>
</body>
</html>