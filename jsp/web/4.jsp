<%@ page import="com.weifang.javaweb.jsp.bean.User" %>
<%@ page import="com.weifang.javaweb.jsp.bean.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--
        EL表达式的使用：
        EL表达式只能从某个范围中取数据，
--%>
<body>
<%
    User user = new User();
    Address address = new Address();
    address.setCity("北京");
    address.setStreet("海淀区");
    address.setZipcode("1100");
    user.setUsername("jackson");
    user.setPassword("123");
    user.setSex(true);
    user.setAddr(address);
    request.setAttribute("userObj",user);
%>
${userObj} <%--等同于<%=request.getAttribute("userObj")%> 底层是怎么做的？从域中取数据，取出user对象，
                然后调用user多想的toString方法转换成字符串输出到浏览器--%>
<br>
<%=request.getAttribute("userObj")%>
<br>
${userObj.username} <%--.xxx这个语法实际上调用了底层的getXxx()方法(返回值为boolean的为isXxx)--%>
<br>
${userObj.email}
<br>
${userObj.sex}
<br>
${userObj.addr.c} <%--此处的.addr取决于User类中getAddr的方法名是怎样写的,--%>
<br>
${userObj.addr.street}
<br>
${userObj.addr.zipcode}
<br>
${userObj["username"]}<%--中括号如果不加双引号，则将username看做变量，加双引号，则去user对象中找username属性--%>
<br>
${userObj["addr"]["c"]}
</body>
</html>
