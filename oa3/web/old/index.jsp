<%@page contentType="text/html;charset=UTF-8"%>
<%--<%@page session="false" %>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WELCOME TO USE OA SYSTEM</title>
</head>
<body>

<h1>LOGIN PAGE</h1>
<%--<a href="<%=contextPath%>/dept/list">查看部门列表</a>--%>
<hr>
<form action="<%=request.getContextPath()%>/user/login" method="post">
    username：<input type="text" name="username" value="<%=(request.getAttribute("user")==null?"":request.getAttribute("user"))%>"/><br>
    password：<input type="password" name="password" value="<%=(request.getAttribute("pwd")==null?"":request.getAttribute("pwd"))%>"/><br>
    <input type="checkbox" name="login" value="ok"/>十天内免登录<br>
    <input type="submit" value="login"/>
</form>
</body>
</html>