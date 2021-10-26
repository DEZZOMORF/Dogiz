package com.lampa.dogiz.retrofit.hub.entity.content

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ContentRewardEntity(

    @SerializedName("_id")
    @Expose
    val id: String?,

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("typeReWard")
    @Expose
    val typeReWard: String?,

    @SerializedName("desc")
    @Expose
    val desc: String?,

    @SerializedName("coins")
    @Expose
    val coins: Int?,

)
