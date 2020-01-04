<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="/web1/css/foundation.css">
    <link rel="stylesheet" href="/web1/css/style.css">
    <style>
        body {background: #d6eaf8}
        #content1 {
            position: fixed;
            top: 20%;
            bottom: 0;
        }
        #content2 {
            position: fixed;
            top: 20%;
            bottom: 0;
            text-align: right;
        }
        #footer {
            position: fixed; /* Фиксированное положение */
            left: 0; bottom: 0; /* Левый нижний угол */
            padding: 10px; /* Поля вокруг текста */
            background: #39b54a; /* Цвет фона */
            color: #fff; /* Цвет текста */
            width: 100%; /* Ширина слоя */
        }
    </style>
</head>
<body>
         <div style="text-align: center;"> <h8>Морской бой alpha</h8></div>
         <div id="content1">
       <#list tablearray as innerarray>
        <div class="short-1 columns">
            <#list innerarray as itemvalue>
              <a href="#" class="medium radius ${itemvalue} button"></a>
        </#list>
        </div>
        </#list>
             </div>
         <div id="content2">
             <#assign x=0>
          <#list enemytablearray as enemyinnerarray>
              <div class="short-1 columns">
                  <#assign y=0>
                  <#list enemyinnerarray as enemyitemvalue>
                      <a href="/battleships/${you}/battle1/10/10/10/10/${x}/${y}" class="medium radius ${enemyitemvalue} button"></a>
                      <#assign y=y+1>
                  </#list>
                  <#assign x=x+1>
              </div>
          </#list>
              </div>
         <div id="footer">
             <div style="text-align: center;">
             &copy;2019 SOYFER BORIS
             </div>
         </div>
</body>
</html>