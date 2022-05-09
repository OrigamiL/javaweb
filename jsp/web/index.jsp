<%--
  Created by IntelliJ IDEA.
  User: zhezhi
  Date: 2022/5/9
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  System.out.println("hello jsp!");
%>
<%--怎么样在JSP中编写java程序：
      <%java语句;%>
      在这个符号当中编写的被视为java程序，被翻译到Servlet类的service方法内部
      在service方法中编写的代码是有顺序的，方法体当中的代码要遵循自上而下的顺序依次执行
      不能编写静态代码块，不能套用方法
      <%!java语句;%>
      被翻译到Servlet类中，service方法之外，一般不用，会有线程安全问题
--%>
<%--JSP专业注释，不会被翻译到java源代码当中--%>
<--这种注释属于HTML注释，会被翻译到java源代码当中-->
<%
  m1();
%>
<%!
  //成员变量
  private int num = 100;

  //静态代码块
  static {
    System.out.println("hello servlet");
  }

  //方法
  public void m1(){
    System.out.println("num = " + num);
  }
%>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>
</html>
