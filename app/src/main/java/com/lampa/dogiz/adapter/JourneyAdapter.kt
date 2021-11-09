package com.lampa.dogiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lampa.dogiz.databinding.JourneyItemBinding
import com.lampa.dogiz.model.Journey
import com.lampa.dogiz.util.Logger
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class JourneyAdapter @Inject constructor() : RecyclerView.Adapter<JourneyAdapter.ViewHolder>() {

    var list: List<Journey> = listOf()
    private val limit = 4

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(JourneyItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindView()
    }

    override fun getItemCount(): Int {
        return if(list.size > limit){
            limit;
        } else {
            list.size;
        }
    }

    inner class ViewHolder(private val binding: JourneyItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView() {
            try {
                val pattern = "dd MMM"
                val thisItemDate = SimpleDateFormat(pattern, Locale.ENGLISH).format(list[adapterPosition].date)
                val previousItemDate = if (adapterPosition != 0) SimpleDateFormat (pattern, Locale.ENGLISH).format(list[adapterPosition - 1].date) else 0
                if (adapterPosition == 0 || thisItemDate != previousItemDate) binding.date = thisItemDate
                binding.data = list[adapterPosition]
            } catch (e:Exception) {
                Logger(e.message)
            }
        }
    }
}