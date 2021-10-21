package com.lampa.dogiz.model.login

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
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

) : Parcelable
