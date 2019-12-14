package com.example.demo.model

open class Board(val xCellsNum:Int, val yCellsNum:Int=xCellsNum){
    val number_cells = xCellsNum*yCellsNum
    val cells = ArrayList<Cell>()

}
