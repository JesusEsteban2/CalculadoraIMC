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

        btnCalc.setOnClickListener{calcularImc()}
        btnMasEdad.setOnClickListener{incrementaEdad()}
        btnMenosEdad.setOnClickListener{decrementaEdad()}
        sliderPeso.addOnChangeListener { sli: Slider, value: Float, fromUser: Boolean ->
            userEditPeso.setText(value.toInt().toString())
        }

        //val intent:Intent=Intent(this,DetailActivitY::class.java)
        // intent.putExtra("EXTRA_NAME", name)
        // startActivity(intent)
        // En el otro Layout recojo el parámetro con
        // var nameExtra=intent.get.StringExtra("EXTRA_NAME") ?: "usuario"
        //Ver operador Elvis.

    }
        private fun calcularImc() {
            var altura:Double=userEditAltura.text.toString().toDouble()
            var peso:Double=userEditPeso.text.toString().toDouble()
            var imc:Double=0.00

            altura=altura/100
            altura=altura*altura
            imc=peso/altura
            imc=(imc * 100.0).roundToInt()/ 100.0
            userEditImc.setText(imc.toString())
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
