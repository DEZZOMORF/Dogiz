package com.lampa.dogiz.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DogActivity(

    @SerializedName("dogId")
    @Expose
    val dogId: String?,

    @SerializedName("typeActivity")
    @Expose
    val typeActivity: String?,

    @SerializedName("coord")
    @Expose
    val coordinates: Coordinates?

)
