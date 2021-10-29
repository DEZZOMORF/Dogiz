package com.lampa.dogiz.retrofit.hub.entity.content

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class ContentScheduleEntity(

    @SerializedName("title")
    @Expose
    var title: String?,

    @SerializedName("time")
    @Expose
    var time: String?,
)
