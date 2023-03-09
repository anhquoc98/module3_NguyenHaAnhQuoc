<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<style>
    form{
        text-align: center;
    }
</style>
<body>
<h1 style="text-align: center">Product Discount Calculator</h1>
<form action="/ProductServlet" method="get" style="background-color: cadetblue">
    <label>
        <textarea placeholder="Mô tả"></textarea>
    </label>
    <div>
        <input type="text" name="listPrice" placeholder="List Price">
    </div>
    <div>
        <input type="text" name="percent" placeholder="Discount Percent">
    </div>
    <input type="submit" id="submit">
</form>
</body>
</html>