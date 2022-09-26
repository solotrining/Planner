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

class WriteEveryDayScheduleActivity : AppCompatActivity() {

    private val binding by lazy { ActivityWriteBinding.inflate(layoutInflater) }

    private val model = WriteScheduleModel.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setInvisible()

        binding.periodTitle.addTextChangedListener(WriteEveryDayScheduleTextChanged(binding, model, this))
        binding.periodContent.addTextChangedListener(WriteEveryDayScheduleTextChanged(binding, model, this))

    }

    private fun setInvisible() {
        binding.startDay.visibility = View.GONE
        binding.startMonth.visibility = View.GONE
        binding.finishDay.visibility = View.GONE
        binding.finishMonth.visibility = View.GONE
        binding.textView4.visibility = View.GONE
        binding.textView5.visibility = View.GONE
        binding.textView6.visibility = View.GONE
    }
}