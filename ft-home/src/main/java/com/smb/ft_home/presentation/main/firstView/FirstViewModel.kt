package com.smb.ft_home.presentation.main.firstView

import androidx.lifecycle.MutableLiveData
import com.smb.ft_home.presentation.main.firstView.adapter.SampleDataItems
import com.smb.ft_home.presentation.main.firstView.mapper.FirstFragmentMapper
import com.example.core.extensions.EMPTY_STRING
import com.example.core.extensions.execute
import com.example.core.extensions.update
import com.example.core.presentation.base.BaseViewModel
import com.smb.ft_home.domain.usecases.GetSampleDataUseCase

class FirstViewModel(
    private val getSampleDataUseCase: GetSampleDataUseCase,
    private val mapper: FirstFragmentMapper
) : BaseViewModel<FirstViewState>() {

    val firstViewModelText: MutableLiveData<String> = MutableLiveData(EMPTY_STRING)
    val itemList: MutableLiveData<List<SampleDataItems.SampleDataItem>> =
        MutableLiveData(emptyList())

    private val onItemClickListener: (String) -> Unit = {
        _viewState update FirstViewState.NavigateToSecondFragment(isbn = it)
    }

    fun initialize() {
        getSampleData()
    }

    private fun getSampleData() {
        _viewState update FirstViewState.Loading
        execute {
            getSampleDataUseCase(Unit).fold(
                onSuccess = { bookList ->
                    itemList update mapper.mapItems(bookList, onItemClickListener)
                    _viewState update FirstViewState.HideLoading
                },
                onFailure = {
                    firstViewModelText update "Error"
                    _viewState update FirstViewState.HideLoading
                }
            )
        }
    }
}