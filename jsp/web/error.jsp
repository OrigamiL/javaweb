<%@ page contentType="text/html;" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<%--在错误页面可以启用JSP九大内置对象之---exception
exception内置对象就是刚刚发生的异常对象--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--打印异常堆栈信息--%>
<%
    exception.printStackTrace();
%>
<h1>系统出错</h1>
</body>
</html>