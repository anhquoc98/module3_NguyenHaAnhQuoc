<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/10/2023
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        img{
            width: 20px;
            height: 20px;
        }
        table{
            text-align: center;

        }
        body{
            display:flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;

        }
    </style>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<table border="2">
    <tr style="background-color: aqua">
        <th>Name</th>
        <th>DateOfBirth</th>
        <th>Address</th>
        <th>Img</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.dateOfBrith}</td>
            <td>${customer.address}</td>
            <td><img src="${customer.img}" alt=""></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>