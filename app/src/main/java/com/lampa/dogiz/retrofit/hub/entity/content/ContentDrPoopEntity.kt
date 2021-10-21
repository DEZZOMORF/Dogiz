package com.lampa.dogiz.retrofit.hub.entity.content

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ContentDrPoopEntity(

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("desc")
    @Expose
    val desc: String?,

)
