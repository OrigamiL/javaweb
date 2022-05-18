<%@ page import="com.weifang.javaweb.jsp.bean.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: zhezhi
  Date: 2022/5/18
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--EL表达式取数据：
    数组、List采用下标 ${Array[index]} ${List[index]}
    Map采用key取value ${Map.key}
    Set不能取
--%>
<body>
<%
    Map<String,String> map = new HashMap<>();
    map.put("username","zhezhi");
    map.put("password","123");
    request.setAttribute("userMap",map);
    Map<String,Object> map1 = new HashMap<>();
    User user1 = new User();
    user1.setUsername("jack");
    map1.put("user",user1);
    request.setAttribute("userMap1",map1);
    String[] usernames = {"zhangsan","lisi","wangwu"};
    request.setAttribute("data",usernames);
    User u1 = new User();
    u1.setUsername("u1");
    User u2 = new User();
    u2.setUsername("u2");
    User[] users = {u1,u2};
    List<Object> list = new ArrayList<>();
    list.add(u1);
    list.add(u2);
    request.setAttribute("users",users);
    request.setAttribute("userList",list);
    Set<String> set = new HashSet<>();
    set.add("aaa");
    set.add("bbb");
    request.setAttribute("set",set);
%>
<%--
    ${set[0]}报错
    jakarta.el.PropertyNotFoundException: 在类型 [java.util.HashSet] 上未找到属性 [0] }
--%>
${set}
<br>
${userMap.get("username")}
<br>
${userMap.username}
<br>
${userMap["username"]}
<br>
${userMap1.user.username}
<br>
${data[0]}
<br>
${data[1]}
<br>
${data[111]}<%--取不出数据，在浏览器上显示空白 不会出现数组下标越界--%>
<br>
${users[0].username}
<br>
${users[1].username}
<br>
${userList[0].username}
</body>
</html>
