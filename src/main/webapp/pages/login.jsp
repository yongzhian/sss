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
<h4>登录</h4><br>
用户名：<input id="username" value="zain" /><br><br>
密码:<input type="password" id="password" /><br><br>
<button onclick="login('<%=path%>')" >登录</button><br><br><br>
<h5>Power by Zain 2017年11月24日</h5>

<script charset="utf-8" type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.js"></script>
<script charset="utf-8" type="text/javascript" src="<%=path%>/static/js/login.js"></script>
</body>
</html>
