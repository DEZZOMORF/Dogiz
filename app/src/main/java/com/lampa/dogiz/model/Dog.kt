package com.lampa.dogiz.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dog(

    @SerializedName("name")
    @Expose
    var name: String?,
) : Parcelable
