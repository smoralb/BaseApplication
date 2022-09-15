package com.smb.ft_home.presentation.di

import com.smb.ft_home.presentation.ui.home.HomeViewModel
import com.smb.ft_home.presentation.ui.home.mapper.FirstFragmentMapper
import com.smb.ft_home.presentation.ui.home.mapper.FirstFragmentMapperImpl
import com.smb.ft_home.presentation.ui.secondView.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    factory<FirstFragmentMapper> { FirstFragmentMapperImpl() }

    viewModel { HomeViewModel(get(), get()) }
    viewModel { SecondViewModel(get()) }
}