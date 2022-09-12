package com.smb.ft_home.data.source

import com.smb.ft_home.data.SampleApi
import com.smb.ft_home.data.repository.mapper.SampleDataMapper
import com.smb.ft_home.domain.model.SampleChildModel
import com.example.core.data.safeApiCall

class SampleDataRemoteSourceImpl(
    private val api: SampleApi,
    private val mapper: SampleDataMapper
) : SampleDataRemoteSource {

    override suspend fun getSampleData(): Result<SampleChildModel> {
        return safeApiCall(
            { api.getSampleData() },
            { entity -> mapper.toDomainModel(entity) }
        )
    }
}