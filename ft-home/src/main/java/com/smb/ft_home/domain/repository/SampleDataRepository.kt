package com.smb.ft_home.domain.repository

import com.smb.ft_home.domain.model.BooksList

interface SampleDataRepository {

    suspend fun getSampleData(): Result<BooksList>
}