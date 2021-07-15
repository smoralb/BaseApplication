package com.example.baseapplication.presentation.main

import android.os.Bundle
import com.example.baseapplication.R
import com.example.baseapplication.presentation.core.base.BaseActivity

class MainActivity : BaseActivity(
    layoutRes = R.layout.activity_main,
    hastOptionsMenu = true) {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }
}