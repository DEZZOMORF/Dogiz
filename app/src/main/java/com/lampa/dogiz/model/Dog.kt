package com.lampa.dogiz.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Dog(

    @SerializedName("name")
    @Expose
    var name: String,
)
