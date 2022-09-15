package com.smb.ft_home.presentation.di

import com.smb.ft_home.presentation.details.DetailsViewModel
import com.smb.ft_home.presentation.details.mapper.DetailsUiMapper
import com.smb.ft_home.presentation.details.mapper.DetailsUiMapperImpl
import com.smb.ft_home.presentation.home.HomeViewModel
import com.smb.ft_home.presentation.home.mapper.FirstFragmentMapper
import com.smb.ft_home.presentation.home.mapper.FirstFragmentMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    factory<FirstFragmentMapper> { FirstFragmentMapperImpl() }
    factory<DetailsUiMapper> { DetailsUiMapperImpl() }

    viewModel { HomeViewModel(getSampleDataUseCase = get(), mapper = get()) }
    viewModel { DetailsViewModel(getSampleDataUseCase = get(), mapper = get()) }
}