package com.lampa.dogiz.util

import android.util.Log

class Logger(msg: String?) {
    init {
        Log.e("TAG", "Logger: ${msg.toString()}")
    }
}