<%@page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增部门</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/dept/add" method="post">
    部门编号<input type="text" name="deptno" /><br>
    部门名称<input type="text" name="dname"/><br>
    部门地址<input type="text" name="loc"/><br>
    <input type="submit" value="新增"><br>
</form>
<input type="button" onclick="window.history.back()" value="返回"/>
</body>
</html>