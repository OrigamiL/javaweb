<%@ page import="com.weifang.javaweb.jsp.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--if标签 test支持EL表达式--%>
<%--var属性--%>
<%--scope属性用来指定var存储域--%>

<c:if var="isEmpty" scope="page" test="${empty param.username}" >
    <h1>用户名不能为空！</h1>
</c:if>
empty:${pageScope.isEmpty}
<c:if test="${not empty param.username}">
    <h1>欢迎${param.username}！</h1>
</c:if>
<c:forEach var="i" begin="1" end="10" step="1" > <%--var存到page域中--%>
    ${pageScope.i}
</c:forEach>