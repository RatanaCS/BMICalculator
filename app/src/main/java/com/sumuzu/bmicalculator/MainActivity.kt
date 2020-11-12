package com.sumuzu.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btCalcullate.setOnClickListener {
            calculate()
        }


    }

    public fun calculate(){
        var heightStr: String = etHeight.text.toString()
        var weightStr: String= etWeight.text.toString()

        tvResult.text = ""

        var height = heightStr.toDouble()
        var weight = weightStr.toDouble()

        if(etHeight.text.isNullOrEmpty() || etWeight.text.isNullOrEmpty()){
            Toast.makeText(this@MainActivity, "Mohon untuk diisi Height dan Weight Anda!!", Toast.LENGTH_LONG).show()
        }else {

            var bmi: Double = weight / (height * height * 0.0001)

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