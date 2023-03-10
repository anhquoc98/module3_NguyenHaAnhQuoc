<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/10/2023
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div {
            margin: 10px;
        }

        form {

            width: 15%;
            border: 1px solid #333;
        }

        #boder {
            position: absolute;
            background-color: #fff;
            top: 47px;
        }

    </style>
</head>
<body>
<h1>Simple Calcalator</h1>
<form action="/ServletCalculator" method="post">
    <div id="boder">Calculator</div>
    <div>
        <input type="text" name="first">
    </div>
    <div>
        <select name="calcul" id="calcul">
            <option value="+">addition</option>
            <option value="-">subtraction</option>
            <option value="*">multiplication</option>
            <option value="/">share calculation</option>
        </select>
    </div>
    <div>
        <input type="text" name="second">
    </div>
    <div>
        <input type="submit">
    </div>

</form>


</body>
</html>
