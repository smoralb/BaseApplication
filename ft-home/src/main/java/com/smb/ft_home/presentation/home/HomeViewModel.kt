package com.smb.ft_home.presentation.home

import androidx.lifecycle.MutableLiveData
import com.smb.ft_home.presentation.home.adapter.HomeDataItems
import com.smb.ft_home.presentation.home.mapper.FirstFragmentMapper
import com.example.core.extensions.EMPTY_STRING
import com.example.core.extensions.execute
import com.example.core.extensions.update
import com.example.core.presentation.base.BaseViewModel
import com.smb.ft_home.domain.usecases.GetSampleDataUseCase

class HomeViewModel(
    private val getSampleDataUseCase: GetSampleDataUseCase,
    private val mapper: FirstFragmentMapper
) : BaseViewModel<HomeState>() {

    val firstViewModelText: MutableLiveData<String> = MutableLiveData(EMPTY_STRING)
    val itemList: MutableLiveData<List<HomeDataItems.HomeDataItem>> =
        MutableLiveData(emptyList())

    private val onItemClickListener: (String) -> Unit = {
        _viewState update HomeState.NavigateToSecondFragment(isbn = it)
    }

    fun initialize() {
        getSampleData()
    }

    private fun getSampleData() {
        _viewState update HomeState.Loading
        execute {
            getSampleDataUseCase(Unit).fold(
                onSuccess = { bookList ->
                    itemList update mapper.mapItems(bookList, onItemClickListener)
                    _viewState update HomeState.HideLoading
                },
                onFailure = {
                    firstViewModelText update "Error"
                    _viewState update HomeState.HideLoading
                }
            )
        }
    }
}