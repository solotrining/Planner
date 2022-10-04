package com.example.projectsilsoup.view.adapter.recycler

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsilsoup.R
import com.example.projectsilsoup.category.Category
import com.example.projectsilsoup.databinding.ItemScheduleBinding
import com.example.projectsilsoup.network.room.entity.ScheduleEntity
import com.example.projectsilsoup.view.activity.PlanViewActivity

class GridViewAdapter : RecyclerView.Adapter<GridViewAdapter.Holder>() {
    var list = mutableListOf<ScheduleEntity>()

    inner class Holder(private var binding : ItemScheduleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setView(item : ScheduleEntity) {
            binding.title.text = item.title
            binding.content.text = item.content
            if (item.category == Category.PERIOD.toString()){
                Log.e("카테고리", "기간계획")
                binding.title.setBackgroundColor(Color.parseColor("#A6E8FD"))
            }else {
                binding.title.setBackgroundColor(Color.parseColor("#BFE6BA"))
            }


            itemView.setOnClickListener {
                Intent(itemView.context, PlanViewActivity::class.java)
                    .putExtra("title", item.title)
                    .putExtra("content", item.content)
                    .putExtra("category", item.category)
                    .putExtra("date", item.date)
                    .putExtra("id", item.id)
                    .putExtra("error", item.error)
                    .putExtra("mapping", item.mapping)
                    .putExtra("finish", item.isFinish)
                    .run { itemView.context.startActivity(this) }
            }
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