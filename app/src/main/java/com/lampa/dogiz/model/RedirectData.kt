package com.lampa.dogiz.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RedirectData(

    @SerializedName("destination")
    @Expose
    val destination: String?,

    @SerializedName("link")
    @Expose
    val link: String?,
)
