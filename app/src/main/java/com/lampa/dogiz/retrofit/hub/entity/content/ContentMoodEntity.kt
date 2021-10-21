package com.lampa.dogiz.retrofit.hub.entity.content

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ContentMoodEntity(

    @SerializedName("typeMood")
    @Expose
    val typeMood: String?, //TODO Change to enum

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("desc")
    @Expose
    val desc: String?,

    @SerializedName("createDate")
    @Expose
    val createDate: String?,

    @SerializedName("updateDate")
    @Expose
    val updateDate: String?,

)
