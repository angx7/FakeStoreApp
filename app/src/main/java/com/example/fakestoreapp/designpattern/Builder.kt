package com.example.fakestoreapp.designpattern

// 2. Builder Pattern
// Nos permite construir objetos complejos paso a paso.

class Report private constructor(
    val title: String,
    val author: String,
    val date: String,
    val pages : List<String>
){
    class Builder{
        private var title: String = ""
        private var author: String = ""
        private var date: String = ""
        private val pages: MutableList<String> = mutableListOf()

        fun title(value: String) : Builder {
            this.title = value
            return this
        }

        fun author(value: String) : Builder {
            this.author = value
            return this
        }

        fun date(value: String) : Builder {
            this.date = value
            return this
        }

        fun addPage(page : String) : Builder {
            this.pages.add(page)
            return this
        }

        fun build(): Report{
            return Report(title,author,date,pages)
        }
    }
}

fun main(){
    val rep = Report.Builder()
        .title("100 años de soledad")
        .author("Gabriel Garcia Marquez")
        .date("1967")
        .addPage("Página 1")
        .addPage("Página 2")
        .addPage("Página 3")
        .build()

    println(rep.toString())
}