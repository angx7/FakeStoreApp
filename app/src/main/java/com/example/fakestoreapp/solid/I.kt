package com.example.fakestoreapp.solid

// 4. Principio de Segregación de Interfaces (ISP) Interface Segregation Principle
// LAS INTERFACES DEBEN SER ESPECÍFICAS Y NO OBLIGAR A IMPLEMENTAR MÉTODOS QUE NO SE USAN

// VIOLACIÓN DE PRINCIPIO
interface Worker{
    fun trabajar()
    fun comer()
    fun descansar()
    fun beber()
}

class Persona : Worker{
    override fun trabajar() {
        println("Trabajando")
    }

    override fun comer() {
        println("Comiendo")
    }

    override fun descansar() {
        println("Descansando")
    }

    override fun beber() {
        println("Bebiendo")
    }
}

class Robot : Worker{
    override fun trabajar() {
        println("Trabajando")
    }

    override fun comer() {
        throw Exception("No puedo comer")
    }

    override fun descansar() {
        throw Exception("No puedo descansar")
    }

    override fun beber() {
        throw Exception("No puedo beber")
    }
}

// SOLUCIÓN AL PRINCIPIO
interface Workable{
    fun trabajar()
    fun descansar()
}
interface Eatable{
    fun comer()
}

interface  Drinkable{
    fun beber()
}
class Person: Workable, Eatable, Drinkable{
    override fun trabajar() {
        println("Trabajando")
    }

    override fun comer() {
        println("Comiendo")
    }

    override fun descansar() {
        println("Descansando")
    }

    override fun beber() {
        println("Bebiendo")
    }
}

class RoboEsclavo: Workable{
    override fun trabajar() {
        println("Trabajando")
    }

    override fun descansar() {
        println("Descansando")
    }
}