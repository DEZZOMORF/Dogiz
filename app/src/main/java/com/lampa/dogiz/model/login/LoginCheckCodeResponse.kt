package com.lampa.dogiz.model.login

import android.os.Parcelable
import com.lampa.dogiz.model.Step
import com.lampa.dogiz.model.User
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginCheckCodeResponse (

    val step: Step?,
    val auth: Auth?,
    val user: User?,
) : Parcelable
