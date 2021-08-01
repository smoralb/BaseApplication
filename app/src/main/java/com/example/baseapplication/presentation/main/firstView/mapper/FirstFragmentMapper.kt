package com.example.baseapplication.presentation.main.firstView.mapper

import com.example.baseapplication.domain.model.SampleDataModel
import com.example.baseapplication.presentation.main.firstView.adapter.SampleDataItems

interface FirstFragmentMapper {
    fun mapItems(model: List<SampleDataModel>): List<SampleDataItems.SampleDataItem>
}

class FirstFragmentMapperImpl : FirstFragmentMapper {

    override fun mapItems(model: List<SampleDataModel>) =
        model.map {
            SampleDataItems.SampleDataItem(
                it.name,
                it.url
            )
        }

}