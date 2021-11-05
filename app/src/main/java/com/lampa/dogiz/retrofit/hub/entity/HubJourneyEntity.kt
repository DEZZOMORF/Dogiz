package com.lampa.dogiz.retrofit.hub.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.retrofit.hub.entity.content.ContentJourneyEntity

data class HubJourneyEntity(

    @SerializedName("content")
    @Expose
    val content: List<ContentJourneyEntity>?,

    @SerializedName("order")
    @Expose
    val order: Int?,

    )
