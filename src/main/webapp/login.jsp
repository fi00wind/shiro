<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/26
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        .p
        {
            color:red;
            font-size:16px;
        }
    </style>
</head>
<body>
<c:if test="${requestScope.msg != null}">
    <p class="p">${requestScope.msg}</p>
</c:if>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
    </table>
    <input type="submit" value="登录">
</form>
</body>
</html>
