package com.smb.ft_home.presentation.ui.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.core.presentation.base.BaseFragment
import com.smb.ft_home.BR
import com.smb.ft_home.R
import com.smb.ft_home.databinding.FragmentDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<DetailsState, FragmentDetailsBinding, DetailsViewModel>
    (R.layout.fragment_details, BR.viewModel) {

    override val viewModel by viewModel<DetailsViewModel>()
    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init(args.isbn)

        binding.tbHeader.setNavigationOnClickListener {
            navigateTo(DetailsFragmentDirections.toFirstFragment())
        }
    }

    override fun checkViewState(state: DetailsState) {
        // Nothing to do yet
    }
}