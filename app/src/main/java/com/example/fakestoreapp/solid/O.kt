package com.example.fakestoreapp.solid

// 2. Principio de Abierto/Cerrado (OCP) Open/Closed Principle
// EL CODIGO, LAS CLASES DEBEN ESTAR ABIERTAS A EXTENSIONES PERO CERRADAS A MODIFICACIONES

// VIOLACIÓN DE PRINCIPIO
class DiscountCalculator {
    fun calculate(price: Double, type: String): Double {
        val result = if (type == "STUDENT") price * 0.9 else
            if (type == "TEACHER") price * 0.8 else price
        return result
    }
}

// SOLUCIÓN AL PRINCIPIO
interface Discount{
    fun apply(price: Double): Double
}

class StudentDiscount: Discount{
    override fun apply(price: Double): Double {
        return price * 0.9
    }
}

class TeacherDiscount: Discount{
    override fun apply(price: Double): Double {
        return price * 0.8
    }
}