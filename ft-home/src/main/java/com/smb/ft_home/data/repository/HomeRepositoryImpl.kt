package com.smb.ft_home.data.repository

import com.smb.ft_home.data.source.HomeRemoteSource
import com.smb.ft_home.domain.model.BooksList
import com.smb.ft_home.domain.repository.HomeRepository

class HomeRepositoryImpl(private val remoteSource: HomeRemoteSource) :
    HomeRepository {

    override suspend fun getBooksList(): Result<BooksList> = remoteSource.getBooksList()

}