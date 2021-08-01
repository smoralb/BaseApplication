package com.example.core.presentation.base

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.core.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity(@LayoutRes private val layoutRes: Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }
}