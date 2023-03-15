<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/14/2023
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

</head>
<body>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>email</td>
        <td>country</td>
    </tr>
    <tr>
        <c:forEach items="${usersList}" var="usersList">
    <tr>
        <th>${usersList.id}</th>
        <th>${usersList.name}</th>
        <th>${usersList.email}</th>
        <th>${usersList.country}</th>
    <td><a href="/users?action=delete&id=${usersList.getId()}">Delete</a></td>

</tr>
    </c:forEach>
    </tr>
    <a href="http://localhost:8080/users/save.jsp">Add Product</a>
</table>
</body>
</html>
