package com.lampa.dogiz.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.model.Auth
import com.lampa.dogiz.model.User

data class CheckCodeResponseEntity(

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
