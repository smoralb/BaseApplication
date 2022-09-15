package com.smb.ft_home.data

import com.smb.ft_home.data.entity.BooksResultEntity
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {

    @GET("/svc/books/v3/lists.json?list=hardcover-fiction")
    suspend fun getBooksList(): Response<BooksResultEntity>

}