package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controll.BoardExactRandomizer
import com.example.demo.controll.BoardFullRandomizer
import com.example.demo.controll.GameStep
import com.example.demo.model.Board
import com.example.demo.model.PlayBoard
import javafx.geometry.Pos
import tornadofx.*

class MainView : View("Game of Life by TKisely") {

    var inSimMode = false

    val simulationMenu:SimulationMenu by inject()
    val simulationView:SimulationView by inject()
    val startMenu:StartMenu by inject()

    override val root = borderpane {
        right = startMenu.root

        center = simulationView.root

        bottom=
                button ("Next"){
            setOnAction {
                GenerateNewMap(x_fromForm, y_fromForm)
                runStatus = false
                if (!inSimMode){
                    right=simulationMenu.root
                    text="New"
                    inSimMode = true
                }else{
                    right=startMenu.root
                    text="Start"
                    inSimMode = false
                }
            }
        }
    }

    companion object SimulationController{
        @JvmStatic
        var runStatus = false

        @JvmStatic
        var editStatus = false

        @JvmStatic
        var inspectStatus = true

        @JvmStatic
        var timeToNextStep = 500

        @JvmStatic
        var x_fromForm = 10

        @JvmStatic
        var y_fromForm = 10

        @JvmStatic
        var living_fromForm = 20

        @JvmStatic
        var exactliving_fromForm = false

        @JvmStatic
        var pb = PlayBoard(x_fromForm, y_fromForm)

        fun GetCellState_Index(x:Int, y:Int):Boolean?{
            return pb.cells.find {
                cell ->  (cell.x==x && cell.y == y )
            }?.isAlive
        }

        fun GenerateNewMap(x:Int, y: Int){
            pb= PlayBoard(x,y)
            SimulationView.updateCellsCount()
            if (!exactliving_fromForm){
                BoardFullRandomizer(pb, living_fromForm)
            }
            else{
                BoardExactRandomizer(pb, living_fromForm)
            }
            SimulationView.DrawAgain()
        }
    }
}

