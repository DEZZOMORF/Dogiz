package com.lampa.dogiz.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserAddress(

    @SerializedName("country")
    @Expose
    var country: String?,

    @SerializedName("city")
    @Expose
    var city: String?,
) : Parcelable
