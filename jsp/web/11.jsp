<%@ page import="java.util.ArrayList" %>
<%@ page import="com.weifang.javaweb.jsp.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.weifang.javaweb.jsp.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入标签库，这里引入的是JSTL的核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--以上的uri后面的路径实际上指向了一个xxx.tld文件，tld文件实际上是一个xml配置文件，在tld文件中描述了标签和java类之间的关系，
    以上核心标签库对应的tld文件是：c.tld文件，此文件在jakarta.servlet.jsp.jstl-2.0.0.jar的META-INF中--%>
<html>
<head>
    <title>JSTL标签库</title>
</head>
<body>
<%--
    1.引用JSTL标签库对应的jar包
            tomcat10对应的jar包是：jakarta.servlet.jsp.jstl-2.0.0.jar
                                 taglibs-standard-impl-1.2.5.jar
                                 taglibs-standard-spec-1.2.5.jar
        如何引用JSTL标签库jar包？
        在WEB-INF下新建lib目录，然后将jar包拷贝进去，然后Add lib
        什么需要将jar包放到WEB-INF目录下？ 这个jar包是tomcat服务器没有的
    2.在JSP中引用要使用的标签库(使用taglib指令引入标签库)
        JSTL提供了很多标签，你要引用哪个标签？重点掌握核心标签库
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>
<%
    List<Student> list = new ArrayList<>();
    Student student1 = new Student("1","zhangsan");
    Student student2 = new Student("2","lisi");
    Student student3 = new Student("3","wangwu");
    list.add(student1);
    list.add(student2);
    list.add(student3);
    request.setAttribute("stuList",list);
%>
<%--将list集合中的元素遍历输出--%>
<%--使用java代码--%>
<%
    List<Student> stuList = (List<Student>)request.getAttribute("stuList");
    for (Student s :
            stuList) {
        %>
        no:<%=s.getNo()%><br>
        name:<%=s.getName()%><br>
<%
    }
%>
<%--使用标签库--%>
<c:forEach items="" var=""></c:forEach>
</body>
</html>
