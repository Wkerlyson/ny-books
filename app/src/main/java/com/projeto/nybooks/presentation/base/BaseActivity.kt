package com.projeto.nybooks.presentation.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity: AppCompatActivity() {

    protected fun setupToolbar(toolbar: Toolbar, titleIdRes: Int){
        toolbar.title = getString(titleIdRes)
        setSupportActionBar(toolbar)
    }

}