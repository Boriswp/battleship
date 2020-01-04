package battleship
import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.templ.freemarker.FreeMarkerTemplateEngine
class BoardController(vertx:Vertx) {
   var data = JsonObject()
   var boardenemy:JsonArray=makeboardenemy()
   var boardenemy1:JsonArray=makeboardenemy()
   var myboard:JsonArray=makemyboard()
   var myboard1:JsonArray=makemyboard()
   var size1=0
   var n=0
   var m=0
   var me=0;
   var enemy=0
   var orient="NULL"
   var board= arrayListOf(Board(), Board(),Board())
   val engine = FreeMarkerTemplateEngine.create(vertx);
   var counter1=0
   var counter2=0
   var status=""
   fun startHandle(ctx:RoutingContext) {
      var data = JsonObject()
      engine.render(data, "temp/start.ftl") {
         if (it.succeeded()) {
            ctx.response().end(it.result())
         } else {
            ctx.response().end(it.cause().message)
         }
      }
      ctx.response().end()
   }
   fun createHandle(ctx:RoutingContext){
      board[1].countShip=10;
      board[2].countShip=10;
      var data = JsonObject()
      me=ctx.request().params().get("you").toInt()
      data.put("you",me)
      if(me==1)
      data.put("tablearray",myboard);
      else
         data.put("tablearray",myboard1);
      data.put("newsize",size1)
      data.put("newx",n)
      data.put("newy",m)
      data.put("newdir",orient)
      engine.render(data, "temp/create.ftl") {
         if (it.succeeded()) {
            ctx.response().end(it.result())
         } else {
            ctx.response().end(it.cause().message)
         }
      }
      ctx.response().end()
   }
   fun createships(ctx:RoutingContext){
      var cell=Cell(ctx.request().params().get("x").toInt(),ctx.request().params().get("y").toInt())
        var status= board[me].addship(ctx.request().params().get("size").toInt(),cell, ctx.request().params().get("direction"))
      if(status){
        for (k in 0..9)
           for(h in 0..9)
             for(t in board[me].ships)
               for (g in t.cells)
                   if (g.x ==k && g.y == h){
                      if(me==1)
                      myboard.getJsonArray(k).set(h,"success")
                      else
                         myboard1.getJsonArray(k).set(h,"success")
                   }}
      createHandle(ctx)
   }
   fun shipsdirection(ctx:RoutingContext){
      orient=ctx.request().params().get("direction").toString()
      createHandle(ctx)
   }
   fun shipscoordinate(ctx:RoutingContext){
       n=ctx.request().params().get("x").toInt()
       m=ctx.request().params().get("y").toInt()
      createHandle(ctx)
   }
   fun shipssize(ctx:RoutingContext){
      size1=ctx.request().params().get("size").toInt()
      createHandle(ctx)
   }
   fun indexHandle1(ctx:RoutingContext){
      var data =JsonObject()
      me=ctx.request().params().get("you").toInt()
      if(me==1) {
         data.put("tablearray", myboard);
         data.put("enemytablearray",boardenemy);
      }
      else {
         data.put("tablearray", myboard1);
         data.put("enemytablearray", boardenemy1);
      }
      data.put("you",me)
      engine.render(data,"temp/board.ftl") {
         if (it.succeeded()){
              ctx.response().end(it.result())
         } else{
              ctx.response().end(it.cause().message)
         }      }
      ctx.response().end()
   }
   fun makemyboard():JsonArray{
      var tableArray=JsonArray()
      for (k in 1..10) {
         var tableinner=JsonArray()
         for(h in 1..10){
            tableinner.add(" ")
         }
         tableArray.add(tableinner);
      }
      return tableArray
   }
   fun makeboardenemy():JsonArray{
      var enemytableArray=JsonArray()
      for (k in 1..10) {
         var enemytableinner=JsonArray()
         for(h in 1..10){
            enemytableinner.add(" ")
         }
         enemytableArray.add(enemytableinner);
      }
      return enemytableArray
   }
   fun coordinateHandle1(ctx:RoutingContext){
      me=ctx.request().params().get("you").toInt()
      enemy = if(me==1)
         2
      else
         1
        if(whichturn()){
         var x=ctx.request().params().get("x").toInt()
         var y=ctx.request().params().get("y").toInt()
           status=board[enemy].fire(Cell(x,y))
           if (status=="You win"){

           }
         if(status== SHIP_STATUS_FIERED||status== SHIP_STATUS_DIED) {
            if(me==1) {
               boardenemy.getJsonArray(x).set(y, "alert")
               myboard1.getJsonArray(x).set(y, "alert")
               counter1=0
            }
            else{
               boardenemy1.getJsonArray(x).set(y, "alert")
               myboard.getJsonArray(x).set(y, "alert")
               counter2=0
            }
         }
         else if(me==1) {
            boardenemy.getJsonArray(x).set(y, "secondary")
            myboard1.getJsonArray(x).set(y, "secondary")
            counter1=1
            counter2=0
         }
       else {
            boardenemy1.getJsonArray(x).set(y, "secondary")
            myboard.getJsonArray(x).set(y, "secondary")
            counter1=0
            counter2=1
         }
      indexHandle1(ctx)
   }
   }
   fun whichturn():Boolean{
      if(me==1&&counter1==0)
      return true
      if(me==2&&counter2==0)
         return true
      return false
   }
}

