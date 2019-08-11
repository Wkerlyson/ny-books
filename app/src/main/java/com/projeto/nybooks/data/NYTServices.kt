package com.projeto.nybooks.data

import com.projeto.nybooks.data.response.BookBodyResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "4ke87uZRiAzz8Yyks0mpk9f9395X4oAL" ,
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}