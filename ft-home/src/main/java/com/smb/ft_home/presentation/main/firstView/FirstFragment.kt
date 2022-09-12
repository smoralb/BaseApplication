package com.smb.ft_home.presentation.main.firstView

import android.os.Bundle
import android.view.View
import com.smb.ft_home.presentation.main.firstView.adapter.FirstFragmentAdapter
import com.example.core.presentation.base.BaseFragment
import com.smb.ft_home.BR
import com.smb.ft_home.R
import com.smb.ft_home.databinding.FragmentFirstBinding
import com.smb.ft_home.presentation.main.firstView.FirstViewState.Loading
import com.smb.ft_home.presentation.main.firstView.FirstViewState.HideLoading
import com.smb.ft_home.presentation.main.firstView.FirstViewState.NavigateToSecondFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : BaseFragment<FirstViewState, FragmentFirstBinding, FirstViewModel>
    (R.layout.fragment_first, BR.viewModel) {

    override val viewModel by viewModel<FirstViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBookList.adapter = FirstFragmentAdapter()
        viewModel.initialize()
    }

    override fun checkViewState(state: FirstViewState) {
        when (state) {
            is Loading -> binding.plItemsLoader.visibility = View.VISIBLE
            is HideLoading -> binding.plItemsLoader.visibility = View.GONE
            is NavigateToSecondFragment ->
                navigateTo(FirstFragmentDirections.toSecondFragment(state.isbn))
        }
    }
}