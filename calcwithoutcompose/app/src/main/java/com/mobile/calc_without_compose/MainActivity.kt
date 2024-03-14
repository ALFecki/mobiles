package com.mobile.calc_without_compose

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

class MainActivity : AppCompatActivity() {

    lateinit var tvsec: TextView
    lateinit var tvMain: TextView
    lateinit var bac: Button
    lateinit var bc: Button
    lateinit var bbrac1: Button
    lateinit var bbrac2: Button
    lateinit var bsin: Button
    lateinit var bcos: Button
    lateinit var btan: Button
    lateinit var blog: Button
    lateinit var bln: Button
    lateinit var bfact: Button
    lateinit var bsquare: Button
    lateinit var bsqrt: Button
    lateinit var binv: Button
    lateinit var b0: Button
    lateinit var b9: Button
    lateinit var b8: Button
    lateinit var b7: Button
    lateinit var b6: Button
    lateinit var b5: Button
    lateinit var b4: Button
    lateinit var b3: Button
    lateinit var b2: Button
    lateinit var b1: Button
    lateinit var bpi: Button
    lateinit var bmul: Button
    lateinit var bminus: Button
    lateinit var bplus: Button
    lateinit var bequal: Button
    lateinit var bdot: Button
    lateinit var bdiv: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvsec = findViewById(R.id.idTVSecondary)
        tvMain = findViewById(R.id.idTVprimary)
        bac = findViewById(R.id.bac)
        bc = findViewById(R.id.bc)
        bbrac1 = findViewById(R.id.bbrac1)
        bbrac2 = findViewById(R.id.bbrac2)
        bsin = findViewById(R.id.bsin)
        bcos = findViewById(R.id.bcos)
        btan = findViewById(R.id.btan)
        blog = findViewById(R.id.blog)
        bln = findViewById(R.id.bln)
        bfact = findViewById(R.id.bfact)
        bsquare = findViewById(R.id.bsquare)
        bsqrt = findViewById(R.id.bsqrt)
        binv = findViewById(R.id.binv)
        b0 = findViewById(R.id.b0)
        b9 = findViewById(R.id.b9)
        b8 = findViewById(R.id.b8)
        b7 = findViewById(R.id.b7)
        b6 = findViewById(R.id.b6)
        b5 = findViewById(R.id.b5)
        b4 = findViewById(R.id.b4)
        b3 = findViewById(R.id.b3)
        b2 = findViewById(R.id.b2)
        b1 = findViewById(R.id.b1)
        bpi = findViewById(R.id.bpi)
        bmul = findViewById(R.id.bmul)
        bminus = findViewById(R.id.bminus)
        bplus = findViewById(R.id.bplus)
        bequal = findViewById(R.id.bequal)
        bdot = findViewById(R.id.bdot)
        bdiv = findViewById(R.id.bdiv)

        b1.setOnClickListener {
            (tvMain.text.toString() + "1").also { tvMain.text = it }
        }
        b2.setOnClickListener {
            (tvMain.text.toString() + "2").also { tvMain.text = it }
        }
        b3.setOnClickListener {
            (tvMain.text.toString() + "3").also { tvMain.text = it }
        }
        b4.setOnClickListener {
            (tvMain.text.toString() + "4").also { tvMain.text = it }
        }
        b5.setOnClickListener {
            (tvMain.text.toString() + "5").also { tvMain.text = it }
        }
        b6.setOnClickListener {
            (tvMain.text.toString() + "6").also { tvMain.text = it }
        }
        b7.setOnClickListener {
            (tvMain.text.toString() + "7").also { tvMain.text = it }
        }
        b8.setOnClickListener {
            (tvMain.text.toString() + "8").also { tvMain.text = it }
        }
        b9.setOnClickListener {
            (tvMain.text.toString() + "9").also { tvMain.text = it }
        }
        b0.setOnClickListener {
            (tvMain.text.toString() + "0").also { tvMain.text = it }
        }
        bdot.setOnClickListener {
            (tvMain.text.toString() + ".").also { tvMain.text = it }
        }
        bplus.setOnClickListener {
            (tvMain.text.toString() + "+").also { tvMain.text = it }
        }
        bdiv.setOnClickListener {
            (tvMain.text.toString() + "/").also { tvMain.text = it }
        }
        bbrac1.setOnClickListener {
            (tvMain.text.toString() + "(").also { tvMain.text = it }
        }
        bbrac2.setOnClickListener {
            (tvMain.text.toString() + ")").also { tvMain.text = it }
        }
        bpi.setOnClickListener {
            (tvMain.text.toString() + "3.142").also { tvMain.text = it }
            tvsec.text = (bpi.text.toString())
        }
        bsin.setOnClickListener {
            if (tvMain.text.last().isDigit()) {
                (tvMain.text.toString() + "*").also { tvMain.text = it }
            }
            (tvMain.text.toString() + "sin").also { tvMain.text = it }
        }
        bcos.setOnClickListener {
            if (tvMain.text.last().isDigit()) {
                (tvMain.text.toString() + "*").also { tvMain.text = it }
            }
            (tvMain.text.toString() + "cos").also { tvMain.text = it }
        }
        btan.setOnClickListener {
            if (tvMain.text.last().isDigit()) {
                (tvMain.text.toString() + "*").also { tvMain.text = it }
            }
            (tvMain.text.toString() + "tan").also { tvMain.text = it }
        }
        binv.setOnClickListener {
            (tvMain.text.toString() + "^" + "(-1)").also { tvMain.text = it }
        }
        bln.setOnClickListener {
            (tvMain.text.toString() + "ln").also { tvMain.text = it }
        }
        blog.setOnClickListener {
            (tvMain.text.toString() + "log").also { tvMain.text = it }
        }

