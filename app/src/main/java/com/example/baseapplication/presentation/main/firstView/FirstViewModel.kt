package com.example.baseapplication.presentation.main.firstView

import androidx.lifecycle.MutableLiveData
import com.example.core.extensions.execute
import com.example.baseapplication.domain.usecases.GetSampleDataUseCase
import com.example.baseapplication.presentation.main.firstView.adapter.SampleDataItems
import com.example.baseapplication.presentation.main.firstView.mapper.FirstFragmentMapper
import com.example.core.extensions.update
import com.example.core.presentation.base.BaseViewModel

class FirstViewModel(
    private val getSampleDataUseCase: GetSampleDataUseCase,
    private val mapper: FirstFragmentMapper
) : BaseViewModel() {

    var sampleDataList: MutableLiveData<List<SampleDataItems.SampleDataItem>> = MutableLiveData(
        emptyList()
    )

    init {
        getSampleData()
    }

    private fun getSampleData() {
        execute {
            getSampleDataUseCase(GetSampleDataUseCase.Params("sampleId")).fold(
                handleSuccess = {
                    sampleDataList update mapper.mapItems(it)
                },
                handleError = {
                    // Show error view
                }
            )
        }
    }
}