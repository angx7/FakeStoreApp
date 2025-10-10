package com.example.fakestoreapp.solid

// 3. Principio de Sustitución de Liskov (LSP) Liskov Substitution Principle
// LAS CLASES HIJAS (HERENCIA) DEBEN PODER REEMPLAZAR A LOS PADRES SIN QUE EL PROGRAMA SE ROMPA

// MAL EJEMPLO
// ABSTRACT CLASS -> NO PUEDEN IMPLEMENTAR METODOS
// OPEN CLASS -> PUEDEN IMPLEMENTAR METODOSZ

//open class Bird{
//    open fun fly() = println("Flying")
//}
//
//class Penguin: Bird(){
//    override fun fly() {
//        throw Exception("I can't fly")
//    }
//}
// SOLUCIÓN AL PRINCIPIO

interface Bird{
    fun eat()
}

interface FlyingBird: Bird{
    fun fly()
}

class Penguin: Bird{
    override fun eat() {
        println("Eating")
    }
}

class Eagle: FlyingBird{
    override fun eat() {
        println("Eating")
    }

    override fun fly() {
        println("Flying")
    }
}