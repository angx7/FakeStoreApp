package com.example.fakestoreapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

// Corrutinas, permiten ejecutar código asíncrono de manera secuencial

fun main() {
//    println("Pintando text")
    // Espacio donde trabajar - Scope
//    GlobalScope.launch {
//        cLaunch()
//    }
    // Corrutina - Solo pruebas
//    runBlocking {
//        cLaunch()
//    }
//    println("Pintando column")
//
//    println("Creando cards")

//    cAsync()
    println("Inicio en el hilo: ${Thread.currentThread().name}")
    cWithContext()
    println("Fin en el hilo: ${Thread.currentThread().name}")

}

fun cLaunch(){
    GlobalScope.launch {
        println("Entrando en launch")
        delay(2000)
        println("Saliendo de launch")
    }
}

// 3. Corrutina con async/await
fun cAsync(){
    runBlocking {
        val result = async {
            println("Consultando API")
            delay(5000)
            println("Respuesta API")
            "Hola desde API"
        }
        println("El resultado es: ${result.await()}")
    }
}

// 4. Corrutina - WithContext
// Permite cambiar de contexto (hilo) dentro de una corrutina
// Dispatchers.Main -> Hilo principal (UI)
// Dispatchers.IO -> Hilo para operaciones de entrada/salida (red, base de datos)
// Dispatchers.Default -> Hilo para operaciones pesadas (cálculos, procesamiento)
// Dispatchers.Unconfined -> No está confinado a ningún hilo específico
// Se usa dentro de una corrutina

fun cWithContext(){
    runBlocking {
        val result = withContext(Dispatchers.IO){
            println("withContext en el hilo: ${Thread.currentThread().name}")

            println("Trayendo datos de la API")
            delay(5000)
            println("Datos recibidos de la API")
            "{ age: 30 }"
        }



        // No necesita await, ya que withContext es secuencial
        println("El resultado es: $result")
    }
}