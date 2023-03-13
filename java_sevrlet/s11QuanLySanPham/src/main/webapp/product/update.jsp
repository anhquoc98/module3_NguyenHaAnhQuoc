<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/13/2023
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>update</h2>
<form action="/product?action=update" method="post">
    <div>
        <span>Input Id</span>
        <span><input type="text" name="id" value="${product.getId()}"></span>
    </div>

    <div>
        <span>Input Name</span>
        <span><input type="text" name="name" value="${product.getNameProduct()}"></span>
    </div>

    <div>
        <span>Input Color</span>
        <span><input type="text" name="color"value="${product.getColor()}"></span>
    </div>

    <div>
        <span>Input Price</span>
        <span><input type="text" name="price" value="${product.getPrice()}"></span>
    </div>
    <div>
        <input type="submit">
        <input type="reset">
    </div>
</form>

</body>
</html>
