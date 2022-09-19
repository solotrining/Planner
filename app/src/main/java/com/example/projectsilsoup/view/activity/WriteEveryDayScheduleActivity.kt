package com.example.projectsilsoup.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projectsilsoup.R
import com.example.projectsilsoup.databinding.ActivityWriteBinding

class WriteEveryDayScheduleActivity : AppCompatActivity() {

    private val binding by lazy { ActivityWriteBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setInvisible()
    }

    fun setInvisible() {
        binding.startDay.visibility = View.GONE
        binding.startMonth.visibility = View.GONE
        binding.finishDay.visibility = View.GONE
        binding.finishMonth.visibility = View.GONE
        binding.textView4.visibility = View.GONE
        binding.textView5.visibility = View.GONE
        binding.textView6.visibility = View.GONE
    }
}