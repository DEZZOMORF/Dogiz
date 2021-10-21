package com.lampa.dogiz.retrofit.hub.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.retrofit.hub.entity.content.ContentLostDogEntity

data class HubLostDogEntity(

    @SerializedName("content")
    @Expose
    val contentLostDog: List<ContentLostDogEntity>?,

    @SerializedName("order")
    @Expose
    val order: Int?,

    )
