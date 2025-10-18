package com.example.fakestoreapp.designpattern

// 3. Dependency Injection (DI) Pattern
// Permite inyectar dependencias en una clase desde el exterior,
// en lugar de que la clase las cree por sí misma.

interface Storage {

}

class SSD : Storage {

}

class RAM {

}

class Processador {

}

class Fuente {

}

class MB {

}

class HDD : Storage {

}

class Computadora(
    val ram: RAM,
    val storage: Storage,
    val processador: Processador,
    val fuente: Fuente,
    val mb: MB
){
//    val ssd = SSD()
//    val ram = RAM()
//    val processador = Processador()
//    val mb = MB()

}

fun main(){
    val pc = Computadora(
        ram = RAM(),
        storage = HDD(),
        processador = Processador(),
        fuente = Fuente(),
        mb = MB()
    )
    println(pc)
}