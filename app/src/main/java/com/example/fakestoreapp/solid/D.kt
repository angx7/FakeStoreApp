package com.example.fakestoreapp.solid

// 5. Principio de Inversión de Dependencias (DIP) Dependency Inversion Principle
// Las clases deben de depender de abstracciones y no de construcciones

// VIOLACIÓN DE PRINCIPIO

class  MySQLDatabase{
    fun save(data: String){
        println("Guardando en MySQL: $data")
    }
}

class MongoDBDatabase{
    fun save(data: String){
        println("Guardando en MongoDB: data")
    }
}

class UserManager{
    val database = MongoDBDatabase()

    fun saveUser(data: String){
        database.save("2.o")
    }
}

// SOLUCIÓN AL PRINCIPIO SOLID

interface Database{
    fun save(data: String)
}

class MySQLDatabaseImpl: Database{
    override fun save(data: String) {
        println("Guardando en MySQL: $data")
    }
}

class MongoDBDatabaseImpl: Database{
    override fun save(data: String) {
        println("Guardando en MongoDB: $data")
    }
}
// INYECCIÓN DE DEPENDENCIAS
// PASAR POR EL CONSTRUCTOR LA DEPENDENCIA
// REPOSITORY
class UserRepository(private val database: Database){
    fun save(data: String){
        database.save(data)
    }
}

fun main (){
    val mongo = MySQLDatabaseImpl()
    val userRepository = UserRepository(mongo)
    userRepository.save("1.0")
}