package com.example.baseapplication.domain.usecases

import com.example.baseapplication.domain.core.UseCase
import com.example.baseapplication.domain.model.SampleDataModel

interface GetSampleDataUseCase: UseCase<GetSampleDataUseCase.Params, SampleDataModel> {

    data class Params(val sameDataID: String)
}