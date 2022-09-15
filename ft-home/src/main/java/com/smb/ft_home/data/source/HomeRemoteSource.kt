package com.smb.ft_home.data.source

import com.example.core.data.safeApiCall
import com.smb.ft_home.data.HomeApi
import com.smb.ft_home.data.repository.mapper.HomeDataMapper
import com.smb.ft_home.domain.model.BooksList

interface HomeRemoteSource {
    suspend fun getBooksList(): Result<BooksList>
}

class HomeRemoteSourceImpl(
    private val api: HomeApi,
    private val mapper: HomeDataMapper
) : HomeRemoteSource {

    override suspend fun getBooksList(): Result<BooksList> {
        return safeApiCall(
            { api.getBooksList() },
            { entity -> mapper.toDomainModel(entity) }
        )
    }
}