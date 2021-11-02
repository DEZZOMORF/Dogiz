package com.lampa.dogiz.util.custom_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lampa.dogiz.R
import com.lampa.dogiz.databinding.CardItemBigImageBinding
import com.lampa.dogiz.databinding.CardItemSimpleBinding

class CardViewPagerAdapter constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: List<CardModel> = listOf()
    var style: Int = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (style) {
            1 -> NotificationViewHolder(CardItemSimpleBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
            2 -> BigImageViewHolder(CardItemBigImageBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
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
            checkPositionMargin(adapterPosition, binding.card)
            binding.button.setOnClickListener { list[adapterPosition].onClickListener?.invoke() }
        }
    }

    inner class NotificationViewHolder(private val binding: CardItemSimpleBinding) : ViewHolder(binding.root) {
        override fun bindView() {
            binding.data = list[adapterPosition]
            binding.imageView.setImageResource(R.drawable.notification)
            binding.card.setCardBackgroundColor(ContextCompat.getColor(binding.card.context, R.color.notification_red))
            checkPositionMargin(adapterPosition, binding.card)
            binding.button.setOnClickListener { list[adapterPosition].onClickListener?.invoke() }
        }
    }

    inner class BigImageViewHolder(private val binding: CardItemBigImageBinding) : ViewHolder(binding.root) {
        override fun bindView() {
            binding.data = list[adapterPosition]
            checkPositionMargin(adapterPosition, binding.card)
            binding.card.setOnClickListener { list[adapterPosition].onClickListener?.invoke() }
        }
    }

    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bindView()
    }

    private fun checkPositionMargin(position: Int, card: CardView){
        if(position == list.size-1) {
            val cardViewParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            cardViewParams.marginEnd = 0
            card.layoutParams = cardViewParams
        }
    }
}