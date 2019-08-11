package com.projeto.nybooks.data.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookDetailsResponse(
    val title: String,
    val author: String,
    val description: String
)