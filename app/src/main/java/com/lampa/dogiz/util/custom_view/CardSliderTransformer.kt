package com.lampa.dogiz.util.custom_view

import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class CardSliderTransformer() : ViewPager2.PageTransformer {

    companion object {
        private const val DEFAULT_TRANSLATION_FACTOR = 70f
    }

    override fun transformPage(page: View, position: Float) {
        page.apply {
            ViewCompat.setElevation(page, -abs(position))
            val translationFactor = -(width / DEFAULT_TRANSLATION_FACTOR) * position
            translationX = translationFactor
        }
    }
}