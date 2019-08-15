package com.projeto.nybooks.data.response

import com.projeto.nybooks.data.model.Book
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookDetailsResponse(
    val title: String,
    val author: String,
    val description: String
){
    fun getBookModel() = Book(
        title = this.title,
        author = this.author,
        description = this.description
    )
}