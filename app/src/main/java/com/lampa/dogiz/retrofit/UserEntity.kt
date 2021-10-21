package com.lampa.dogiz.retrofit

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lampa.dogiz.model.CheckCodeDog
import com.lampa.dogiz.model.Dog
import com.lampa.dogiz.model.UserAddress
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserEntity(

    @SerializedName("email")
    @Expose
    var email: String?,

    @SerializedName("phone")
    @Expose
    var phone: String?,

    @SerializedName("firstName")
    @Expose
    var firstName: String?,

    @SerializedName("lastName")
    @Expose
    var lastName: String?,

    @SerializedName("role")
    @Expose
    var role: String?,

    @SerializedName("dogs")
    @Expose
    var dogs: List<DogEntity>?,

    @SerializedName("address")
    @Expose
    var address: UserAddress?,

    @SerializedName("company")
    @Expose
    var company: String?

) : Parcelable
