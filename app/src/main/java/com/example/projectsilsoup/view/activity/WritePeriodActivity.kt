package com.example.projectsilsoup.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import com.example.projectsilsoup.R
import com.example.projectsilsoup.category.Category
import com.example.projectsilsoup.databinding.ActivityWriteBinding
import com.example.projectsilsoup.listener.itemSelected.ItemSelectedListenerDay
import com.example.projectsilsoup.listener.itemSelected.ItemSelectedListenerMonth
import com.example.projectsilsoup.network.room.entity.ScheduleEntity
import com.example.projectsilsoup.vm.activity.WriteScheduleModel

class WritePeriodActivity : AppCompatActivity() {

    private val binding by lazy { ActivityWriteBinding.inflate(layoutInflater) }

    private val model = WriteScheduleModel.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val monthItem = resources.getStringArray(R.array.month)
        val dayItem = resources.getStringArray(R.array.day)

        val monthAdapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, monthItem)
        val dayAdapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, dayItem)


        binding.startMonth.adapter = monthAdapter
        binding.finishMonth.adapter = monthAdapter

        binding.startDay.adapter = dayAdapter
        binding.finishDay.adapter = dayAdapter

        binding.startMonth.onItemSelectedListener = ItemSelectedListenerMonth()
        binding.finishMonth.onItemSelectedListener = ItemSelectedListenerMonth()
        binding.startDay.onItemSelectedListener = ItemSelectedListenerDay()
        binding.finishDay.onItemSelectedListener = ItemSelectedListenerDay()


        binding.write.addTextChangedListener {
            if (binding.periodTitle.text.toString() != "" && binding.periodContent.text.toString() != "") {
                binding.write.setTextColor(getColor(R.color.black))
                binding.write.setOnClickListener {

                    val entity = ScheduleEntity(binding.periodTitle.text.toString(), binding.periodContent.text.toString(), Category.PERIOD.toString(), false)
                    entity.error = binding.periodWarningContent.text.toString()
                    entity.mapping = binding.periodMapping.text.toString()
                    val date = "${binding.startMonth.selectedItem}/${binding.startDay.selectedItem} ~ ${binding.finishMonth.selectedItem}/${binding.finishDay.selectedItem}"
                    entity.date = date

                    model.insertAndUpdate(entity)
                }
            }else {
                binding.write.setTextColor(getColor(R.color.gray))
                binding.write.setOnClickListener {}
            }
        }

    }
}