package battleship

import io.vertx.core.json.JsonArray

fun main() {
    var a:Int
    var b:Int
 var board=Board()
    board.countShip=2;
    var cell1=Cell(3,2)
    var cell2=Cell(6,4)
    var status=board.addship(4,cell1,SHIP_DIRECTION_EAST)
    println(status)
    var status1=board.addship(2,cell2,SHIP_DIRECTION_EAST)
    println(status1)
   while (true) {
       a= readLine()!!.toInt()
       b= readLine()!!.toInt()
       println(board.fire(Cell(a,b)))
   }
}
