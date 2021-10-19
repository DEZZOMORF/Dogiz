package com.lampa.dogiz.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Auth(

    @SerializedName("accessToken")
    @Expose
    var accessToken: String,

    @SerializedName("refreshToken")
    @Expose
    var refreshToken: String,

    @SerializedName("expiresIn")
    @Expose
    var expiresIn: Int,
)
