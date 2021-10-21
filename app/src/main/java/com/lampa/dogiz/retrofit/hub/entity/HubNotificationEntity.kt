package com.lampa.dogiz.retrofit.hub.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.retrofit.hub.entity.content.ContentNotificationEntity

data class HubNotificationEntity(

    @SerializedName("content")
    @Expose
    val contentNotification: List<ContentNotificationEntity>?,

    @SerializedName("order")
    @Expose
    val order: Int?

)
