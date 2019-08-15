package com.projeto.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projeto.nybooks.R
import com.projeto.nybooks.data.ApiService
import com.projeto.nybooks.data.model.Book
import com.projeto.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun getBooks(){
        ApiService.service.getBooks().enqueue(object: Callback<BookBodyResponse> {

            override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                when {
                    response.isSuccessful -> {
                        val books: MutableList<Book> =  mutableListOf()

                        response.body()?.let { bookBodyResponse ->
                            for (result in bookBodyResponse.bookResults){
                                val book = result.bookDetails[0].getBookModel()

                                books.add(book)
                            }

                            booksLiveData.value = books
                            viewFlipperLiveData.value = Pair(VIEW_FLIPPER_BOOKS, null)
                        }
                    }
                    response.code() == 401 -> viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_401)

                    else -> viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_400_generic)
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_500_generic)
            }

        })
    }

    companion object{
        private const val VIEW_FLIPPER_BOOKS = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }
}