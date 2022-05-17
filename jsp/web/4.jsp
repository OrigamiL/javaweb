<%@ page import="com.weifang.javaweb.jsp.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = new User();
    user.setUsername("jackson");
    user.setPassword("123");
  request.setAttribute("userObj",user);

%>
${userObj.username}
${userObj.email}
</body>
</html>
