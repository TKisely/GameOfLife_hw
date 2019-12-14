package com.example.demo.model

class PlayBoard(val xCellsN:Int, val yCellsN:Int=xCellsN):Board(xCellsN,yCellsN) {

    val changeTable = ArrayList<Boolean>()

    fun GetNumber_livingCells(): Int {
        var num=0
        for (cell in cells){
            if (cell.isAlive){
                num++
            }
        }
        return num
    }

    fun updateChangeTable(){
        for (i in 0 until cells.size){
            val actualCell = cells[i]

            if (actualCell.isAlive){
                when(actualCell.CountNeighbours(this)){
                    0,1->changeTable[i]=true
                    2,3->changeTable[i]=false
                    else ->changeTable[i]=true
                }
            } else{
                changeTable[i] = actualCell.CountNeighbours(this)==3
            }
        }
    }

    init {
        for (x in 1..xCellsNum){
            for(y in 1..yCellsNum){
                cells.add(Cell(x,y,false))
                changeTable.add(false)
            }
        }
    }
}