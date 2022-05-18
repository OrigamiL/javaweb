
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %><%--忽略EL表达式（全局）--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("username","zhezhi");
%>
${username}
\${username} <%--\忽略EL表达式--%>
${pageContext.request}<%--EL表达式中有一个隐式对象pageContext  跟JSP内置对象pageContext相同--%>
<%--等同于--%><br>
<%=pageContext.getRequest()%>
<br>
<%--通过EL表达式获取应用的根--%>
${pageContext.request.contextPath}
<br>
<%=request.getContextPath()%>
<br>
<%=pageContext.getRequest().getServletContext().getContextPath()%>
<br>
<%=((HttpServletRequest)pageContext.getRequest()).getContextPath()%>
</body>
</html>
