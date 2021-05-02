package com.example.tictaktoe

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.ViewCompat
import kotlin.random.Random


class   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    private var activePlayer = 1
    private var Player1 = HashSet<Int>()
    private var Player2 = HashSet<Int>()
    private var player1WinsCounts = 0
    private var player2WinsCounts = 0

    fun buClick(view: View) {
        val buSelected = view as Button
        var cellid : Int= 0
        when(buSelected.id) {
            R.id.button1 -> cellid = 1
            R.id.button2-> cellid = 2
            R.id.button3-> cellid = 3
            R.id.button4-> cellid = 4
            R.id.button5-> cellid = 5
            R.id.button6-> cellid = 6
            R.id.button7-> cellid = 7
            R.id.button8-> cellid = 8
            R.id.button9-> cellid = 9
        }
        //Log.d("ButtonNo",buSelected.id.toString())
        //Log.d("ButtonNo cellID",cellid.toString())
        playGame(buSelected,cellid)

    }

    private fun playGame(buSelected : Button, cellid : Int) {
        if(activePlayer == 1) {
            buSelected.text = "X"
            buSelected.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.red_color))
            Player1.add(cellid)
            activePlayer = 2
            // autoPlay()
        } else {
            buSelected.text = "O"
            buSelected.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.blue_color))
            Player2.add(cellid)
            activePlayer = 1
        }
        buSelected.isEnabled = false
        checkWinner()
    }
    private fun checkWinner() {
        var winner = -1

        //row1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3))
        {
            winner = 1
        }
        else if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3))
        {
            winner = 2
        }

        //row2
        else if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6))
        {
            winner = 1
        }
        else if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6))
        {
            winner = 2
        }

        //row3
        else if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9))
        {
            winner = 1
        }
        else if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9))
        {
            winner = 2
        }

        //col1
        else if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7))
        {
            winner = 1
        }
        else if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7))
        {
            winner = 2
        }

        //col2
        else if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8))
        {
            winner = 1
        }
        else if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8))
        {
            winner = 2
        }

        //col3
        else if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9))
        {
            winner = 1
        }
        else if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9))
        {
            winner = 2
        }

        //cross1
        else if (Player1.contains(1) && Player1.contains(5) && Player1.contains(9))
        {
            winner = 1
        }
        else if (Player2.contains(1) && Player2.contains(5) && Player2.contains(9))
        {
            winner = 2
        }

        //cross2
        else if (Player1.contains(3) && Player1.contains(5) && Player1.contains(7))
        {
            winner = 1
        }
        else if (Player2.contains(3) && Player2.contains(5) && Player2.contains(7))
        {
            winner = 2
        }

        if (winner == 1) {
            player1WinsCounts++
            Toast.makeText(this,"Player 1 has Won",Toast.LENGTH_LONG).show()
            restartGame()
        }
        else if(winner == 2) {
            player2WinsCounts++
            Toast.makeText(this,"Player 2 has Won",Toast.LENGTH_LONG).show()
            restartGame()
        }
    }

    private fun autoPlay(){


            val emptyCells = ArrayList<Int>()

            for( cellId in 1..9){

                if( !(Player1.contains(cellId) || Player2.contains(cellId))){
                    emptyCells.add(cellId)
                }
            }



            if(emptyCells.size==0){
                restartGame()
            }

            val r = java.util.Random()
            val randIndex = r.nextInt(emptyCells.size)
            val cellID = emptyCells[randIndex]
            val buttonSelected : Button = when(cellID) {
                1-> findViewById<Button>(R.id.button1)
                2-> findViewById<Button>(R.id.button2)
                3-> findViewById<Button>(R.id.button3)
                4-> findViewById<Button>(R.id.button4)
                5-> findViewById<Button>(R.id.button5)
                6-> findViewById<Button>(R.id.button6)
                7-> findViewById<Button>(R.id.button7)
                8-> findViewById<Button>(R.id.button8)
                9-> findViewById<Button>(R.id.button9)
                else -> {
                    findViewById<Button>(R.id.button1)
                }
            }
            playGame(buttonSelected,cellID)

    }

    private fun restartGame(){

        activePlayer = 1
        Player1.clear()
        Player2.clear()

        for(cellId in 1..9){

            val buSelected : Button = when(cellId) {
                1-> findViewById<Button>(R.id.button1)
                2-> findViewById<Button>(R.id.button2)
                3-> findViewById<Button>(R.id.button3)
                4-> findViewById<Button>(R.id.button4)
                5-> findViewById<Button>(R.id.button5)
                6-> findViewById<Button>(R.id.button6)
                7-> findViewById<Button>(R.id.button7)
                8-> findViewById<Button>(R.id.button8)
                9-> findViewById<Button>(R.id.button9)
                else -> {
                    findViewById<Button>(R.id.button1)
                }
            }
            buSelected.text = ""
            buSelected.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
            buSelected.isEnabled = true
        }

        Toast.makeText(this,"Player1: $player1WinsCounts, Player2: $player2WinsCounts", Toast.LENGTH_LONG).show()


    }


}