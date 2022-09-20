package com.example.projectsilsoup.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.projectsilsoup.R
import com.example.projectsilsoup.databinding.ActivityWriteBinding
import com.example.projectsilsoup.listener.ItemSelectedListenerDay
import com.example.projectsilsoup.listener.ItemSelectedListenerMonth

class WritePeriodActivity : AppCompatActivity() {

    private val binding by lazy { ActivityWriteBinding.inflate(layoutInflater) }

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

    }
}