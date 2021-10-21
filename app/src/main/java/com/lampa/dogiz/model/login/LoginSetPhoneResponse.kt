package com.lampa.dogiz.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginSetPhoneResponse(

    @SerializedName("code")
    @Expose
    var code: Int
)
