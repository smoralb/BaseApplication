package com.smb.ft_home.presentation.home.mapper

import com.smb.ft_home.domain.model.BooksList
import com.smb.ft_home.presentation.home.adapter.HomeDataItems.HomeDataItem

interface FirstFragmentMapper {
    fun mapItems(model: BooksList, itemClickListener: (String) -> Unit)
            : List<HomeDataItem>
}

class FirstFragmentMapperImpl : FirstFragmentMapper {

    override fun mapItems(
        model: BooksList,
        itemClickListener: (String) -> Unit
    ): List<HomeDataItem> =
        model.booksList.flatMap { it.booksDetails }.map { bookDetails ->
            HomeDataItem(
                isbn = bookDetails.isbn,
                title = bookDetails.title,
                description = bookDetails.description,
                publisher = bookDetails.publisher,
                onItemClickListener = itemClickListener
            )
        }
}