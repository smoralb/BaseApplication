package com.smb.ft_home.data.entity

import com.squareup.moshi.Json

data class BooksResultEntity(
    @Json(name = "results") val sampleChildResponseEntity: List<BookItemEntity>?
)

data class BookItemEntity(
    @Json(name = "published_date") val publishedDate: String,
    @Json(name = "rank") val rank: Int,
    @Json(name = "amazon_product_url") val amazonUrl: String,
    @Json(name = "book_details") val bookDetails: List<BookDetailsEntity>?
)

data class BookDetailsEntity(
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "contributor") val contributor: String?,
    @Json(name = "author") val author: String?,
    @Json(name = "publisher") val publisher: String?,
    @Json(name = "price") val price: Float?,
    @Json(name = "primary_isbn13") val isbn: String?
)