package com.lampa.dogiz.util.custom_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lampa.dogiz.*
import com.lampa.dogiz.databinding.CardItemBigButtonBinding
import com.lampa.dogiz.databinding.CardItemBigImageBinding
import com.lampa.dogiz.databinding.CardItemSimpleBinding
import android.content.Context

class CardViewPagerAdapter constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: List<CardModel> = listOf()
    var style: Int = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (style) {
            1 -> NotificationViewHolder(CardItemSimpleBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
            2 -> BigImageViewHolder(CardItemBigImageBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
            3 -> BigButtonViewHolder(CardItemBigButtonBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
            else -> DefaultViewHolder(CardItemSimpleBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as? ViewHolder)?.bindView()
    }

    override fun getItemCount() = list.size

    inner class DefaultViewHolder(private val binding: CardItemSimpleBinding) : ViewHolder(binding.root) {
        override fun bindView() {
            binding.data = list[adapterPosition]
            checkPositionMargin(itemView.context, adapterPosition, binding.card)
            list[adapterPosition].onClickListener?.let { click -> binding.button.setOnClickListener { click.invoke() } }
        }
    }

    inner class NotificationViewHolder(private val binding: CardItemSimpleBinding) : ViewHolder(binding.root) {
        override fun bindView() {
            binding.data = list[adapterPosition]
            binding.imageView.setImageResource(R.drawable.notification)
            binding.card.setCardBackgroundColor(ContextCompat.getColor(binding.card.context, R.color.notification_red))
            checkPositionMargin(itemView.context, adapterPosition, binding.card)
            list[adapterPosition].onClickListener?.let { click -> binding.button.setOnClickListener { click.invoke() } }
        }
    }

    inner class BigImageViewHolder(private val binding: CardItemBigImageBinding) : ViewHolder(binding.root) {
        override fun bindView() {
            binding.data = list[adapterPosition]
            checkPositionMargin(itemView.context, adapterPosition, binding.card)
            list[adapterPosition].onClickListener?.let { click -> binding.card.setOnClickListener { click.invoke() } }
        }
    }

    inner class BigButtonViewHolder(private val binding: CardItemBigButtonBinding) : ViewHolder(binding.root) {
        override fun bindView() {
            binding.data = list[adapterPosition]
            checkPositionMargin(itemView.context, adapterPosition, binding.card)
            list[adapterPosition].onClickListener?.let { click -> binding.button.setOnClickListener { click.invoke() } }

        }
    }

    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bindView()
    }

    private fun checkPositionMargin(context: Context, position: Int, card: CardView) {
        val width: Int = context.resources.getDimension(R.dimen.card_width).toInt()
        val margin: Int = context.resources.getDimension(R.dimen.card_margin).toInt()
        val cardViewParams: LinearLayout.LayoutParams

        if (list.size == 1) {
            cardViewParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            cardViewParams.marginStart = margin
            cardViewParams.marginEnd = margin
        } else {
            cardViewParams = LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT);
            when (position) {
                0 -> {
                    cardViewParams.marginStart = margin
                    cardViewParams.marginEnd = margin / 2
                }
                list.size - 1 -> {
                    cardViewParams.marginStart = margin / 2
                    cardViewParams.marginEnd = margin
                }
                else -> {
                    cardViewParams.marginStart = margin / 2
                    cardViewParams.marginEnd = margin / 2
                }
            }
        }
        cardViewParams.topMargin = margin / 4
        card.layoutParams = cardViewParams
    }
}