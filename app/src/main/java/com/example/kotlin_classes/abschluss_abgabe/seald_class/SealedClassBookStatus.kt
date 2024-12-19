package com.example.kotlin_classes.abschluss_abgabe.seald_class;

sealed class BookStatus

data class Available(val title: String, val author: String) : BookStatus()
data class CheckedOut(val title: String, val author: String, val dueDate: String) : BookStatus()
data class Reserved(val title: String, val author: String, val reservedBy: String) : BookStatus()

fun getBookStatus(BookStatus: BookStatus){
    when (BookStatus) {
        is Available -> println("Buch ist verfügbar: ${BookStatus.title} von ${BookStatus.author}")
        is CheckedOut -> println("Buch ist ausgeliehen: ${BookStatus.title} von ${BookStatus.author}, Rückgabe: ${BookStatus.dueDate}")
        is Reserved -> println("Buch ist reserviert: ${BookStatus.title} von ${BookStatus.author}, Reserviert von: ${BookStatus.reservedBy}")
    }
}
