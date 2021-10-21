package com.lampa.dogiz.model

import android.os.Parcelable
import com.lampa.dogiz.model.login.LoginDog
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(

    var email: String?,
    var phone: String?,
    var firstName: String?,
    var lastName: String?,
    var role: String?,
    var dogs: List<LoginDog>?,
    var address: Address?,
    var company: String?

) : Parcelable
