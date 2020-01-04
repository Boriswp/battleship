<#-- @ftlvariable name="newsize" type="int" -->
<#-- @ftlvariable name="newy" type="int" -->
<#-- @ftlvariable name="newx" type="int" -->
<#-- @ftlvariable name="newdir" type="char" -->
<#-- @ftlvariable name="you" type="int" -->
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="/web1/css/foundation.css">
<link rel="stylesheet" href="/web1/css/style.css">
<head>
    <meta charset="UTF-8">
    <style>
        body {background: #d6eaf8}
    #footer {
    position: fixed; /* Фиксированное положение */
    left: 0; bottom: 0; /* Левый нижний угол */
    padding: 10px; /* Поля вокруг текста */
    background: #39b54a; /* Цвет фона */
    color: #fff; /* Цвет текста */
    width: 100%; /* Ширина слоя */
    }
    #content4{
        position: fixed;
        top: 20%;
        bottom: 0;
        left: 60%;
    }
    #content3{
        position: fixed;
        top: 60%;
        bottom: 0;
        left: 80%;
    }
    #content2{
        position: fixed;
        top: 40%;
        bottom: 0;
        left: 80%;
    }
    #content1 {
        position: fixed;
        top: 15%;
        bottom: 0;
    }
    </style>
</head>
<body>
<#function saveval></#function>
<div style="text-align: center;"> <h8>Морской бой alpha</h8></div>
<div id="content1">
    <#assign x=0>
    <#list tablearray as innerarray>
        <div class="short-1 columns">
            <#assign y=0>
            <#list innerarray as itemvalue>
                <a href="/battleships/${you}/${x}/${y}" class="medium radius ${itemvalue} button"></a>
                <#assign y=y+1>
            </#list>
            <#assign x=x+1>
        </div>
    </#list>
    <div id="content2">
        <#assign direction="N">
        <a href="/battleships/${you}/${direction}/0/0"class="middle-centered  button" >N</a>
        <#assign direction="E">
        <a href="/battleships/${you}/${direction}/0/0"class="middle-centered  button">E</a>
        <#assign direction="W">
        <a href="/battleships/${you}/${direction}/0/0"class="middle-centered  button" >W</a>
        <#assign direction="S">
        <a href="/battleships/${you}/${direction}/0/0"class="middle-centered  button" >S</a>
        <#assign size=1>
        <a href="/battleships/${you}/${size}"class="middle-centered  button" >1</a>
        <#assign size=2>
        <a href="/battleships/${you}/${size}"class="middle-centered  button" >2</a>
        <#assign size=3>
        <a href="/battleships/${you}/${size}"class="middle-centered  button" >3</a>
        <#assign size=4>
        <a href="/battleships/${you}/${size}"class="middle-centered  button" >4</a>
    </div>
    <div id="content4">
        <A>X=${newx}</A>
        <A>Y=${newy}</A>
        <A>DIRECTION=${newdir}</A>
        <A>SIZE=${newsize}</A>
    </div>
    <div id="content3">
        <#assign create=1>
        <a href="/battleships/${you}/${newsize}/${newx}/${newy}/${newdir}"class="large-centered  button" >setup ship</a>
        <a href="/battleships/${you}/battle1/10/10/10/10"  class="large-centered  button" >start battle</a>
</div>
</div>
<div id="footer">
    <div style="text-align: center;">
        &copy;2019 SOYFER BORIS
    </div>
</div>
</body>
</html>