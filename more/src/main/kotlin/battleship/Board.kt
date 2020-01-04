package battleship
class Board() {
    private var destroycount: Int = 0
    var countShip:Int=0
    var Cells = arrayListOf<Cell>()
    var ships = arrayListOf<Ship>()

    fun addship(size: Int, cell: Cell, direction: String): Boolean {
        var ship = Ship(size)
        if (check(cell)) {
            ship.make(cell, direction)
            for(i in ship.cells)
            if (!check(i))
                return false
            ships.add(ship)
            return true
        }
        return false
    }

    fun addcell(Cell: Cell) {
        Cells.add(Cell)
    }

    fun check(Cell: Cell): Boolean {
        for (i in ships) {
            for (cellOfShip in i.cells) {
                if (cellOfShip.x == Cell.x && cellOfShip.y == Cell.y || (cellOfShip.x + 1 == Cell.x && cellOfShip.y + 1 == Cell.y) || (cellOfShip.x - 1 == Cell.x && cellOfShip.y - 1 == Cell.y) || (cellOfShip.x + 1 == Cell.x && cellOfShip.y == Cell.y) || (cellOfShip.x - 1 == Cell.x && cellOfShip.y == Cell.y) || (cellOfShip.x == Cell.x && cellOfShip.y + 1 == Cell.y) || (cellOfShip.x == Cell.x && cellOfShip.y - 1 == Cell.y) || (cellOfShip.x - 1 == Cell.x && cellOfShip.y + 1 == Cell.y) || (cellOfShip.x + 1 == Cell.x && cellOfShip.y - 1 == Cell.y))
                    return false
            }
        }
        return true
    }

    fun fire(Cell: Cell): String {
        var statusOfFire: String = CELL_STATUS_FIRED
         for (ship in ships) {
            statusOfFire = ship.fire(Cell)
            if (statusOfFire == SHIP_STATUS_DIED)
                if (checkship())
                    return "You win"
             else
                    return statusOfFire
             if (statusOfFire == SHIP_STATUS_FIERED)
                 return statusOfFire
        }
        return statusOfFire
    }

    fun checkship(): Boolean {
        destroycount++
        if (destroycount == countShip)
            return true
        return false
    }

}
