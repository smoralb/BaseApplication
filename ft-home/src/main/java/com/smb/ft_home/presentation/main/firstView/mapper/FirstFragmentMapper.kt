package com.smb.ft_home.presentation.main.firstView.mapper

import com.smb.ft_home.domain.model.BooksList
import com.smb.ft_home.presentation.main.firstView.adapter.SampleDataItems.SampleDataItem

interface FirstFragmentMapper {
    fun mapItems(model: BooksList, itemClickListener: (String) -> Unit)
            : List<SampleDataItem>
}

class FirstFragmentMapperImpl : FirstFragmentMapper {

    override fun mapItems(
        model: BooksList,
        itemClickListener: (String) -> Unit
    ): List<SampleDataItem> =
        model.booksList.flatMap { it.booksDetails }.map { bookDetails ->
            SampleDataItem(
                isbn = bookDetails.isbn,
                title = bookDetails.title,
                description = bookDetails.description,
                publisher = bookDetails.publisher,
                onItemClickListener = itemClickListener
            )
        }
}