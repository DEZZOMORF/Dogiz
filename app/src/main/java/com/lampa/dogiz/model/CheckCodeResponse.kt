package com.lampa.dogiz.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CheckCodeResponse (

    val step: Step?,
    val auth: Auth?,
    val user: User?,
) : Parcelable
