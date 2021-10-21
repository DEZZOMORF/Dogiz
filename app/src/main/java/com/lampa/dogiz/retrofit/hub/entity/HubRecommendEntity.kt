package com.lampa.dogiz.retrofit.hub.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.retrofit.hub.entity.content.ContentRecommendEntity

data class HubRecommendEntity(

    @SerializedName("content")
    @Expose
    val contentRecommend: List<ContentRecommendEntity>?,

    @SerializedName("order")
    @Expose
    val order: Int?,

    )
