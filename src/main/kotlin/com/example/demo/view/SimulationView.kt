package com.example.demo.view

import com.example.demo.controll.BoardFullRandomizer
import com.example.demo.model.Cell
import com.example.demo.model.CountNeighbours
import com.sun.org.apache.xpath.internal.operations.Bool
import javafx.scene.paint.Color
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import tornadofx.*
import java.awt.Canvas

var sizeX = 600
var sizeY = 600

var cellsX = MainView.x_fromForm
var cellsY = MainView.y_fromForm

var cellPixSizeX= sizeX/cellsX
var cellPixSizeY = sizeY/cellsY

var c = javafx.scene.canvas.Canvas()

class SimulationView : View("Simulation") {
    override val root = flowpane{

    }
    init {
        with(root){

            c = this.canvas(sizeX.toDouble(), sizeY.toDouble())

            BoardFullRandomizer(MainView.pb, 10)
            DrawMap(c, x_cellsNum = cellsX, y_cellsNum = cellsY, canvasSizeX = sizeX, canvasSizeY = sizeY)

            c.setOnMousePressed {
                editHandle(it)
            }
//            c.setOnMouseDragged {
//                editHandle(it)
//            }
        }
    }

    companion object{

        @JvmStatic
        fun updateCellsCount(){
            cellsX = MainView.x_fromForm
            cellsY = MainView.y_fromForm

            cellPixSizeX= sizeX/cellsX
            cellPixSizeY = sizeY/cellsY
        }

        @JvmStatic
        fun DrawAgain(){
            DrawMap(c, x_cellsNum = cellsX, y_cellsNum = cellsY, canvasSizeX = sizeX, canvasSizeY = sizeY)

        }

        fun convertPixelToCellposition(pixel:Int, cellSize:Int):Int{
            return (pixel/cellSize).toInt()
        }

        fun DrawMap(c:javafx.scene.canvas.Canvas, x_cellsNum:Int, y_cellsNum:Int, canvasSizeX:Int, canvasSizeY:Int){
            val cellPixSizeX= canvasSizeX/x_cellsNum
            val cellPixSizeY = canvasSizeY/y_cellsNum

            val g = c.graphicsContext2D
            g.fill = Color.GREY

            g.fillRect(0.0,0.0,c.width,c.height)

            var colorChanger:Boolean=true

            for (y in 0 until canvasSizeY){
                for (x in 0 until canvasSizeX){
                    if (y%cellPixSizeY==0){
                        if (x%cellPixSizeX==0){

                            val xCellCoordinate = convertPixelToCellposition(x,cellPixSizeX)+1
                            val yCellCoordinate = convertPixelToCellposition(y,cellPixSizeY)+1

                            val actualCell = MainView.GetCellState_Index(xCellCoordinate, yCellCoordinate)

                            when((x/cellPixSizeX)%1){
                                0-> {   if(actualCell!=null && actualCell==true){
                                    g.fill = Color.BLACK

                                }else{
                                    g.fill=Color.AQUA
                                }
                                    g.fillRect(x.toDouble(), y.toDouble(), cellPixSizeX.toDouble(),cellPixSizeY.toDouble())}
                            }
                        }
                    }
                }
            }
        }
    }




    fun editHandle(event: MouseEvent){
        if (MainView.editStatus){
            val mouseX = event.x
            val mouseY = event.y

            val xCellCoordinate = convertPixelToCellposition(mouseX.toInt(),cellPixSizeX)+1
            val yCellCoordinate = convertPixelToCellposition(mouseY.toInt(),cellPixSizeY)+1

            var actualCell = MainView.pb.cells.find { cell -> (cell.x==xCellCoordinate && cell.y == yCellCoordinate) }
            actualCell?.isAlive= !(actualCell?.isAlive!!)

            DrawMap(c, x_cellsNum = cellsX, y_cellsNum = cellsY, canvasSizeX = sizeX, canvasSizeY = sizeY)
        }
        if (MainView.inspectStatus){
        }
    }

    fun boolChanger(b:Boolean):Boolean{ return !b }

    fun convertPixelToCellposition(pixel:Int, cellSize:Int):Int{ return (pixel/cellSize).toInt() }
}
