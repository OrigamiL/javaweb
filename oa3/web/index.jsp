<%@page contentType="text/html;charset=UTF-8"%>
<%--<%@page session="false" %>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WELCOME TO USE OA SYSTEM</title>
</head>
<body>
<%
    String contextPath = request.getContextPath();
    if(session.getAttribute("username")!=null){
        response.sendRedirect(contextPath + "/dept/list");
    }
%>
<h1>LOGIN PAGE</h1>
<%--<a href="<%=contextPath%>/dept/list">查看部门列表</a>--%>
<hr>
<form action="<%=contextPath%>/user/login" method="post">
    username：<input type="text" name="username"/><br>
    password：<input type="password" name="password"/><br>
    <input type="submit" value="login"/>
</form>
</body>
</html>