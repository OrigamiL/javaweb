<%@page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OA系统</title>
</head>
<body>
<%String contextPath = request.getContextPath();%>
<h1>欢迎使用本系统</h1>
<a href="<%=contextPath%>/dept/list">查看部门列表</a>
</body>
</html>