package com.smb.ft_home.presentation.details.mapper

import com.smb.ft_home.domain.model.BookDetails
import com.smb.ft_home.domain.model.BooksList

interface DetailsUiMapper {
    fun mapItems(isbn: String, model: BooksList): BookDetails
}

class DetailsUiMapperImpl : DetailsUiMapper {

    override fun mapItems(isbn: String, model: BooksList): BookDetails {
        val details = model.booksList.flatMap { it.booksDetails }.find { it.isbn == isbn }

        return BookDetails(
            isbn = details?.isbn.orEmpty(),
            title = details?.title.orEmpty(),
            description = details?.description.orEmpty(),
            publisher = details?.publisher.orEmpty(),
            author = details?.author.orEmpty(),
            contributor = details?.contributor.orEmpty(),
            price = details?.price ?: 0.0f
        )
    }
}