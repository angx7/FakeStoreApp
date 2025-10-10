package com.example.fakestoreapp.solid

// 1. Principio de Responsabilidad Única (SRP) Single Responsibility Principle
// Cada clase debe tener una sola acción o razón de existir

// VIOLACIÓN DE PRINCIPIO

class Reportes{
    fun generarReportes(){}
    fun generarReportePorFecha(){}
    fun guardarReporte(){}
    fun guardarReporteEnLaNube(){}
    fun generarReportePorPDF(){}
}

// SOLUCIÓN AL PRINCIPIO
class GeneradorDeReportes{
    fun generarReportes(){}
    fun generarReportePorFecha(){}
    fun generarReportePorPDF(){}
}

class AlmacenadorDeReportes{
    fun guardarReporte(){}
    fun guardarReporteEnLaNube(){}
    fun guardarBackup(){}
}