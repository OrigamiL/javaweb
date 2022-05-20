<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${param.age<18}">
        青少年
    </c:when>
    <c:when test="${param.age<40}">
        青年
    </c:when>
    <c:when test="${param.age<55}">
        中年
    </c:when>
    <c:otherwise>
        老年
    </c:otherwise>
</c:choose>
