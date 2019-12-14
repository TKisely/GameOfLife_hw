package com.example.demo.view

import com.example.demo.controll.EraseBoard
import com.example.demo.controll.GameStep
import com.example.demo.controll.isFinished
import javafx.geometry.Pos
import javafx.scene.layout.Priority
import kotlinx.coroutines.*
import sun.applet.Main
import tornadofx.*
import kotlin.math.round
import java.math.BigDecimal
import java.math.RoundingMode


class SimulationMenu : View("Simulation Menu") {
    lateinit var lab:javafx.scene.control.Label
    override val root =  vbox {

        button("Run"){
            minWidth=150.0
            setOnAction {
                if(!MainView.runStatus){
                    text="Stop"
                    MainView.runStatus=true
                    GlobalScope.launch { AutoStepping() }

                }else{
                    text="Run"
                    MainView.runStatus=false
                }
            }
        }

        button("Edit"){
            minWidth=150.0
            setOnAction {
                if (MainView.editStatus){
                    text="Edit"
                    MainView.editStatus=false
                }else{
                    text="Finished"
                    MainView.editStatus=true
                }
            }
        }

        button("Erase"){
            minWidth=150.0
            setOnAction {
                if(!MainView.editStatus && !MainView.runStatus)
                EraseBoard(MainView.pb)
                SimulationView.DrawAgain()
            }
        }

        button("Step"){
            minWidth=150.0
            setOnAction {
                if (MainView.runStatus){
                    GameStep(MainView.pb)
                    SimulationView.DrawAgain()
                }
            }
        }
    hbox {
        button("Speed +"){
            minWidth=50.0
            setOnAction {
                if(MainView.timeToNextStep>100){
                    MainView.timeToNextStep=MainView.timeToNextStep-50
                    lab.text=(1000.0/MainView.timeToNextStep).toBigDecimal().setScale(2,RoundingMode.HALF_EVEN).toString()
                }
            }
        }

        button("Speed -"){
            minWidth=50.0
            setOnAction {
                if(MainView.timeToNextStep<1000){
                    MainView.timeToNextStep=MainView.timeToNextStep+50
                    lab.text=(1000.0/MainView.timeToNextStep).toBigDecimal().setScale(2,RoundingMode.HALF_EVEN).toString()
                }
            }
        }
        lab = label((1000.0/MainView.timeToNextStep).toBigDecimal().setScale(2,RoundingMode.HALF_EVEN).toString())
}

    }
}

suspend fun AutoStepping(){

    while (MainView.runStatus){
        GameStep(MainView.pb)
        SimulationView.DrawAgain()
        delay(MainView.timeToNextStep.toLong())
    }
}
