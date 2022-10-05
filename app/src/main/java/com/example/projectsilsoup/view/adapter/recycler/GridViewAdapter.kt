package com.example.projectsilsoup.view.adapter.recycler

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsilsoup.category.Category
import com.example.projectsilsoup.databinding.ItemScheduleBinding
import com.example.projectsilsoup.network.room.entity.ScheduleEntity
import com.example.projectsilsoup.view.activity.PlanViewActivity
import java.text.SimpleDateFormat
import java.time.LocalDate

class GridViewAdapter(val list: List<ScheduleEntity>) : RecyclerView.Adapter<GridViewAdapter.Holder>() {


    inner class Holder(private var binding : ItemScheduleBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        fun setView(item : ScheduleEntity) {
            binding.title.text = item.title
            binding.content.text = item.content
            if (item.category == Category.PERIOD.toString() && item.date != null){
                val sdf = SimpleDateFormat("yyyy-MM-dd")
                val now = sdf.parse(LocalDate.now().toString())
                val finishDate = sdf.parse(item.date!!.split("~")[1])

                val compare = finishDate!!.compareTo(now)

                if (compare < 0) binding.title.setBackgroundColor(Color.parseColor("#EBECEB"))
                else binding.title.setBackgroundColor(Color.parseColor("#A6E8FD"))

            } else binding.title.setBackgroundColor(Color.parseColor("#BFE6BA"))



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