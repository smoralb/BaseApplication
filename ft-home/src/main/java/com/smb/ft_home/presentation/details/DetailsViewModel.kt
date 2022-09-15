package com.smb.ft_home.presentation.details

import androidx.lifecycle.MutableLiveData
import com.example.core.extensions.EMPTY_STRING
import com.example.core.extensions.execute
import com.example.core.extensions.update
import com.example.core.presentation.base.BaseViewModel
import com.smb.ft_home.domain.usecases.GetSampleDataUseCase
import com.smb.ft_home.presentation.details.mapper.DetailsUiMapper

class DetailsViewModel(
    private val getSampleDataUseCase: GetSampleDataUseCase,
    private val mapper: DetailsUiMapper
) : BaseViewModel<DetailsState>() {

    val title: MutableLiveData<String> = MutableLiveData(EMPTY_STRING)
    val description: MutableLiveData<String> = MutableLiveData(EMPTY_STRING)
    val publisher: MutableLiveData<String> = MutableLiveData(EMPTY_STRING)

    val onClickListener: () -> Unit = {

    }

    fun init(isbn: String) {
        execute {
            getSampleDataUseCase(Unit).fold(
                onFailure = {},
                onSuccess = {
                    val details = mapper.mapItems(isbn, it)
                    title update details.title
                    description update details.description
                    publisher update details.publisher
                }
            )
        }
    }
}