package com.example.projectsilsoup.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.projectsilsoup.R
import com.example.projectsilsoup.category.Category
import com.example.projectsilsoup.databinding.ActivityWriteBinding
import com.example.projectsilsoup.listener.textchanged.WriteEveryDayScheduleTextChanged
import com.example.projectsilsoup.network.room.entity.ScheduleEntity
import com.example.projectsilsoup.vm.activity.WriteScheduleModel

class
WriteEveryDayScheduleActivity : AppCompatActivity() {

    private val binding by lazy { ActivityWriteBinding.inflate(layoutInflater) }

    private val model = WriteScheduleModel.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setInvisible()

        binding.periodTitle.addTextChangedListener(WriteEveryDayScheduleTextChanged(binding, model, this))
        binding.periodContent.addTextChangedListener(WriteEveryDayScheduleTextChanged(binding, model, this))

        binding.write.setOnClickListener {
            val entity = ScheduleEntity(binding.periodTitle.text.toString(), binding.periodContent.text.toString(), Category.EVERYDAY.toString(), false)
            entity.mapping = binding.periodMapping.text.toString()
            entity.error = binding.periodWarningContent.text.toString()
            model.insertAndUpdate(entity)
        }

    }

    private fun setInvisible() {
        binding.startDate.visibility = View.INVISIBLE
        binding.startDateText.visibility = View.INVISIBLE
        binding.finishDate.visibility = View.INVISIBLE
        binding.finishDateText.visibility = View.INVISIBLE
    }
}