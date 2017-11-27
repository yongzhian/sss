<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String url = request.getRequestURI();
%>
<!DOCTYPE>
<html>
<head>
    <title>SSS</title>
</head>
<body>
<h5>Spring5.0.1.RELEASE+SpringDataJPA2.0.1.RELEASE+Hibernate5.2.12.Final</h5><br>

<h3>欢迎：${sysUser.username}</h3>

<a href="<%=path%>/sysuser/grid.do">查看用户信息</a>

<hr>
用户名：<input id="username" value="XXX" /><br><br>
密码:<input type="password" id="password" /><br><br>
是否锁定:<input type="is_valid" id="isLocked" value="F" /><br><br>
是否有效:<input type="is_valid" id="isValid" value="T" /><br><br>
<button onclick="addUser('<%=path%>')" >添加</button><br><br><br>

<h5>Power by Zain 2017年11月24日</h5>

<script charset="utf-8" type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.js"></script>
<script charset="utf-8" type="text/javascript" src="<%=path%>/static/js/index.js"></script>
</body>
</html>