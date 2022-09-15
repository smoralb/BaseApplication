package com.smb.ft_home.data.repository.mapper

import com.smb.ft_home.data.entity.BooksResultEntity
import com.smb.ft_home.domain.model.BooksList

interface SampleDataMapper {

    fun toDomainModel(entity: BooksResultEntity?): BooksList
}