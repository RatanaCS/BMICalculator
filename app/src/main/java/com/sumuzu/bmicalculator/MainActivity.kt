package com.sumuzu.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var h = findViewById<EditText>(R.id.etHeight)
        var w = findViewById<EditText>(R.id.etWeight)

        btCalcullate.setOnClickListener {
            calculate(h.text.toString(), w.text.toString())
        }


    }

    fun calculate(h :String, w: String){

        if( h.isNullOrEmpty() || w.isNullOrEmpty()){
            Toast.makeText(this@MainActivity, "Mohon untuk diisi Height dan Weight Anda!!", Toast.LENGTH_LONG).show()
        }else {

            var bmi: Double = w.toInt() / (h.toInt() * h.toInt() * 0.0001)

            if (bmi < 18.5) {
                tvResult.text = "Under Weight / Kurus"
            } else if (bmi >= 18.5 && bmi < 25 ) {
                tvResult.text = "Berat Badan Ideal / Normal"
            } else if (25 <= bmi && 30 > bmi) {
                tvResult.text = "Over Weight / Kegemukan "
            } else {
                tvResult.text = "Obesitas"
            }

        }

    }
}