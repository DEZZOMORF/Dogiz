package com.lampa.dogiz.retrofit.hub.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.retrofit.hub.entity.content.ContentActivityEntity

data class HubActivityEntity(

    @SerializedName("content")
    @Expose
    val activity: List<ContentActivityEntity>?,

    @SerializedName("order")
    @Expose
    val order: Int?,

    )


