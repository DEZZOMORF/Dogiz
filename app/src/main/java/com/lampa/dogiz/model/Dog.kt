package com.lampa.dogiz.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Dog(

    var id: String?,
    var name: String?,
    var gender: String? = null,
    var birthday: Date? = null,
    var weight: Int? = null,
    var spayed: Boolean? = null,
    var friendlyDogs: Boolean? = null,
    var friendlyHuman: Boolean? = null,
    var vaccinated: Boolean? = null,
    var desc: String? = null,
    var statusQuiz: String? = null,
    var position: Int? = null,
    var age: Int? = null,
    var url: String? = null

) : Parcelable
