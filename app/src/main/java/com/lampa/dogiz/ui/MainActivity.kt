package com.lampa.dogiz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lampa.dogiz.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}