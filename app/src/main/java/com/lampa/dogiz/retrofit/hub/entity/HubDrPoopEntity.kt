package com.lampa.dogiz.retrofit.hub.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.retrofit.hub.entity.content.ContentDrPoopEntity

data class HubDrPoopEntity(

    @SerializedName("content")
    @Expose
    val contentDrPoop: List<ContentDrPoopEntity>?,

    @SerializedName("order")
    @Expose
    val order: Int?,

    )
