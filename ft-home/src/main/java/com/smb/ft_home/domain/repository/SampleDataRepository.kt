package com.smb.ft_home.domain.repository

import com.smb.ft_home.domain.model.SampleChildModel

interface SampleDataRepository {

    suspend fun getSampleData(): Result<SampleChildModel>
}