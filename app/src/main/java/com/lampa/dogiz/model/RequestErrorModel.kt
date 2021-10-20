package com.lampa.dogiz.model

import com.lampa.dogiz.util.ErrorCode

data class RequestErrorModel(
    val errorCode: ErrorCode,
    val message: String?
)