package com.example.projectsilsoup.view.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsilsoup.databinding.ItemScheduleBinding
import com.example.projectsilsoup.network.room.entity.ScheduleEntity

class GridViewAdapter : RecyclerView.Adapter<GridViewAdapter.Holder>() {
    var list = mutableListOf<ScheduleEntity>()

    inner class Holder(var binding : ItemScheduleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setView(item : ScheduleEntity) {
            binding.title.text = item.title
            binding.content.text = item.content

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}