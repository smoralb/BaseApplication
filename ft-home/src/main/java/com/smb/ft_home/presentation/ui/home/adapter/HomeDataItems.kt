package com.smb.ft_home.presentation.ui.home.adapter

import com.example.core.presentation.adapters.BaseItem

sealed class HomeDataItems : BaseItem {
    data class HomeDataItem(
        val isbn: String,
        val title: String,
        val description: String,
        val publisher: String,
        val onItemClickListener: (String) -> Unit
    ) : HomeDataItems() {
        override fun onItemClick() {
            onItemClickListener(isbn)
        }
    }
}