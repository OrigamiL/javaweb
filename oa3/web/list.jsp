<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


<body>
<h1 align='center'>部门列表</h1>
<h3>欢迎${username}
</h3>
<a href="user/logout">[退出系统]</a>
<hr>
<table align='center' border='1px' width='50%'>
    <tr>
        <th>序号</th>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>操作</th>
    </tr>

    <c:forEach var="dept" varStatus="deptStatus" items="${deptList}">
        <tr>
            <td>${deptStatus.count}</td>
            <td>${dept.deptno}</td>
            <td>${dept.dname}</td>
            <td>
                <a href='javascript:void(0)' onclick="del(${dept.deptno})">删除</a>&nbsp;
                <a href='dept/detail?f=modify&deptno=${dept.deptno}'>修改</a>&nbsp;
                <a href='dept/detail?f=detail&deptno=${dept.deptno}'>详情</a>
            </td>
        </tr>
    </c:forEach>


</table>
<a href='add.jsp'>新增</a>

</body>
</html>