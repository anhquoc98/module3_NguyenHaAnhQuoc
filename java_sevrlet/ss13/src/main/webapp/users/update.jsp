<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/15/2023
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users?action=update" method="post">
    <div>
        <span>Input Id</span>
        <span><input type="text" name="id"value="${usersList.id}"></span>
    </div>

    <div>
        <span>Input Name</span>
        <span><input type="text" name="name" value="${usersList.name}"></span>
    </div>

    <div>
        <span>Input Email</span>
        <span><input type="text" name="email" value="${usersList.email}"></span>
    </div>

    <div>
        <span>Input Country</span>
        <span><input type="text" name="country" value="${usersList.id}"></span>
    </div>
    <div>
        <input type="submit">
        <input type="reset">
    </div>
</form>
</body>
</html>
