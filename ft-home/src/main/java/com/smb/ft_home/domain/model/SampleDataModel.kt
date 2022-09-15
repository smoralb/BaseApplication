package com.smb.ft_home.domain.model

data class BooksList(
    val booksList: List<Book>
)

data class Book(
    val rank: Int,
    val amazonUrl: String,
    val publishedData: String,
    val booksDetails: List<BookDetails>
)

data class BookDetails(
    val isbn: String,
    val title: String,
    val description: String,
    val publisher: String,
    val author: String,
    val contributor: String,
    val price: Float,
)