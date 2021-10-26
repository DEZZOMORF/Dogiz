package com.lampa.dogiz.retrofit.hub.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.retrofit.hub.entity.content.ContentRewardEntity

data class HubRewardEntity(

    @SerializedName("content")
    @Expose
    val content: List<ContentRewardEntity>?,

    @SerializedName("order")
    @Expose
    val order: Int?,

    )
