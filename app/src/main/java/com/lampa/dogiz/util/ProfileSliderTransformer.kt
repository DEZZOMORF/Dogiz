package com.lampa.dogiz.util

import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class ProfileSliderTransformer(private val offscreenPageLimit: Int) : ViewPager2.PageTransformer {

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

            val scaleRight = -SCALE_FACTOR * position + DEFAULT_SCALE
            val scaleLeft = -SCALE_FACTOR * -position + DEFAULT_SCALE
            val alphaRight = -ALPHA_FACTOR * position + DEFAULT_ALPHA
            val alphaLeft = -ALPHA_FACTOR * -position + DEFAULT_ALPHA
            val translationFactor = -(width / DEFAULT_TRANSLATION_FACTOR) * position

            when {
                position <= offscreenPageLimit - 1 && position <= 0f -> {
                    scaleX = scaleLeft
                    scaleY = scaleLeft
                    alpha = alphaLeft
                    translationX = translationFactor
                }
                position <= offscreenPageLimit - 1 && position >= 0 -> {
                    scaleX = scaleRight
                    scaleY = scaleRight
                    alpha = alphaRight
                    translationX = translationFactor
                }
                else -> {
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                    alpha = DEFAULT_ALPHA
                    translationX = DEFAULT_TRANSLATION_X
                }
            }
        }
    }
}