package com.example.baseapplication.presentation.main.firstView

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplication.R
import com.example.baseapplication.databinding.FragmentFirstBinding
import com.example.baseapplication.presentation.core.base.BaseFragment
import com.example.baseapplication.presentation.main.firstView.adapter.FirstFragmentAdapter
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : BaseFragment<FragmentFirstBinding, FirstViewModel>(R.layout.fragment_first) {

    override val viewModel by viewModel<FirstViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvItems.adapter = FirstFragmentAdapter()
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}