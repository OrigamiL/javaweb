
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("data","pageContext");
    request.setAttribute("data","request");
    session.setAttribute("data","session");
    application.setAttribute("data","application");
%>
<%--EL表达式优先从小范围中取数据--%>
${data} <%--pageContext--%>
<%--EL表达式如何指定范围读取数据--%>
<%--pageScope requestCope sessionScope applicationScope--%>
<%--在实际开发中因为向某个域中存取数据的时候name都是不同的，所以xxxScope是可以省略的--%>
<br>
${pageScope.data}
<br>
${requestScope.data}
<br>
${sessionScope.data}
<br>
${applicationScope.data}
<br>
<%--EL表达式做了空处理 如果是null 则显示空白 EL表达式主要任务是做页面展示，要求最终页面展示上是友好的 --%>
EL表达式：${a}
</body>
</html>
