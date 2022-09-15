package com.smb.ft_home.presentation.ui.home

import android.os.Bundle
import android.view.View
import com.example.core.presentation.base.BaseFragment
import com.smb.ft_home.BR
import com.smb.ft_home.R
import com.smb.ft_home.databinding.FragmentHomeBinding
import com.smb.ft_home.presentation.ui.home.HomeState.HideLoading
import com.smb.ft_home.presentation.ui.home.HomeState.Loading
import com.smb.ft_home.presentation.ui.home.HomeState.NavigateToSecondFragment
import com.smb.ft_home.presentation.ui.home.adapter.HomeAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment :
    BaseFragment<HomeState, FragmentHomeBinding, HomeViewModel>
        (R.layout.fragment_home, BR.viewModel) {

    override val viewModel by viewModel<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBookList.adapter = HomeAdapter()
        viewModel.initialize()
    }

    override fun checkViewState(state: HomeState) {
        when (state) {
            is Loading -> binding.plItemsLoader.visibility = View.VISIBLE
            is HideLoading -> binding.plItemsLoader.visibility = View.GONE
            is NavigateToSecondFragment ->
                navigateTo(HomeFragmentDirections.toDetails(state.isbn))
        }
    }
}