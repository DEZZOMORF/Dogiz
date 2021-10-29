package com.lampa.dogiz.retrofit.hub.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.retrofit.hub.entity.content.ContentRewardEntity
import com.lampa.dogiz.retrofit.hub.entity.content.ContentScheduleEntity

data class HubScheduleEntity(

    @SerializedName("content")
    @Expose
    val content: List<ContentScheduleEntity>?,

    @SerializedName("order")
    @Expose
    val order: Int?,

    )
