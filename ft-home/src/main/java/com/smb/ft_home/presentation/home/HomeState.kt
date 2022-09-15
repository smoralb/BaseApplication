package com.smb.ft_home.presentation.home

import com.example.core.presentation.base.BaseState

sealed class HomeState: BaseState() {
    object Loading: HomeState()
    object HideLoading: HomeState()
    data class NavigateToSecondFragment(val isbn: String): HomeState()
}
