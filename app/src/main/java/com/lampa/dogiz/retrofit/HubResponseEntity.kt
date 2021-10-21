package com.lampa.dogiz.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HubResponseEntity (

    @SerializedName("dogs")
    @Expose
    val dogs: String?,

)