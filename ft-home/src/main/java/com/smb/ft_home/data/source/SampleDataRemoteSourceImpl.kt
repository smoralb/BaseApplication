package com.smb.ft_home.data.source

import com.smb.ft_home.data.SampleApi
import com.smb.ft_home.data.repository.mapper.SampleDataMapper
import com.smb.ft_home.domain.model.BooksList
import com.example.core.data.safeApiCall

class SampleDataRemoteSourceImpl(
    private val api: SampleApi,
    private val mapper: SampleDataMapper
) : SampleDataRemoteSource {

    override suspend fun getSampleData(): Result<BooksList> {
        return safeApiCall(
            { api.getSampleData() },
            { entity -> mapper.toDomainModel(entity) }
        )
    }
}