<%--
  Created by IntelliJ IDEA.
  User: zhezhi
  Date: 2022/5/17
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html;" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page errorPage="error.jsp" %> <%--用来指定jsp页面出错之后跳转的位置 在错误页面可以启用exception--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = null;
    name.toString();
%>
<%--
    JSP九大内置对象：
    jakarta.servlet.jsp.PageContext          pageContext   页面作用域
    jakarta.servlet.http.HttpServletRequest  request       请求作用域
    jakarta.servlet.http.HttpSession         session       会话作用域
    jakarta.servlet.ServletContext           application   应用作用域
    以上为四个域对象 pageContext<request<session<application
    以上四个域都有：setAttribute、getAttribute、RemoveAttribute方法
    使用原则：尽可能使用小的域

    java.lang.Throwable                      exception


    jakarta.servlet.ServletConfig            config


    java.long.Object                         page    this


    jakarta.servlet.jsp.JspWriter            out
    jakarta.servlet.http.HttpServletResponse response
--%>
</body>
</html>
