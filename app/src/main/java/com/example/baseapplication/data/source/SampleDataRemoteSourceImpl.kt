package com.example.baseapplication.data.source

import com.example.baseapplication.data.SampleApi
import com.example.baseapplication.data.repository.mapper.SampleDataMapper
import com.example.baseapplication.domain.model.SampleDataModel
import com.example.core.data.Result
import com.example.core.data.safeApiCall

class SampleDataRemoteSourceImpl(
    private val api: SampleApi,
    private val mapper: SampleDataMapper) : SampleDataRemoteSource {

    override suspend fun getSampleData(): Result<SampleDataModel> {
        return safeApiCall(
            { api.getSampleData() },
            { entity -> mapper.toDomainModel(entity) }
        )
    }
}