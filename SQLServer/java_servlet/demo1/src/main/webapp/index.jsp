<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        image{
            width: 20px;
            height: 20px;
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
            <td>${customer.img}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>