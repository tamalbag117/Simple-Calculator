package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import java.lang.Double

class MainActivity : AppCompatActivity() {
    private var calculation: EditText? = null
    private var result: EditText? = null
    private var curr: String? = null
    private var res: String? = null
    private var btn0: Button? = null
    private var btn1: Button? = null
    private var btn2: Button? = null
    private var btn3: Button? = null
    private var btn4: Button? = null
    private var btn5: Button? = null
    private var btn6: Button? = null
    private var btn7: Button? = null
    private var btn8: Button? = null
    private var btn9: Button? = null
    private var btnDIV: Button? = null
    private var btnClear: Button? = null
    private var btnAdd: Button? = null
    private var btnMult: Button? = null
    private var btnSub: Button? = null
    private var btnEQ: Button? = null
    private var btnDOT: Button? = null
    private var btnDEL: Button? = null
    private var dot_insarted = false
    private var operator_insarted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculation = findViewById(R.id.calculation) as EditText
        result = findViewById(R.id.result) as EditText
        curr = ""
        res = ""
        dot_insarted = false
        operator_insarted = false
        btn0 = findViewById(R.id.ButZERO) as Button
        btn1 = findViewById(R.id.But1) as Button
        btn2 = findViewById(R.id.But2) as Button
        btn3 = findViewById(R.id.But3) as Button
        btn4 = findViewById(R.id.But4) as Button
        btn5 = findViewById(R.id.But5) as Button
        btn6 = findViewById(R.id.But6) as Button
        btn7 = findViewById(R.id.But7) as Button
        btn8 = findViewById(R.id.But8) as Button
        btn9 = findViewById(R.id.But9) as Button
        btnDEL = findViewById(R.id.BackSpaceAA) as Button
        btnAdd = findViewById(R.id.ButPLUS) as Button
        btnMult = findViewById(R.id.ButMult) as Button
        btnDIV = findViewById(R.id.But4Div) as Button
        btnDOT = findViewById(R.id.ButDot) as Button
        btnClear = findViewById(R.id.ButAbut) as Button
        btnSub = findViewById(R.id.ButSub) as Button
        btnEQ = findViewById(R.id.ButEQ) as Button
        btn0!!.setOnClickListener {
            curr = curr + "0"
            displayOne()
        }
        btn1!!.setOnClickListener {
            curr = curr + "1"
            displayOne()
        }
        btn2!!.setOnClickListener {
            curr = curr + "2"
            displayOne()
        }
        btn3!!.setOnClickListener {
            curr = curr + "3"
            displayOne()
        }
        btn4!!.setOnClickListener {
            curr = curr + "4"
            displayOne()
        }
        btn5!!.setOnClickListener {
            curr = curr + "5"
            displayOne()
        }
        btn6!!.setOnClickListener {
            curr = curr + "6"
            displayOne()
        }
        btn7!!.setOnClickListener {
            curr = curr + "7"
            displayOne()
        }
        btn8!!.setOnClickListener {
            curr = curr + "8"
            displayOne()
        }
        btn9!!.setOnClickListener {
            curr = curr + "9"
            displayOne()
        }
        btnDOT!!.setOnClickListener {
            if (curr!!.isEmpty()) {
                curr = "0."
                dot_insarted = true
            }
            if (dot_insarted == false) {
                curr = "$curr."
                dot_insarted = true
            }
            displayOne()
        }
        btnClear!!.setOnClickListener {
            clear()
            displayOne()
            displayTwo()
        }
        btnDEL!!.setOnClickListener {
            backspace()
            displayOne()
        }
        btnDIV!!.setOnClickListener {
            dot_insarted = false
            if (!curr!!.isEmpty()) {
                if (curr!!.substring(curr!!.length - 1, curr!!.length) == ".") {
                    backspace()
                }
                if (operator_insarted == false) {
                    curr = "$curr % "
                    operator_insarted = true
                }
            }
            displayOne()
        }
        btnMult!!.setOnClickListener {
            dot_insarted = false
            if (!curr!!.isEmpty()) {
                if (curr!!.substring(curr!!.length - 1, curr!!.length) == ".") {
                    backspace()
                }
                if (operator_insarted == false) {
                    curr = "$curr * "
                    operator_insarted = true
                }
            }
            displayOne()
        }
        btnSub!!.setOnClickListener {
            dot_insarted = false
            if (!curr!!.isEmpty()) {
                if (curr!!.substring(curr!!.length - 1, curr!!.length) == ".") {
                    backspace()
                }
                if (operator_insarted == false) {
                    curr = "$curr - "
                    operator_insarted = true
                }
            }
            displayOne()
        }
        btnAdd!!.setOnClickListener {
            dot_insarted = false
            if (!curr!!.isEmpty()) {
                if (curr!!.substring(curr!!.length - 1, curr!!.length) == ".") {
                    backspace()
                }
                if (operator_insarted == false) {
                    curr = "$curr + "
                    operator_insarted = true
                }
            }
            displayOne()
        }
        btnEQ!!.setOnClickListener {
            if (operator_insarted == true && curr!!.substring(
                    curr!!.length - 1,
                    curr!!.length
                ) != " "
            ) {
                val tokens = curr!!.split(" ").toTypedArray()
                when (tokens[1][0]) {
                    '+' -> res =
                        Double.toString(tokens[0].toDouble() + tokens[2].toDouble())
                    '-' -> res =
                        Double.toString(tokens[0].toDouble() - tokens[2].toDouble())
                    '*' -> res =
                        Double.toString(tokens[0].toDouble() * tokens[2].toDouble())
                    '%' -> res =
                        Double.toString(tokens[0].toDouble() / tokens[2].toDouble())
                }
                displayTwo()
            }
        }
    }

    fun displayOne() {
        calculation!!.setText(curr)
    }

    fun displayTwo() {
        calculation!!.setText(res)
    }

    fun clear() {
        curr = ""
        res = ""
        dot_insarted = false
        operator_insarted = false
    }

    fun backspace() {
        if (!curr!!.isEmpty()) {
            if (curr!!.substring(curr!!.length - 1, curr!!.length) == ".") {
                dot_insarted = false
            }
            if (curr!!.substring(curr!!.length - 1, curr!!.length) == " ") {
                curr = curr!!.substring(0, curr!!.length - 3)
                operator_insarted = false
            } else {
                curr = curr!!.substring(0, curr!!.length - 1)
            }
        }
    }
}