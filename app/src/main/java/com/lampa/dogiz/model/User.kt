package com.lampa.dogiz.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(

    var email: String?,
    var phone: String?,
    var firstName: String?,
    var lastName: String?,
    var role: String?,
    var dogs: List<CheckCodeDog>?,
    var address: UserAddress?,
    var company: String?

) : Parcelable
