package com.lampa.dogiz.retrofit.hub.entity.content

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.model.RedirectData

data class ContentRecommendEntity(

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("subTitle")
    @Expose
    val subTitle: String?,

    @SerializedName("content")
    @Expose
    val content: String?,

    @SerializedName("isShow")
    @Expose
    val isShow: Boolean?,

    @SerializedName("redirect")
    @Expose
    val redirect: RedirectData?,

    )
