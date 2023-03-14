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
        <c:forEach items="${modelList}" var="model">
    <tr>
        <th>${model.id}</th>
        <th>${model.name}</th>
        <th>${model.email}</th>
        <th>${model.country}</th>
    </tr>
    </c:forEach>
    </tr>
</table>
</body>
</html>
