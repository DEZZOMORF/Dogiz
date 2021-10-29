package com.lampa.dogiz.retrofit

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DogEntity(

    @SerializedName("_id")
    @Expose
    var id: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("gender")
    @Expose
    var gender: String? = null,

    @SerializedName("birthday")
    @Expose
    var birthday: String? = null,

    @SerializedName("weight")
    @Expose
    var weight: Int? = null,

    @SerializedName("spayed")
    @Expose
    var spayed: Boolean? = null,

    @SerializedName("friendlyDogs")
    @Expose
    var friendlyDogs: Boolean? = null,

    @SerializedName("friendlyHuman")
    @Expose
    var friendlyHuman: Boolean? = null,

    @SerializedName("vaccined")
    @Expose
    var vaccinated: Boolean? = null,

    @SerializedName("desc")
    @Expose
    var desc: String? = null,

    @SerializedName("statusQuiz")
    @Expose
    var statusQuiz: String? = null,

    @SerializedName("possition")
    @Expose
    var position: Int? = null,

    @SerializedName("age")
    @Expose
    var age: Int? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

    @SerializedName("coins")
    @Expose
    var coins: Int? = null

) : Parcelable
