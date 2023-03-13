<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form action="/product?action=create" method="post">
    <div>
        <span>Input Id</span>
        <span><input type="text" name="productId"></span>
    </div>

    <div>
        <span>Input Name</span>
        <span><input type="text" name="productName"></span>
    </div>

    <div>
        <span>Input Color</span>
        <span><input type="text" name="productColor"></span>
    </div>

    <div>
        <span>Input Price</span>
        <span><input type="text" name="productPrice"></span>
    </div>
    <div>
        <input type="submit">
        <input type="reset">
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>