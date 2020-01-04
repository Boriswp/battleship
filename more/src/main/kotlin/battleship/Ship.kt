package battleship
class Ship(var size: Int) {
    var cells = arrayListOf<Cell>()
    var dx = 0
    var dy = 0
    fun make(cell: Cell, dir: String): Boolean {
        var temporaryCell = arrayListOf<Cell>()
        CheckDirection(dir)
        makeCells(cell, temporaryCell)
        if (chekBoundry(temporaryCell)) {
            cells = temporaryCell
            return true
        }
        return false
    }

    private fun CheckDirection(dir: String) {
        when (dir) {
            SHIP_DIRECTION_NORTH -> dx = -1
            SHIP_DIRECTION_EAST -> dy = 1
            SHIP_DIRECTION_WEST -> dy = -1
            SHIP_DIRECTION_SOUTH -> dx = 1
        }

    }

    private fun makeCells(cells: Cell, temporaryCells: ArrayList<Cell>) {
        var celllocal = cells
        temporaryCells.add(cells)
        for (k in 2..size) {
            celllocal = Cell(celllocal.x + dx, celllocal.y + dy)
            temporaryCells.add(celllocal)
        }
    }

    private fun chekBoundry(temporaryCells: ArrayList<Cell>): Boolean {
        for (cell in temporaryCells) {
            if (cell.x < BOARD_BOUNDRY_X_MIN || cell.y < BOARD_BOUNDRY_Y_MIN || cell.x > BOARD_BOUNDRY_X_MAX || cell.y > BOARD_BOUNDRY_Y_MAX)
                return false
        }
        return true
    }
    fun fire(cell: Cell):String{
        var firedCellCount=0
        var flag =0
        for(cellInList in cells) {
            if (cellInList.ravno((cell))) {
                cellInList.status = CELL_STATUS_FIRED
                flag=1
            }
        }
        if (flag==0){
           return CELL_STATUS_MISSED
        }
        for(cellInList in cells) {
            if (cellInList.status == CELL_STATUS_FIRED)
                firedCellCount++
        }
     return when (firedCellCount){
         size->SHIP_STATUS_DIED
         in 1..size->SHIP_STATUS_FIERED
         else ->CELL_STATUS_MISSED
     }
    }
}