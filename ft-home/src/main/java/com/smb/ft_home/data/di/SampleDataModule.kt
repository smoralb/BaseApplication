package com.smb.ft_home.data.di

import com.smb.ft_home.data.SampleApi
import com.smb.ft_home.domain.repository.SampleDataRepository
import com.smb.ft_home.data.repository.SampleDataRepositoryImpl
import com.smb.ft_home.data.repository.mapper.SampleDataMapper
import com.smb.ft_home.data.repository.mapper.SampleDataMapperImpl
import com.smb.ft_home.data.source.SampleDataRemoteSource
import com.smb.ft_home.data.source.SampleDataRemoteSourceImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val sampleDataModule = module {

    single<SampleDataMapper> { SampleDataMapperImpl() }

    single<SampleDataRemoteSource> { SampleDataRemoteSourceImpl(get(), get()) }

    single<SampleDataRepository> { SampleDataRepositoryImpl(get()) }

    single { get<Retrofit>().create(SampleApi::class.java) }

}