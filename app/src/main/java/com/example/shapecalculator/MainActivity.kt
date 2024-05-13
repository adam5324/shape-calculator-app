package com.example.shapecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var timesClicked: Int = 0
    private var selectedShape1: Int? = null
    private var selectedShape2: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoButton = findViewById<Button>(R.id.infoButton)
        infoButton.setOnClickListener {
            viewinfo()
        }

        val circleButton = findViewById<ImageButton>(R.id.circle)
        val squareButton = findViewById<ImageButton>(R.id.square)
        val rectangleButton = findViewById<ImageButton>(R.id.rectangle)
        val triangleButton = findViewById<ImageButton>(R.id.triangle)
        val showAnswerText = findViewById<TextView>(R.id.showanswer)

        circleButton.setOnClickListener {
            if (timesClicked == 0) {
                selectedShape1 = R.drawable.circle
                timesClicked++
            } else {
                selectedShape2 = R.drawable.circle
                updateShowAnswer(showAnswerText)
                timesClicked = 0
            }
        }

        squareButton.setOnClickListener {
            if (timesClicked == 0) {
                selectedShape1 = R.drawable.square
                timesClicked++
            } else {
                selectedShape2 = R.drawable.square
                updateShowAnswer(showAnswerText)
                timesClicked = 0
            }
        }

        rectangleButton.setOnClickListener {
            if (timesClicked == 0) {
                selectedShape1 = R.drawable.rectangle
                timesClicked++
            } else {
                selectedShape2 = R.drawable.rectangle
                updateShowAnswer(showAnswerText)
                timesClicked = 0
            }
        }

        triangleButton.setOnClickListener {
            if (timesClicked == 0) {
                selectedShape1 = R.drawable.trianglebutton
                timesClicked++
            } else {
                selectedShape2 = R.drawable.trianglebutton
                updateShowAnswer(showAnswerText)
                timesClicked = 0
            }
        }
    }

    private fun updateShowAnswer(showAnswerText: TextView) {
        if (selectedShape1 != null && selectedShape2 != null) {
            val combinedImageResource = getCombinedImageResource(selectedShape1!!, selectedShape2!!)
            showAnswerText.setBackgroundResource(combinedImageResource)
            selectedShape1 = null
            selectedShape2 = null
        }
    }

    private fun getCombinedImageResource(shape1: Int, shape2: Int): Int {
        return when {
            (shape1 == R.drawable.circle && shape2 == R.drawable.square) ||
                    (shape1 == R.drawable.square && shape2 == R.drawable.circle) -> R.drawable.circlesquare
            (shape1 == R.drawable.circle && shape2 == R.drawable.rectangle) ||
                    (shape1 == R.drawable.rectangle && shape2 == R.drawable.circle) -> R.drawable.circlerectangle
            (shape1 == R.drawable.circle && shape2 == R.drawable.trianglebutton) ||
                    (shape1 == R.drawable.trianglebutton && shape2 == R.drawable.circle) -> R.drawable.circletriangle
            (shape1 == R.drawable.rectangle && shape2 == R.drawable.trianglebutton) ||
                    (shape1 == R.drawable.trianglebutton && shape2 == R.drawable.rectangle) -> R.drawable.rectangletriangle
            (shape1 == R.drawable.square && shape2 == R.drawable.rectangle) ||
                    (shape1 == R.drawable.rectangle && shape2 == R.drawable.square) -> R.drawable.sqaurerectangle
            (shape1 == R.drawable.square && shape2 == R.drawable.trianglebutton) ||
                    (shape1 == R.drawable.trianglebutton && shape2 == R.drawable.square) -> R.drawable.trianglesquare

            else -> R.drawable.square
        }
    }

    private fun viewinfo() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.activity_information, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dialogView.findViewById<Button>(R.id.closebutton).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}