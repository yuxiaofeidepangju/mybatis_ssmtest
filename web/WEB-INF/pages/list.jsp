<%--
  Created by IntelliJ IDEA.
  User: 51421
  Date: 2019/7/17
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>邮箱</td>
        <td>性别</td>
    </tr><br/>
    <c:forEach items="${allEmps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender}</td>
        </tr><br/>
    </c:forEach>
</body>
</html>
