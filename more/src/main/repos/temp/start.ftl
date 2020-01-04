<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="/web1/css/foundation.css">
<link rel="stylesheet" href="/web1/css/style.css">
<style>
    #footer {
        position: fixed; /* Фиксированное положение */
        left: 0; bottom: 0; /* Левый нижний угол */
        padding: 10px; /* Поля вокруг текста */
        background: #39b54a; /* Цвет фона */
        color: #fff; /* Цвет текста */
        width: 100%; /* Ширина слоя */
    }
    #content1 {
        position: fixed;
        top: 40%;
        left:45%;
        bottom: 0;
    }
    body {background: #d6eaf8}
    a {
        text-decoration: none;
        outline: none;
        display: inline-block;
        color: white;
        padding: 20px 30px;
        margin: 10px 20px;
        border-radius: 20px;
        font-family: 'Montserrat', sans-serif;
        text-transform: uppercase;
        letter-spacing: 2px;
        background-image: linear-gradient(to right, #9EEFE1 0%, #4830F0 51%, #9EEFE1 100%);
        background-size: 200% auto;
        box-shadow: 0 0 20px rgba(0,0,0,.1);
        transition: .5s;
    }

</style>
</head>
<body>
<div style="text-align: center;"> <h8>Морской бой alpha</h8></div>
<div style="text-align: center">
    <div id="content1">
            <#assign you=1>
        <a href="/battleships/${you}"class="large-centered  button">1</a>
            <#assign you=2>
        <a href="/battleships/${you}"class="large-centered  button">2</a>
        </div>
    </div>
    <div id="footer">
        <div style="text-align: center;">
            &copy;2019 SOYFER BORIS
        </div>
    </div>
</body>
</html>
