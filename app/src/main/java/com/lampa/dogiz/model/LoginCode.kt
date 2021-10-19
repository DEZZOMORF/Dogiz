package com.lampa.dogiz.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginCode(

    @SerializedName("code")
    @Expose
    var code: Int
)
