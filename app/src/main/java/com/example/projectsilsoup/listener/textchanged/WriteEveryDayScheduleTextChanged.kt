package com.example.projectsilsoup.listener.textchanged

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import com.example.projectsilsoup.R
import com.example.projectsilsoup.category.Category
import com.example.projectsilsoup.databinding.ActivityWriteBinding
import com.example.projectsilsoup.network.room.entity.ScheduleEntity
import com.example.projectsilsoup.vm.activity.WriteScheduleModel

class WriteEveryDayScheduleTextChanged(var binding : ActivityWriteBinding,
                                       var model : WriteScheduleModel,
                                       var context : Context) : TextWatcher {
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if ( binding.periodTitle.text.toString() != "" && binding.periodContent.text.toString() != "") {
            binding.write.setTextColor(context.getColor(R.color.black))
            binding.write.setOnClickListener {
                val entity = ScheduleEntity(binding.periodTitle.text.toString(), binding.periodContent.text.toString(), Category.EVERYDAY.toString(), false)
                entity.error = binding.periodWarningContent.text.toString()
                entity.mapping = binding.periodMapping.text.toString()
                model.insertAndUpdate(entity)
            }
        } else {
            binding.write.setTextColor(context.getColor(R.color.gray))
            binding.write.setOnClickListener {}
        }
    }

    override fun afterTextChanged(p0: Editable?) {

    }
}