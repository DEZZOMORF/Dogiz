package com.lampa.dogiz.retrofit.hub.entity.content

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class ContentNotificationEntity(

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("desc")
    @Expose
    val desc: String?,

    @SerializedName("date")
    @Expose
    val date: Date?,

    @SerializedName("notificationType")
    @Expose
    val notificationType: String?,

    @SerializedName("visible")
    @Expose
    val visible: Boolean?,
)
