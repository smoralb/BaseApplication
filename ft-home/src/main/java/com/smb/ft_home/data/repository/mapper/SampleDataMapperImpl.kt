package com.smb.ft_home.data.repository.mapper

import com.smb.ft_home.data.entity.SampleApiChildDetailsEntity
import com.smb.ft_home.data.entity.SampleApiResponseEntity
import com.smb.ft_home.domain.model.SampleChildDetailsModel
import com.smb.ft_home.domain.model.SampleChildModel

class SampleDataMapperImpl : SampleDataMapper {

    override fun toDomainModel(entity: SampleApiResponseEntity?): SampleChildModel =
        entity?.sampleChildResponseEntity?.first().let { section ->
            SampleChildModel(
                bookDetails = section?.bookDetails?.map { mapToChildrenDetails(it) }.orEmpty()
            )
        }


    private fun mapToChildrenDetails(entity: SampleApiChildDetailsEntity?): SampleChildDetailsModel =
        SampleChildDetailsModel(
            isbn = entity?.isbn.orEmpty(),
            title = entity?.title.orEmpty(),
            description = entity?.description.orEmpty(),
            publisher = entity?.publisher.orEmpty()
        )
}