package com.smb.ft_home.data.repository

import com.smb.ft_home.data.source.SampleDataRemoteSource
import com.smb.ft_home.domain.model.SampleChildModel
import com.smb.ft_home.domain.repository.SampleDataRepository

class SampleDataRepositoryImpl(private val remoteSource: SampleDataRemoteSource):
    SampleDataRepository {

    override suspend fun getSampleData(): Result<SampleChildModel> = remoteSource.getSampleData()

}