package com.example.demo.controll

import com.example.demo.model.Board
import com.example.demo.model.CountNeighbours
import com.example.demo.model.PlayBoard
import com.example.demo.view.MainView
import java.util.*


fun BoardFullRandomizer(board: PlayBoard, livingCellAbout:Int){

    val mod = (board.number_cells/livingCellAbout).toInt()

    for (cell in board.cells){
        val rand = Random().nextInt(101)
        if (rand%mod==0){
            cell.isAlive=true;
        }
    }
}

fun BoardExactRandomizer(board: Board, livingCell: Int){
    for (n in 0 until livingCell){
        val rand = Random().nextInt(board.cells.size)
        board.cells[rand].isAlive=true
    }
}

fun GameStep(board: PlayBoard){
    board.updateChangeTable()

    for (i in 0 until board.cells.size){
        if (board.changeTable[i]){
            board.cells[i].isAlive=!(board.cells[i].isAlive)
        }
    }
}

fun EraseBoard(board: PlayBoard){
    for (i in 0 until board.cells.size){
        board.cells[i].isAlive=false
    }
}

fun isFinished(board: PlayBoard):Boolean{
    for (c in board.changeTable){
        if (c){
            return false
        }
    }
    return true
}