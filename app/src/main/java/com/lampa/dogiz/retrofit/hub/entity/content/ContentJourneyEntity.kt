package com.lampa.dogiz.retrofit.hub.entity.content

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ContentJourneyEntity(

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("desc")
    @Expose
    val desc: String?,

    @SerializedName("typeEvent")
    @Expose
    val typeEvent: String?,

    @SerializedName("createDate")
    @Expose
    val createDate: String?,

    @SerializedName("updateDate")
    @Expose
    val updateDate: String?,

)
