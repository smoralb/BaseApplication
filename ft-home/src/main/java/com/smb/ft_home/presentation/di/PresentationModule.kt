package com.smb.ft_home.presentation.di

import com.smb.ft_home.presentation.home.HomeViewModel
import com.smb.ft_home.presentation.home.mapper.FirstFragmentMapper
import com.smb.ft_home.presentation.home.mapper.FirstFragmentMapperImpl
import com.smb.ft_home.presentation.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    factory<FirstFragmentMapper> { FirstFragmentMapperImpl() }

    viewModel { HomeViewModel(get(), get()) }
    viewModel { DetailsViewModel(get()) }
}