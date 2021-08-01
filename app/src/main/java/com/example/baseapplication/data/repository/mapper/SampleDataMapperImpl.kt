package com.example.baseapplication.data.repository.mapper

import com.example.baseapplication.data.entity.SampleApiResponseEntity
import com.example.baseapplication.domain.model.SampleDataModel

class SampleDataMapperImpl : SampleDataMapper {

    override fun toDomainModel(entity: SampleApiResponseEntity?): List<SampleDataModel> {
        return entity?.sampleChildResponseEntity?.map {
            SampleDataModel(
                it.name,
                it.image
            )
        }.orEmpty()
    }
}