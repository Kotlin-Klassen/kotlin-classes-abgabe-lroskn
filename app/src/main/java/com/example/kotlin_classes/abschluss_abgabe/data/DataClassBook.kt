package com.example.kotlin_classes.abschluss_abgabe.data

import com.example.kotlin_classes.abschluss_abgabe.enums.Genre
import com.example.kotlin_classes.abschluss_abgabe.seald_class.BookStatus

data class DataClassBook (
    var title: String,
    var author: String,
    var genre: Genre,
    var status: BookStatus
)