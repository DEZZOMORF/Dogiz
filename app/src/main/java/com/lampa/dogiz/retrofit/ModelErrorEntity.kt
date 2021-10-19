package com.lampa.dogiz.retrofit

class ModelErrorEntity(
    val code: Int
) {
    val message: String get() = "Request error with code $code"
}