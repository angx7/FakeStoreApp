package com.example.fakestoreapp

import kotlinx.coroutines.*

// Corrutinas en Kotlin
// Ejemplo práctico en consola que muestra cómo ejecutar tareas asíncronas
// usando suspend, async, launch y Dispatchers.

fun main() = runBlocking {
    println("Inicio en el hilo: ${Thread.currentThread().name}")

    val job = launch {
        println("[Launch] Iniciando tarea secundaria...")
        delay(1000)
        println("[Launch] Tarea completada.")
    }

    val usuario = async { obtenerDatos("usuario") }
    val productos = async { obtenerDatos("productos") }

    println("[Async] Resultado usuario: ${usuario.await()}")
    println("[Async] Resultado productos: ${productos.await()}")

    job.join()

    println("Fin en el hilo: ${Thread.currentThread().name}")
}

// --- Función suspend ---
// Simula una operación de red o base de datos
suspend fun obtenerDatos(tipo: String): String = withContext(Dispatchers.IO) {
    println("[obtenerDatos] Consultando $tipo... (hilo: ${Thread.currentThread().name})")
    delay(1500)
    "[obtenerDatos] Datos de $tipo recibidos correctamente."
}
