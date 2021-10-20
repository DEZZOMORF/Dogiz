package com.lampa.dogiz.model

data class CheckCodeResponse(

    val step: Step?,
    val auth: Auth?,
    val user: User?,
)
