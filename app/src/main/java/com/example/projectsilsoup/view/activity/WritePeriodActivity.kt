package com.example.projectsilsoup.view.activity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.projectsilsoup.databinding.ActivityWriteBinding

import com.example.projectsilsoup.listener.textchanged.WritePeriodScheduleTextChanged
import com.example.projectsilsoup.vm.activity.WriteScheduleModel
import java.util.*

class WritePeriodActivity : AppCompatActivity() {

    private val binding by lazy { ActivityWriteBinding.inflate(layoutInflater) }

    private val model = WriteScheduleModel.getInstance()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val textChanged = WritePeriodScheduleTextChanged(binding, model,this)

        binding.periodTitle.addTextChangedListener(textChanged)
        binding.periodContent.addTextChangedListener(textChanged)
        binding.startDate.addTextChangedListener(textChanged)
        binding.finishDate.addTextChangedListener(textChanged)

        binding.startDate.setOnClickListener {
            val cal = Calendar.getInstance()
            val data = DatePickerDialog.OnDateSetListener { view, year, month, day ->
                binding.startDate.text = "${year}-${month}-${day}"
            }
            DatePickerDialog(this, data, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.finishDate.setOnClickListener {
            val cal = Calendar.getInstance()
            val data = DatePickerDialog.OnDateSetListener { view, year, month, day ->
                binding.finishDate.text = "${year}-${month}-${day}"
            }
            DatePickerDialog(this, data, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
}