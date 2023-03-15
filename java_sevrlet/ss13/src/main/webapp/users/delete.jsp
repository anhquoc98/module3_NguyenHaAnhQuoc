<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/15/2023
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Users</h1>
<p>
    <a href="/users"> Back To List Users</a>
</p>
<form action="/users?action=delete" method="post">

        <legend>User Information</legend>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="hidden" name="id" value="${users.getId()}"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${users.getName()}"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="${users.getEmail()}"></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><input type="text" name="country" value="${users.getCountry()}"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Delete User</button>
                </td>
            </tr>
        </table>

</body>
</html>
