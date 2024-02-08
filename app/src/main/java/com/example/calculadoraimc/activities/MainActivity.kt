package com.example.calculadoraimc.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.calculadoraimc.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userEditText:EditText =findViewById(R.id.edittAltura)

        val btnCalc:AppCompatButton=findViewById(R.id.btn_Calcular)

        btnCalc.setOnClickListener({userEditText.setText("Has pulsado calcular")})

        // El índice de masa corporal (IMC) es el peso de una persona en kilogramos dividido por
        // el cuadrado de la estatura en metros.
    }
}