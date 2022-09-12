package com.smb.ft_home

import android.os.Bundle
import com.example.core.presentation.base.BaseActivity
import com.smb.ft_home.R

class MainActivity : BaseActivity(
    layoutRes = R.layout.activity_main
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }
}