        bminus.setOnClickListener {
            if (tvMain.text.toString().last() != '-') {
                (tvMain.text.toString() + "-").also { tvMain.text = it }
            }
        }
        bmul.setOnClickListener {
            if (tvMain.text.toString().last() != '*') {
                (tvMain.text.toString() + "*").also { tvMain.text = it }
            }
        }
        bsqrt.setOnClickListener {
            if (tvMain.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            } else {
                val str: String = tvMain.text.toString()
                val r = sqrt(str.toDouble())
                tvMain.text = r.toString()
            }
        }
        bequal.setOnClickListener {
            val str: String = tvMain.text.toString()
            tvMain.text = evaluate(str).toString()
            tvsec.text = str
        }

        bac.setOnClickListener {
            tvMain.text = ""
            tvsec.text = ""
        }
        bc.setOnClickListener {
            var str: String = tvMain.text.toString()
            if (str != "") {
                str = str.substring(0, str.length - 1)
                tvMain.text = str
            }
        }
        bsquare.setOnClickListener {
            if (tvMain.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            } else {
                val d: Double = tvMain.getText().toString().toDouble()

                tvMain.text = d.pow(2.0).toString()

                "$d²".also { tvsec.text = it }
            }
        }
        bfact.setOnClickListener {
            if (tvMain.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            } else {
                val value: Int = tvMain.text.toString().toFloat().toInt()
                val fact: Int = factorial(value)
                tvMain.text = fact.toString()
                "$value`!".also { tvsec.text = it }
            }

        }

    }

    private fun factorial(n: Int): Int {
        return if (n == 1 || n == 0) 1 else n * factorial(n - 1)
    }

    private fun evaluate(str: String): Double {
        return object : Any() {
            var pos = -1
            var ch = 0

            fun nextChar() {
                ch = if (++pos < str.length) str[pos].code else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.code) nextChar()

                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.code)) x += parseTerm()
                    else if (eat('-'.code)) x -= parseTerm()
                    else return x
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.code)) x *= parseFactor()
                    else if (eat('/'.code)) x /= parseFactor()
                    else return x
                }
            }


            fun parseFactor(): Double {

                if (eat('+'.code)) return parseFactor()
                if (eat('-'.code)) return -parseFactor()
                var x: Double

                val startPos = pos

                if (eat('('.code)) {
                    x = parseExpression()
                    eat(')'.code)
                } else if (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) {

                    while (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) nextChar()
                    x = str.substring(startPos, pos).toDouble()
                } else if (ch >= 'a'.code && ch <= 'z'.code) {
                    while (ch >= 'a'.code && ch <= 'z'.code) nextChar()
                    val func = str.substring(startPos, pos)
                    x = parseFactor()
                    x =
                        when (func) {
                            "sqrt" -> sqrt(x)
                            "sin" -> sin(Math.toRadians(x))
                            "cos" -> cos(Math.toRadians(x))

                            "tan" -> tan(Math.toRadians(x))

                            "log" -> log10(x)

                            "ln" -> ln(x)
                            else -> throw RuntimeException(
                                "Unknown function: $func"
                            )
                        }
                } else {
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }
                if (eat('^'.code)) x = x.pow(parseFactor())
                return x
            }
        }.parse()
    }
}
