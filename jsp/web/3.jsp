<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%
    request.setAttribute("username","zhangSan");
%>
<%=request.getAttribute("username")%>
${username}

</body>
</html>
