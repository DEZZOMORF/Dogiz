package com.lampa.dogiz.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("phone")
    @Expose
    var phone: String,

    @SerializedName("firstName")
    @Expose
    var firstName: String,

    @SerializedName("lastName")
    @Expose
    var lastName: String,

    @SerializedName("role")
    @Expose
    var role: String,

    @SerializedName("dogs")
    @Expose
    var dogs: List<Dog>,

    @SerializedName("address")
    @Expose
    var address: UserAddress,

    @SerializedName("company")
    @Expose
    var company: String,
)
