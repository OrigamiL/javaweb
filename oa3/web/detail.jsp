<%@ page import="com.weifang.oa.bean.Dept" %>
<%@page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>部门详情</title>
</head>
<body>

部门编号：${dept.deptno}
<br>
部门名称：${dept.dname}
<br>
部门位置：${dept.loc}
<br>
<input type="button" onclick="window.history.back()" value="返回"/>
</body>
</html>