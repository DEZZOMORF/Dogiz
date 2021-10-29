package com.lampa.dogiz.retrofit.hub.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HubResponseEntity(

    @SerializedName("dogs")
    @Expose
    val dogs: HubDogsEntity?,

    @SerializedName("notification")
    @Expose
    val notification: HubNotificationEntity? = null,

    @SerializedName("activity")
    @Expose
    val activity: HubActivityEntity? = null,

    @SerializedName("reward")
    @Expose
    val reward: HubRewardEntity? = null,

    @SerializedName("recommend")
    @Expose
    val recommend: HubRecommendEntity? = null,

    @SerializedName("schedule")
    @Expose
    val schedule: HubScheduleEntity? = null,

    @SerializedName("drPoop")
    @Expose
    val drPoop: HubDrPoopEntity? = null,

    @SerializedName("journey")
    @Expose
    val journey: HubJourneyEntity? = null,

    @SerializedName("mood")
    @Expose
    val mood: HubMoodEntity? = null,

    @SerializedName("lostDog")
    @Expose
    val lostDog: HubLostDogEntity? = null,

    )