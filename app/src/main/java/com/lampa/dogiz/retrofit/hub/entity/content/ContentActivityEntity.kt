package com.lampa.dogiz.retrofit.hub.entity.content

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.model.Coordinates
import com.lampa.dogiz.model.DogActivity

data class ContentActivityEntity(

    @SerializedName("_id")
    @Expose
    val id: String?,

    @SerializedName("dogs")
    @Expose
    val dogs: List<String>?,

    @SerializedName("walker")
    @Expose
    val walker: String?,

    @SerializedName("typeOrder")
    @Expose
    val typeOrder: String?,

    @SerializedName("startDate")
    @Expose
    val startDate: String?,

    @SerializedName("endDate")
    @Expose
    val endDate: String?,

    @SerializedName("coords")
    @Expose
    val coordinates: Coordinates?,

    @SerializedName("activity")
    @Expose
    val activity: List<DogActivity>?,

    @SerializedName("distance")
    @Expose
    val distance: Int?,

    @SerializedName("duration")
    @Expose
    val duration: Int?,

    @SerializedName("status")
    @Expose
    val status: String?,
)


