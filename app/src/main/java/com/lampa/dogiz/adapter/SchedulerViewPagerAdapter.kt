package com.lampa.dogiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lampa.dogiz.databinding.CardItemBinding
import com.lampa.dogiz.util.custom_view.CardModel
import com.lampa.dogiz.retrofit.hub.entity.content.ContentScheduleEntity
import javax.inject.Inject

class SchedulerViewPagerAdapter @Inject constructor() : RecyclerView.Adapter<SchedulerViewPagerAdapter.ViewHolder>() {

    var list: MutableList<ContentScheduleEntity> = mutableListOf()
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
            binding.data = CardModel(title = list[adapterPosition].title, text = list[adapterPosition].time)
        }
    }
}