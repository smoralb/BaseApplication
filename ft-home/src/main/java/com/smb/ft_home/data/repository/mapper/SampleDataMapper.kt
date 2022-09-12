package com.smb.ft_home.data.repository.mapper

import com.smb.ft_home.data.entity.SampleApiResponseEntity
import com.smb.ft_home.domain.model.SampleChildModel

interface SampleDataMapper {

    fun toDomainModel(entity: SampleApiResponseEntity?): SampleChildModel
}