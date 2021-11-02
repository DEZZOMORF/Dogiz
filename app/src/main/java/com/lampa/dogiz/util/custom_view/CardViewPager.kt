package com.lampa.dogiz.util.custom_view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2
import com.lampa.dogiz.R

class CardViewPager(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    var cardViewPagerAdapter: CardViewPagerAdapter = CardViewPagerAdapter()
    var cardList: List<CardModel> = listOf()
        set(list) = initViewPager(list)

    private var pagerName: String? = null
    private var pagerButtonVisibility: Boolean = false
    private var style: Int = 0

    var name: TextView
    var button: ImageView
    var viewPager: ViewPager2

    init {
        inflate(context, R.layout.card_view_pager, this)
        name = findViewById(R.id.pagerName)
        button = findViewById(R.id.pagerButton)
        viewPager = findViewById(R.id.cardPager)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CardViewPager)
        pagerButtonVisibility = attributes.getBoolean(R.styleable.CardViewPager_pagerButtonVisibility, false)
        style = attributes.getInt(R.styleable.CardViewPager_style, 0)
        pagerName = attributes.getString(R.styleable.CardViewPager_pagerName)

        attributes.recycle()

        if (pagerButtonVisibility) button.visibility = VISIBLE else button.visibility = GONE
        if (pagerName != null) {
            name.visibility = VISIBLE
            name.text = pagerName
        }
    }

    private fun initViewPager(list: List<CardModel>) {
        with(viewPager) {
            adapter = cardViewPagerAdapter
            cardViewPagerAdapter.style = style
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            offscreenPageLimit = 3
            setPageTransformer(
                CardSliderTransformer(12.5F)
            )
            cardViewPagerAdapter.list = list
        }
    }
}