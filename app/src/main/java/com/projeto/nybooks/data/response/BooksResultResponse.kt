package com.projeto.nybooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BooksResultResponse(
    @Json(name = "book_details")
    val bookDetails: List<BookDetailsResponse>
)