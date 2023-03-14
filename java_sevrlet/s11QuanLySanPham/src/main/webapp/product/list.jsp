<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/13/2023
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List</h1>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Color</td>
        <td>Price</td>

    </tr>
    <tr>
        <c:forEach items="${productList}" var="product">
    <tr>
        <th>${product.id}</th>
        <th>${product.nameProduct}</th>
        <th>${product.color}</th>
        <th>${product.price}</th>
    <th><a href="product?action=update&id=${product.id}">update</a></th>
    <td><a href="/product?action=delete&id=${product.id}">delete</a></td>
    </tr>
    </c:forEach>
    </tr>
</table>
<div>
    <a href="http://localhost:8080/product/add.jsp">Add Product</a>
</div>
</body>
</html>
