package com.smb.ft_home.domain.repository

import com.smb.ft_home.domain.model.BooksList

interface HomeRepository {

    suspend fun getBooksList(): Result<BooksList>
}