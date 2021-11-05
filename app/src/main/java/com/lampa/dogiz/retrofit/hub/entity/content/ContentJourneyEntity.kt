package com.lampa.dogiz.retrofit.hub.entity.content

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ContentJourneyEntity(

    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("desc")
    @Expose
    val desc: String? = null,

    @SerializedName("typeEvent")
    @Expose
    val typeEvent: String? = null,

    @SerializedName("date")
    @Expose
    val date: String? = null,

)
