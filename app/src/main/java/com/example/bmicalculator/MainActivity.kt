package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var BMIImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BMIImage = findViewById(R.id.imageViewProfile)

        buttonCalculate.setOnClickListener{
            calculateBMI()
        }

        buttonReset.setOnClickListener {
            resetInput()
        }

    }
     fun calculateBMI() {
         //retrieve user's input
        val getHeight: EditText = findViewById(R.id.editTextHeight)
        val getWeight: EditText = findViewById(R.id.editTextWeight)
        val viewBMI : TextView = findViewById(R.id.textViewBMI)

        //convert to double
        val height = (getHeight.text.toString().toDouble())/100
        val weight = getWeight.text.toString().toDouble()

        //calculate the bmi
        val resultBMI: Double = weight/(height*height)

        val BMI = String.format("%.1f",resultBMI)

        viewBMI.setText("BMI :"+ String.format(BMI))

        //image
        if(resultBMI < 18.5){
            BMIImage.setImageResource(R.drawable.under)
        }else if(resultBMI > 24.9){
            BMIImage.setImageResource(R.drawable.over)
        }else if(resultBMI >= 18.5 || resultBMI <= 24.9){
            BMIImage.setImageResource(R.drawable.normal)
        }
    }

    fun resetInput() {
        val height: EditText = findViewById(R.id.editTextHeight)
        val weight: EditText = findViewById(R.id.editTextWeight)
        val bmi : TextView = findViewById(R.id.textViewBMI)

        height.text.clear()
       weight.text.clear()
        BMIImage.setImageResource(R.drawable.empty)
        bmi.setText("BMI :")
    }
}
