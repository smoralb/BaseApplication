package com.smb.ft_home.domain.model

data class SampleChildModel(
    val bookDetails: List<SampleChildDetailsModel>
)

data class SampleChildDetailsModel(
    val isbn: String,
    val title: String,
    val description: String,
    val publisher: String
)