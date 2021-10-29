package com.lampa.dogiz.util.custom_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lampa.dogiz.databinding.CardItemBinding

class CardViewPagerAdapter constructor() : RecyclerView.Adapter<CardViewPagerAdapter.ViewHolder>() {

    var list: List<CardModel> = listOf()
    var onItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindView()
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(private val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView() {
            binding.data = list[adapterPosition]
        }
    }
}