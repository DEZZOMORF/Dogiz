package com.lampa.dogiz.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(

    @SerializedName("country")
    @Expose
    var country: String?,

    @SerializedName("city")
    @Expose
    var city: String?,

    @SerializedName("street")
    @Expose
    var street: String? = null,

    @SerializedName("coord")
    @Expose
    var coordinates: Coordinates? = null,

) : Parcelable
