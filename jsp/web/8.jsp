<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    EL表达式中的隐含对象：
    pageContext
    param             request中的parameter
    paramValues       复选框获取values
    initParam         ServletContext中的initParameter
    其他
--%>
应用的根路径：${pageContext.request.contextPath}<br>

用户名：<%=request.getParameter("username")%><br>
${param.username}<br>

<%=Arrays.toString(request.getParameterValues("aihao"))%><br>
<%=request.getParameterValues("aihao")[0]%><br>
<%=request.getParameterValues("aihao")[1]%><br>
<%=request.getServletContext().getInitParameter("username")%>

${param.aihao}<br>

${paramValues.aihao[0]}<br>
${paramValues.aihao[1]}<br>
<%--获取contextParam--%>
${initParam.username}<br>
${initParam.pageSize}<br>
<%=application.getInitParameter("pageSize")%>