package com.example.kotlin_classes.abschluss_abgabe.enums

enum class Genre(val description: String) {
    FICTION("Fictional stories and novels"),
    NON_FICTION("Real life stories and situations"),
    SCIENCE("Scientific discoveries and research"),
    HISTORY("Past events and events in the future"),
    CHILDREN("Stories for children and young adults");

    fun printDescription() {
        println(description)
    }
}