package com.lampa.dogiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lampa.dogiz.databinding.ItemDogBinding
import com.lampa.dogiz.retrofit.DogEntity
import javax.inject.Inject

class DogProfilesViewPagerAdapter @Inject constructor() : RecyclerView.Adapter<DogProfilesViewPagerAdapter.ViewHolder>() {

    var list: List<DogEntity> = listOf()
    var onItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDogBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindView()
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(private val binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView() {
            binding.data = list[adapterPosition]
            binding.profileImage.setOnClickListener {
                onItemClickListener?.invoke(adapterPosition)
            }
        }
    }
}