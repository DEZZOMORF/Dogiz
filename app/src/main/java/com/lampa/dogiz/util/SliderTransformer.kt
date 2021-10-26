package com.lampa.dogiz.util

import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class SliderTransformer(private val offscreenPageLimit: Int) : ViewPager2.PageTransformer {

    companion object {

        private const val DEFAULT_TRANSLATION_X = .0f
        private const val DEFAULT_TRANSLATION_FACTOR = 1.35f

        private const val SCALE_FACTOR = .30f
        private const val DEFAULT_SCALE = 1f

        private const val ALPHA_FACTOR = .5f
        private const val DEFAULT_ALPHA = 1f

    }

    override fun transformPage(page: View, position: Float) {

        page.apply {

            ViewCompat.setElevation(page, -abs(position))

            val scaleFactor = -SCALE_FACTOR * position + DEFAULT_SCALE
            val alphaFactor = -ALPHA_FACTOR * position + DEFAULT_ALPHA

            when {
                position >= -offscreenPageLimit + 1 && position <= 0f -> {
                    scaleX = -SCALE_FACTOR * -position + DEFAULT_SCALE
                    scaleY = -SCALE_FACTOR * -position + DEFAULT_SCALE
                    translationX = -(width / DEFAULT_TRANSLATION_FACTOR) * position
                    alpha = -ALPHA_FACTOR * -position + DEFAULT_ALPHA
                }
                position <= offscreenPageLimit - 1 && position >= 0 -> {
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                    translationX = -(width / DEFAULT_TRANSLATION_FACTOR) * position
                    alpha = alphaFactor
                }
                else -> {
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                    translationX = DEFAULT_TRANSLATION_X
                    alpha = DEFAULT_ALPHA
                }
            }
        }
    }
}