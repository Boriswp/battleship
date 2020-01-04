package battleship
class Cell(var x:Int,var y:Int) {
   var status:String=CELL_STATUS_Empty
    fun ravno(other: Cell)=x == other.x&&y==other.y
}