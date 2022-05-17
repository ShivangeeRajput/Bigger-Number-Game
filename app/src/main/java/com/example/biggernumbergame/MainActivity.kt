package com.example.biggernumbergame

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b:Button=findViewById(R.id.btnLeft)
        val c:Button=findViewById(R.id.btnRight)
        b.setOnClickListener {
          checkAnswer(true)

            assignNumbersToButtons()
        }
        c.setOnClickListener {
            checkAnswer(false)
            assignNumbersToButtons()

        }
}

    private fun checkAnswer(isLeftButtonSelected:Boolean) {

        val b:Button=findViewById(R.id.btnLeft)
        val c:Button=findViewById(R.id.btnRight)
        val leftNum = b.text.toString().toInt()
        val rightNum = c.text.toString().toInt()
        val isAnswerCorrect= if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if (isAnswerCorrect) {

            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        }else
        {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButtons() {
        val r= Random()
        val leftNum= r.nextInt(10)
        val rightNum =r.nextInt(10)
        val b:Button=findViewById(R.id.btnLeft)
        val c:Button=findViewById(R.id.btnRight)
        b.text=leftNum.toString()
        c.text=rightNum.toString()
    }
}