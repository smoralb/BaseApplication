package com.example.baseapplication.presentation.di

import com.example.baseapplication.presentation.main.firstView.FirstViewModel
import com.example.baseapplication.presentation.main.firstView.mapper.FirstFragmentMapper
import com.example.baseapplication.presentation.main.firstView.mapper.FirstFragmentMapperImpl
import com.example.baseapplication.presentation.main.secondView.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    single<FirstFragmentMapper> { FirstFragmentMapperImpl() }
    viewModel { FirstViewModel(get(), get()) }
    viewModel { SecondViewModel() }
}