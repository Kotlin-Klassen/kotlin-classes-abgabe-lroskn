package com.example.kotlin_classes.abschluss_abgabe.nested_inner

import com.example.kotlin_classes.abschluss_abgabe.data.DataClassBook
import com.example.kotlin_classes.abschluss_abgabe.enums.Genre
import com.example.kotlin_classes.abschluss_abgabe.seald_class.Available
import com.example.kotlin_classes.abschluss_abgabe.seald_class.CheckedOut
import com.example.kotlin_classes.abschluss_abgabe.seald_class.Reserved

class Library {
    class LibraryAddress(val street: String, val city: String, val zipCode: String) {
        fun printAddress() = "Address: $street, $city, $zipCode"
    }

    private val books = mutableListOf<DataClassBook>()

    inner class LibraryMember(val name: String, val memberID: String) {
        fun checkoutBook(book: DataClassBook, dueDate: String) {
            book.status = CheckedOut(book.title, book.author, dueDate)
        }

        fun reserveBook(book: DataClassBook) {
            book.status = Reserved(book.title, book.author, name)
        }
    }

    fun addBook(book: DataClassBook) {
        books.add(book)
    }

    fun searchBook(title: String, author: String): DataClassBook? {
        return books.find { it.title == title && it.author == author }
    }

    fun printBookStatus() {
        books.forEach { book ->
            println("Title: ${book.title}, Author: ${book.author}, Status: ${book.status}")
        }
    }
}

fun main() {
    // Erstelle eine Instanz der Library
    val library = Library()

    // Füge verschiedene Bücher hinzu
    val book1 = DataClassBook("1984", "George Orwell", Genre.FICTION, Available("1984", "George Orwell"))
    val book2 = DataClassBook("A Brief History of Time", "Stephen Hawking", Genre.SCIENCE, Available("A Brief History of Time", "Stephen Hawking"))
    val book3 = DataClassBook("The Cat in the Hat", "Dr. Seuss", Genre.CHILDREN, Available("The Cat in the Hat", "Dr. Seuss"))

    library.addBook(book1)
    library.addBook(book2)
    library.addBook(book3)

    // Füge eine Adresse der Bibliothek hinzu und gib sie aus
    val address = Library.LibraryAddress("Main Street 123", "Berlin", "10115")
    println(address.printAddress())

    // Erstelle ein Mitglied
    val member = library.LibraryMember("Max Mustermann", "M123")

    // Lasse das Mitglied ein Buch ausleihen
    member.checkoutBook(book1, "2024-01-15")

    // Lasse das Mitglied ein anderes Buch reservieren
    member.reserveBook(book2)

    // Gib den aktuellen Status der Bücher aus
    println("\nAktueller Status der Bücher:")
    library.printBookStatus()
}