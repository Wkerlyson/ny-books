package com.projeto.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projeto.nybooks.data.model.Book

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(){
        booksLiveData.value = createFakesBooks()
    }

    private fun createFakesBooks(): List<Book> {
        return listOf(
            Book("Title 1", "Author 2"),
            Book("Title 2", "Author 2"),
            Book("Title 3", "Author 3")
        )
    }
}