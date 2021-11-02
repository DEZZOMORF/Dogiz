package com.lampa.dogiz.util.custom_view

import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import com.lampa.dogiz.util.ProfileSliderTransformer
import kotlin.math.abs

class CardSliderTransformer(private val translation: Float) : ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        page.apply {
            ViewCompat.setElevation(page, -abs(position))
            val translationFactor = -(width / translation) * position
            translationX = translationFactor
        }
    }
}