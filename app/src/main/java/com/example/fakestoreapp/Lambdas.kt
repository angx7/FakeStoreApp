package com.example.fakestoreapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// LAMBDA -> Función anónima, sin nombre, que se puede pasar como parámetro a otra función / Closure
// CALLBACKS -> Funciones que se pasan como parámetros a otras funciones

fun main(){
    val a = 10
    val b = 5

    val result = operarNumeros(a, b){ x, y -> x + y }
    println("El resultado de la suma es: $result")
}



fun operarNumeros(
    a: Int,
    b: Int,
    operacion: (Int, Int) -> Int
) : Int {
    return operacion(a, b)
}


fun suma(a: Int, b: Int): Int {
    return a + b
}

fun resta(a: Int, b: Int): Int {
    return a - b
}

fun multiplicacion(a: Int, b: Int): Int {
    return a * b
}

fun division(a: Int, b: Int): Int {
    return a / b
}

@Composable
fun MyColumn() {
    // HomeScreen
    // navController
    Column {
        MyCustomCard(
            onClick = {
                // Acción al hacer clic
                // Navegacion
            }
        )
    }
}

@Composable
fun MyCustomCard(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable{
                // Acción al hacer clic
                onClick()
            }
    ) {  }
}