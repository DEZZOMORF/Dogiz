package com.lampa.dogiz.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CheckCodeDog(

    var id: String?,
    var name: String?

) : Parcelable
