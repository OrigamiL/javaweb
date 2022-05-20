<%@ page import="java.util.ArrayList" %>
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
                                 jakarta.servlet.jsp.jstl-api-2.0.0.jar
        如何引用JSTL标签库jar包？
        在WEB-INF下新建lib目录，然后将jar包拷贝进去，然后Add lib
        什么需要将jar包放到WEB-INF目录下？ 这个jar包是tomcat服务器没有的
    2.在JSP中引用要使用的标签库(使用taglib指令引入标签库)
        JSTL提供了很多标签，你要引用哪个标签？重点掌握核心标签库
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>
<%
    List<Student> list = new ArrayList<>();
    Student student1 = new Student("11","zhangsan");
    Student student2 = new Student("22","lisi");
    Student student3 = new Student("33","wangwu");
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
<hr>
<%--使用标签库--%>
<%--item代表的是要遍历的集合 var代表集合中每一个元素 begin开始 end 结束 step步长--%>
<%--vatStatus 这个属性表示var的状态对象 这是一个java对象 这个java对象代表了var的状态--%>
<%--varStatus这个状态对象有count属性 可以直接使用 从1开始 以1递增 主要用于序号--%>
<c:forEach items="${stuList}" var="s" begin="0" end="${stuList.size()}" step="1" varStatus="stuStatus">
    编号:${stuStatus.count},no:${s.no},name:${s.name}<br>
</c:forEach>
</body>
</html>
