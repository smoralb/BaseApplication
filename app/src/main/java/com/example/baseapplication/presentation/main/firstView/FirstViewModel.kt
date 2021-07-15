package com.example.baseapplication.presentation.main.firstView

import androidx.lifecycle.MutableLiveData
import com.example.baseapplication.domain.core.execute
import com.example.baseapplication.domain.usecases.GetSampleDataUseCase
import com.example.baseapplication.presentation.core.base.BaseViewModel
import com.example.baseapplication.presentation.main.firstView.adapter.SampleDataItems

class FirstViewModel(
    private val getSampleDataUseCase: GetSampleDataUseCase
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
                    sampleDataList.postValue(listOf(
                        SampleDataItems.SampleDataItem(
                            it.name,
                            it.url
                        )
                    ))
                },
                handleError = {
                    // Show error view
                }
            )
        }
    }
}