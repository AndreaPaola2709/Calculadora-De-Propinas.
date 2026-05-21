package com.andrealargo.calculadora_de_propinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andrealargo.calculadora_de_propinas.ui.theme.CalculadoradepropinasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CalculadoraDePropinas()


        }
    }
}

@Composable

fun CalculadoraDePropinas(){

    //Column = apila  los elementos principales
    //Modifier = modifica el comportamiento o las apariencias del elemento composable
    //fillMaxSize() = produce que el Column utilize todo el espacio disponible en el contenedor padre
    //padding(20.dp) = añade un espacio de 20 dp alrededor del Column, en donde se crea un margen de manera interna
    //dp = density independent pixels, unidad de medida adaptable a diferentes densidades de pantallas

    var cantidadCuenta by remember {
        mutableStateOf("")}

    var porcentDePropina by remember{
        mutableStateOf("")
    }

    var resp by remember {
        mutableStateOf(0.0)
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        Text(
            text = "Calculadora de Propinas",
            fontSize = 24.sp //sp scale independent pixels, unidad de medida adaptable
        )

        //Espacio entre elementos
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = cantidadCuenta,
            onValueChange = {
                cantidadCuenta = it

            },

            label = {
                Text("Escriba el valor de su cuenta")
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = porcentDePropina,
            onValueChange = {
                porcentDePropina = it
            },

            label = {
                Text("Escriba el % de la propina")
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val valor = cantidadCuenta.toDoubleOrNull() ?: 0.0
                val porcentaje = porcentDePropina.toDoubleOrNull() ?: 0.0

                resp = valor * porcentaje / 100
            }
        ) {
 


