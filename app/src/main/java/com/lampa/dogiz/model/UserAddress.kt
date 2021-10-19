package com.lampa.dogiz.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserAddress(

    @SerializedName("country")
    @Expose
    var country: String,

    @SerializedName("city")
    @Expose
    var city: String,
)
