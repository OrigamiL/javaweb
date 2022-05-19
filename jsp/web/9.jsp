<%@ page import="java.util.Objects" %>
<%@ page import="com.weifang.javaweb.jsp.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  EL表达式当中的运算符
  1.算术运算符
    + - * / %
  2.关系运算符
    == != > >= < <= eq
  3.逻辑运算符
    ! && || not and or
  4.条件运算符
    ? :
  5.取值运算符
    [] .
  6.empty运算符
--%>

${1+2}<%--3--%>
${1+"2"} <%--3--%>
<%--
    +不会做字符串拼接，两边都要转换为数字 转不成数字报错 NumberFormatException
--%>
${"aaa"eq"aaa"}
${"a"=="a"}
<%
    User u1 = new User();
    User u2 = new User();
    u1.setUsername("zhezhi");
    u2.setUsername("zhezhi");

    request.setAttribute("obj1",u1);
    request.setAttribute("obj2",u2);
%>
<%--<%=(u1==u2)%>--%>
<%=(u1.equals(u2))%>
${obj1==obj2} <%--EL表达式中==跟!=都会调用equals方法--%>
${obj1 eq obj2}
${empty param.username==null}
${param.username==null}
${param.username==null?"用户名不能为空！":"欢迎访问！"}