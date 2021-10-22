package com.lampa.dogiz.retrofit

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.model.Coordinates
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AddressEntity(

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
