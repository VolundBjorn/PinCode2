package com.example.pincode

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private const val TXT_BUFF = ""

class MainActivity : AppCompatActivity() {
    private var txt = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textview = findViewById<TextView>(R.id.textView)
        val but1 = findViewById<Button>(R.id.button1)
        val but2 = findViewById<Button>(R.id.button2)
        val but3 = findViewById<Button>(R.id.button3)
        val but4 = findViewById<Button>(R.id.button4)
        val but5 = findViewById<Button>(R.id.button5)
        val but6 = findViewById<Button>(R.id.button6)
        val but7 = findViewById<Button>(R.id.button7)
        val but8 = findViewById<Button>(R.id.button8)
        val but9 = findViewById<Button>(R.id.button9)
        val but0 = findViewById<Button>(R.id.button0)
        val but10 = findViewById<Button>(R.id.button10)
        val butOK = findViewById<Button>(R.id.buttonOK)
        val listButtons = listOf(but1, but2, but3, but4, but5, but6, but7, but8, but9, but10, but0, butOK)
        val passCode = "1567"
        for (i in listButtons) {
            i.setOnClickListener {
                textview.setTextColor(Color.WHITE)
                if (txt.length < 4) {
                    txt += when (i) {
                        but1 -> "1"
                        but2 -> "2"
                        but3 -> "3"
                        but4 -> "4"
                        but5 -> "5"
                        but6 -> "6"
                        but7 -> "7"
                        but8 -> "8"
                        but9 -> "9"
                        but0 -> "0"
                        else -> ""
                    }
                }
                if (i == but10) {
                    txt = txt.dropLast(1)
                    textview.setTextColor(Color.WHITE)
                }
                if (i == butOK && txt == passCode) {
                    textview.setTextColor(Color.CYAN)
                    val intent = Intent(this@MainActivity, Activity::class.java)
                    startActivity(intent)
                }
                if (i == butOK && txt != passCode) {
                    textview.setTextColor(Color.RED)
                }
                textview.text = txt
            }
        }
        savedInstanceState?.getString(TXT_BUFF)?.let {
            str ->
            txt = str
            textview.text = str
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TXT_BUFF, txt)
    }
}