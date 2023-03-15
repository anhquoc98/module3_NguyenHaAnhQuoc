<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/15/2023
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users?action=create" method="post">
    <div>
        <span>Input Id</span>
        <span><input type="text" name="id"></span>
    </div>

    <div>
        <span>Input Name</span>
        <span><input type="text" name="name"></span>
    </div>

    <div>
        <span>Input Email</span>
        <span><input type="text" name="email"></span>
    </div>

    <div>
        <span>Input Country</span>
        <span><input type="text" name="country"></span>
    </div>
    <div>
        <input type="submit">
        <input type="reset">
    </div>
</form>
</body>
</html>
