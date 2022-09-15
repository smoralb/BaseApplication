package com.smb.ft_home.data.di

import com.smb.ft_home.data.HomeApi
import com.smb.ft_home.data.repository.HomeRepositoryImpl
import com.smb.ft_home.data.repository.mapper.HomeDataMapper
import com.smb.ft_home.data.repository.mapper.HomeDataMapperImpl
import com.smb.ft_home.data.source.HomeRemoteSource
import com.smb.ft_home.data.source.HomeRemoteSourceImpl
import com.smb.ft_home.domain.repository.HomeRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val sampleDataModule = module {

    single<HomeDataMapper> { HomeDataMapperImpl() }

    single<HomeRemoteSource> { HomeRemoteSourceImpl(api = get(), mapper = get()) }

    single<HomeRepository> { HomeRepositoryImpl(remoteSource = get()) }

    single { get<Retrofit>().create(HomeApi::class.java) }

}