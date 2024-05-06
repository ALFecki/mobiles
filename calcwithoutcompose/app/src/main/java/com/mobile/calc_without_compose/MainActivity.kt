package com.mobile.calc_without_compose

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import android.nfc.NfcAdapter.ACTION_TECH_DISCOVERED
import android.nfc.tech.IsoDep
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.Firebase
import com.google.firebase.database.database
import java.util.Locale
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan


class MainActivity : AppCompatActivity() {

    private var nfcAdapter: NfcAdapter? = null

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
    lateinit var themeSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this)?.let { it }

        tvsec = findViewById(R.id.idTVSecondary)
        tvsec.movementMethod = ScrollingMovementMethod()

        tvMain = findViewById(R.id.idTVprimary)
        tvMain.movementMethod = ScrollingMovementMethod()
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
        themeSwitch = findViewById(R.id.idThemeSwitch)

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
            (tvMain.text.toString() + "3.142").also { tvMain.text = it; tvsec.text = it }
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
            if (tvMain.text.toString() == "Infinity") {
                Toast.makeText(this, "Cannot make operations with infinity", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
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
                try {
                    if (tvMain.text.toString() == "Infinity") {
                        Toast.makeText(this, "Cannot make operations with infinity", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    val str: String = tvMain.text.toString()
                    val r = sqrt(str.toDouble())
                    val res = String.format(locale = Locale.US, "%d", r)
                    tvMain.text = res
                    tvsec.text = res
                } catch (e: Exception){
                    Toast.makeText(this, "Not valid number", Toast.LENGTH_SHORT).show()
                }
            }
        }
        bequal.setOnClickListener {
            if (tvMain.text.isEmpty()) {
                Toast.makeText(this, "Not valid number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val str: String = tvMain.text.toString()
            val res = String.format(locale = Locale.US, "%f", evaluate(str))
            tvMain.text = res
            tvsec.text = res
        }

        bac.setOnClickListener {
            tvMain.text = ""
            tvsec.text = ""
            tvMain.scrollTo(0,15)
            tvsec.scrollTo(0,0)
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
                try { if (tvMain.text.toString() == "Infinity") {
                    Toast.makeText(this, "Cannot make operations with infinity", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                    val d: Double = tvMain.getText().toString().toDouble()
                    val res = String.format(locale = Locale.US, "%d", d.pow(2.0))
                    tvMain.text = res
                    tvsec.text = res
                    "$d²".also { tvsec.text = it }

                } catch (e: Exception){
                    Toast.makeText(this, "Not valid number", Toast.LENGTH_SHORT).show()
                }
            }
        }
        bfact.setOnClickListener {
            if (tvMain.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            } else {
                try {
                    if (tvMain.text.toString() == "Infinity") {
                        Toast.makeText(this, "Cannot make operations with infinity", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    val value: Int = tvMain.text.toString().toFloat().toInt()
                    if (value > 5000) {
                        Toast.makeText(this, "Value is too big", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    val fact: Int = factorial(value)
                    val res = String.format(locale = Locale.US, "%d", fact)
                    tvMain.text = res
                    tvsec.text = res
                    "$value`!".also { tvsec.text = it }
                } catch (e: Exception){
                    Toast.makeText(this, "Not valid number", Toast.LENGTH_SHORT).show()
                }
            }

        }
        var isProcessingSwitch = false

        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
//            val database = Firebase.database
//            val ref = database.getReference("theme")
            if (isProcessingSwitch) {
                return@setOnCheckedChangeListener
            }
            isProcessingSwitch = true

            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                themeSwitch.isChecked = true
//                ref.setValue("dark")
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                themeSwitch.isChecked = false
//                ref.setValue("light")
            }

            isProcessingSwitch = false
        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        themeSwitch.isChecked = false
//        val database = Firebase.database
//        val ref = database.getReference("theme")
//        ref.get().addOnSuccessListener {
//            if (it.value == "dark") {
//                themeSwitch.isChecked = true
//            }
//        }
    }

    private fun factorial(n: Int): Int {
        return try {
            if (n == 1 || n == 0) 1 else n * factorial(n - 1)
        } catch (e: Exception) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            0
        }
    }

    override fun onResume() {
        super.onResume()

        NfcAdapter.getDefaultAdapter(this)?.let { nfcAdapter ->
            val launchIntent = Intent(this, this.javaClass)
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)

            val pendingIntent = PendingIntent.getActivity(
                this, 0, launchIntent,
                PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            val filters = arrayOf(IntentFilter(ACTION_TECH_DISCOVERED))
            val techTypes = arrayOf(arrayOf(IsoDep::class.java.name))

            nfcAdapter.enableForegroundDispatch(
                this, pendingIntent, filters, techTypes
            )
        }
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "NFC tag equal!", Toast.LENGTH_SHORT).show()
        bequal.performClick()
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
