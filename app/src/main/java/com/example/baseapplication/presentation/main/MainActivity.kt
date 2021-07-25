package com.example.baseapplication.presentation.main

import android.os.Bundle
import com.example.baseapplication.R
import com.example.core.presentation.base.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }
}