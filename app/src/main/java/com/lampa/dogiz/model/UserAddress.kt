package com.lampa.dogiz.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserAddress(

    var country: String?,
    var city: String?,

): Parcelable
