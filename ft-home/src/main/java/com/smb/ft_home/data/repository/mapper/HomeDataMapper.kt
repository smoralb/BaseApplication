package com.smb.ft_home.data.repository.mapper

import com.smb.ft_home.data.entity.BookDetailsEntity
import com.smb.ft_home.data.entity.BookItemEntity
import com.smb.ft_home.data.entity.BooksResultEntity
import com.smb.ft_home.domain.model.Book
import com.smb.ft_home.domain.model.BookDetails
import com.smb.ft_home.domain.model.BooksList

interface HomeDataMapper {

    fun toDomainModel(entity: BooksResultEntity?): BooksList
}

class HomeDataMapperImpl : HomeDataMapper {

    override fun toDomainModel(entity: BooksResultEntity?): BooksList =
        BooksList(
            booksList = mapToBook(entity?.sampleChildResponseEntity)
        )

    private fun mapToBook(entity: List<BookItemEntity>?) =
        entity?.map {
            Book(
                rank = it.rank,
                amazonUrl = it.amazonUrl,
                publishedData = it.publishedDate,
                booksDetails = mapToBooksDetails(it.bookDetails)
            )
        }.orEmpty()

    private fun mapToBooksDetails(entity: List<BookDetailsEntity>?): List<BookDetails> =
        entity?.map {
            BookDetails(
                isbn = it.isbn.orEmpty(),
                title = it.title.orEmpty(),
                description = it.description.orEmpty(),
                publisher = it.publisher.orEmpty(),
                author = it.author.orEmpty(),
                contributor = it.contributor.orEmpty(),
                price = it.price ?: 0.0f
            )
        }.orEmpty()
}