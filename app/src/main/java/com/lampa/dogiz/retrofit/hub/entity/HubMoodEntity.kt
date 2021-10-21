package com.lampa.dogiz.retrofit.hub.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.retrofit.hub.entity.content.ContentMoodEntity

data class HubMoodEntity(

    @SerializedName("content")
    @Expose
    val contentMood: List<ContentMoodEntity>?,

    @SerializedName("order")
    @Expose
    val order: Int?

)
