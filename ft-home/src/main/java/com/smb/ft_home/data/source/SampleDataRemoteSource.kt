package com.smb.ft_home.data.source

import com.smb.ft_home.domain.model.BooksList

interface SampleDataRemoteSource {

    suspend fun getSampleData(): Result<BooksList>
}