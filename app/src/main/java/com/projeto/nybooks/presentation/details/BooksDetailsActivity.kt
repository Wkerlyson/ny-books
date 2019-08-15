package com.projeto.nybooks.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.projeto.nybooks.R
import com.projeto.nybooks.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_books_details.*
import kotlinx.android.synthetic.main.include_toolbar.*

class BooksDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_details)

        setupToolbar(toolbarMain, R.string.books_title_detail)

        booksDetailTitle.text = intent.getStringExtra(EXTRA_TITLE)
        booksDetailDescription.text = intent.getStringExtra(EXTRA_DESCRIPTION)
    }

    companion object{

        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntent(context: Context, title: String, description: String): Intent{
            return Intent(context, BooksDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}
