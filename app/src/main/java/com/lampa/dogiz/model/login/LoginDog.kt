package com.lampa.dogiz.model.login

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginDog(

    var id: String?,
    var name: String?

) : Parcelable
