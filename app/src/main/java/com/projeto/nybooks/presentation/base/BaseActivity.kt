package com.projeto.nybooks.presentation.base

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity: AppCompatActivity() {

    protected fun setupToolbar(toolbar: Toolbar, titleIdRes: Int, showBackButton: Boolean = false){
        toolbar.title = getString(titleIdRes)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(showBackButton)

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}