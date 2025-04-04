package com.example.speedlimit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val answer: TextView = findViewById<TextView>(R.id.textView2)
        val input: EditText = findViewById<EditText>(R.id.editTextNumber)
        val btn: Button = findViewById<Button>(R.id.button3)
        val btnReset: Button = findViewById<Button>(R.id.button4)

        btn.setOnClickListener {
            val Speed = input.text.toString()

            if (Speed.isNotEmpty()) {
                val TheSpeed = Speed.toString().toIntOrNull()
                if (TheSpeed != null && TheSpeed in 1..60) {
                    answer.text = "You are driving safely"
                } else if (TheSpeed in 61..80) {
                    answer.text = "Warning! Drivw carefully"
                } else if (TheSpeed in 81..100) {
                    answer.text = "Fine: R500"
                } else if (TheSpeed != null) {
                    if (TheSpeed > 100) {
                        answer.text = "Fine: R2000"
                    }

                } else {
                    answer.text = ""
                    answer.hint = "Enter a correct Speed!!"
                }
            } else {
                answer.text = "Please enter the time!!"
                return@setOnClickListener
            }
        }
        btnReset.setOnClickListener {
            // Clear the Texts
            input.text.clear()
            answer.text = "            "



        }
    }
}