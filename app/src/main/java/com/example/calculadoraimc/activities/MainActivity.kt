package com.example.calculadoraimc.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.calculadoraimc.R
import com.google.android.material.slider.Slider
import kotlin.math.roundToInt


// El índice de masa corporal (IMC) es el peso de una persona en kilogramos dividido por
// el cuadrado de la estatura en metros.
class MainActivity : AppCompatActivity() {

    lateinit var userEditAltura:EditText
    lateinit var userEditPeso:EditText
    lateinit var userEditEdad:EditText
    lateinit var userEditImc:TextView
    lateinit var btnCalc:AppCompatButton
    lateinit var btnMasEdad:ImageButton
    lateinit var btnMenosEdad:ImageButton
    lateinit var sliderPeso:Slider
    lateinit var textDesImc:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userEditAltura = findViewById(R.id.edittAltura)
        userEditPeso = findViewById(R.id.editTPeso)
        userEditEdad= findViewById(R.id.editTEdad)
        userEditImc= findViewById(R.id.textvImcValue)
        btnCalc= findViewById(R.id.btn_Calcular)
        btnMasEdad=findViewById(R.id.imageBMas)
        btnMenosEdad=findViewById(R.id.imageBMenos)
        sliderPeso=findViewById(R.id.sliderPeso)
        textDesImc=findViewById(R.id.textDesImc)

        btnCalc.setOnClickListener{calcularImc()}
        btnMasEdad.setOnClickListener{incrementaEdad()}
        btnMenosEdad.setOnClickListener{decrementaEdad()}
        sliderPeso.addOnChangeListener { sli: Slider, value: Float, fromUser: Boolean ->
            userEditPeso.setText(value.toInt().toString())
        }


    }
        private fun calcularImc() {
            var altura:Double=userEditAltura.text.toString().toDouble()
            var peso:Double=userEditPeso.text.toString().toDouble()
            var imc:Double

            altura=altura/100
            altura=altura*altura
            imc=peso/altura
            imc=(imc * 100.0).roundToInt()/ 100.0
            userEditImc.setText(imc.toString())
            when (imc){
                in 1.00..18.50 -> textDesImc.text="Peso Bajo"
                in 18.50..24.99 -> textDesImc.text="Peso óptimo"
                in 24.99 .. 29.99 -> textDesImc.text="Sobrepeso"
                in 29.99..34.99 -> textDesImc.text="Obesidad G1"
                in 34.99..39.99 -> textDesImc.text="Obesidad G2"
                in 39.99..50.00 -> textDesImc.text="Obesidad G3"
                else -> textDesImc.text="Fuera de rango"
            }
        }
        private fun incrementaEdad() {
            var edad:Int=userEditEdad.text.toString().toInt()
            edad++
            userEditEdad.setText(edad.toString())
        }

        private fun decrementaEdad() {
            var edad:Int=userEditEdad.text.toString().toInt()
            edad--
            userEditEdad.setText(edad.toString())
        }
}
