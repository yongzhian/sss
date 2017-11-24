<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
有效用户查询
总用户数:${sysUserPage.totalPages}
<table>
    <c:choose>
        <c:when test="${! empty sysUserPage.content}">
            <c:forEach var="obj" items="${sysUserPage.content}" varStatus="objState">
                <tr>
                    <td>${obj.id }</td>
                    <td>${obj.username }</td>
                </tr>
            </c:forEach></c:when>
        <c:otherwise>
            <tr>
                <td >
                <td colspan="2"><label>暂时没有相关内容</label>
                </td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>

<h5>Power by Zain 2017年11月24日</h5>

<script charset="utf-8" type="text/javascript" src="/lib/jquery/1.9.1/jquery.js"></script>
<script charset="utf-8" type="text/javascript" src="/static/js/index.js"></script>
</body>
</html>