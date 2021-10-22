package com.lampa.dogiz.retrofit.hub.entity.content

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.retrofit.AddressEntity

data class ContentLostDogEntity(

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("desc")
    @Expose
    val desc: String?,

    @SerializedName("lostStatus")
    @Expose
    val lostStatus: Boolean?,

    @SerializedName("dogs")
    @Expose
    val dogs: List<String>?,

    @SerializedName("address")
    @Expose
    val addressEntity: AddressEntity?,

    )
