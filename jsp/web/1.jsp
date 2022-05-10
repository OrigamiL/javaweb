<%--
  Created by IntelliJ IDEA.
  User: zhezhi
  Date: 2022/5/9
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = "jack";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    怎么向浏览器上输出一个java变量
    <%out.write(变量名);%>
    请注意：以上代码中的out是JSP的九大内置对象之一，可以直接拿来用，当然必须只能在service方法内部使用
    如果向浏览器上输出的内容没有java代码，例如输出的字符串是一个固定的字符串，可以直接在jsp中编写，不需要写到<%%>里
    如果输出的内容中含有java代码，这个时候可以使以下语法格式
    <%=%> 注意：在=的后面编写要输出的内容
    <%=%> 会被翻译到service方法中的out.print()中
--%>
你的名字是<%out.write(name+"<br>");%>
你的名字是<%=name%><br>
<%="你的名字是"+name+"<br>"%>
<%=application.getContextPath()+"<br>"%>
<%=request.getServletPath()+"<br>"%>
<%=request.getContextPath()   %>//
<%
    for (int i = 0; i < 5; i++) {
        %>
    i的值为：<%=i%>
<%
    }
%>
<%--
    Servlet的职责：收集数据。Servlet的强项是逻辑处理，业务处理，然后连接数据库，获取、收集数据
    JSP的职责： 展示数据。JSP的强项是做数据的展示
--%>

</body>
</html>
