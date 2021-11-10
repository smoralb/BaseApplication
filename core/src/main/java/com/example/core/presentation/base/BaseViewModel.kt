package com.example.core.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<S: BaseState>: ViewModel() {

    val _viewState: MutableLiveData<S> = MutableLiveData()

    val viewState: LiveData<S>
        get() = _viewState
}