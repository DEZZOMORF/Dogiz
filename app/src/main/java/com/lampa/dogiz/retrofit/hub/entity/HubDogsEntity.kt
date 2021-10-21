package com.lampa.dogiz.retrofit.hub.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.retrofit.DogEntity

data class HubDogsEntity(

    @SerializedName("content")
    @Expose
    val content: List<DogEntity>?,

    @SerializedName("order")
    @Expose
    val order: Int?

)


