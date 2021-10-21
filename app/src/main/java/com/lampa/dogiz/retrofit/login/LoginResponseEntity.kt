package com.lampa.dogiz.retrofit.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.model.login.Auth
import com.lampa.dogiz.retrofit.UserEntity

data class LoginResponseEntity(

    @SerializedName("step")
    @Expose
    val step: String?,

    @SerializedName("auth")
    @Expose
    val auth: Auth?,

    @SerializedName("user")
    @Expose
    val user: UserEntity?

)
