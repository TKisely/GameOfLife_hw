package com.example.demo.view

import javafx.scene.control.TextField
import tornadofx.*

class StartMenu : View("Start Menu") {

    var xData=0
    var yData=0
    var livingData = 0

    var xCellNumbers: TextField by singleAssign()
    var yCellNumbers: TextField by singleAssign()
    var livingCellNumbers: TextField by singleAssign()

    override val root = vbox {
        var l = label("Original Datas: ")
        form {
            fieldset ("Size:"){
                field ("X: "){
                    xCellNumbers = textfield (){
                        text="10"
                        filterInput { it.controlNewText.isInt() }
                    }
                }
                field ("Y: "){
                    yCellNumbers = textfield (){
                        text="10"
                        filterInput { it.controlNewText.isInt() }
                    }
                }
                button("Set new size"){
                    setOnAction {
                        xData=xCellNumbers.text.toInt()
                        yData=yCellNumbers.text.toInt()

                        if(xData>8&&yData>8&&xData<50&&yData<50){
                            MainView.x_fromForm=xData
                            MainView.y_fromForm=yData
                            l.text="I can do it"
                        }
                        else{
                            l.text="Not possible!"
                        }
                    }
                }
            }
            fieldset("Living cells: "){
                field{
                    livingCellNumbers = textfield (){
                        text = "10"
                        filterInput { it.controlNewText.isInt() }
                    }
                }
                field("Exact number?"){
                    checkbox {
                        action {
                                MainView.exactliving_fromForm = isSelected
                        }
                    }
                }
                button ("Set new parameter"){
                    setOnAction {
                        val maxLiving=(MainView.x_fromForm*MainView.y_fromForm)/3
                        livingData=livingCellNumbers.text.toInt()
                        if(livingData in 0 until maxLiving){
                            MainView.living_fromForm=livingData
                            l.text="Let's do it!"
                        }
                        else{
                            l.text="Not possible!"
                        }
                    }
                }
            }
        }
    }
}
