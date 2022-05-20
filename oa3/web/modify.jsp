<%@ page import="com.weifang.oa.bean.Dept" %>
<%@page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改部门</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>
<body>

<form action="dept/modify" method="post">
    部门编号<input type="text" name="deptno" value="${dept.deptno}" readonly/><br>
    部门名称<input type="text" name="dname" value="${dept.dname}"/><br>
    部门地址<input type="text" name="loc" value="${dept.loc}"/><br>
    <input type="submit" value="修改"><br>
</form>
<input type="button" onclick="window.history.back()" value="返回"/>
</body>
</html>