package com.smb.ft_home.domain.usecases

import com.smb.ft_home.domain.model.SampleChildModel
import com.smb.ft_home.domain.repository.SampleDataRepository

class GetSampleDataUseCaseImpl(
    private val repository: SampleDataRepository
) : GetSampleDataUseCase {

    override suspend fun invoke(params: Unit): Result<SampleChildModel> =
        repository.getSampleData()
}