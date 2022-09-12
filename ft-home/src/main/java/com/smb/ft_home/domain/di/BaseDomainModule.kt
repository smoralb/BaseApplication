package com.smb.ft_home.domain.di

import com.smb.ft_home.domain.usecases.GetSampleDataUseCase
import com.smb.ft_home.domain.usecases.GetSampleDataUseCaseImpl
import org.koin.dsl.module

val baseDomainModule = module {

    factory<GetSampleDataUseCase> { GetSampleDataUseCaseImpl(get()) }
}