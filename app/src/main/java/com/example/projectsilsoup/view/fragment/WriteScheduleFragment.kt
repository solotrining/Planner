package com.example.projectsilsoup.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectsilsoup.R
import com.example.projectsilsoup.databinding.FragmentWriteScheduleBinding
import com.example.projectsilsoup.view.activity.WriteEveryDayScheduleActivity
import com.example.projectsilsoup.view.activity.WritePeriodActivity


class WriteScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWriteScheduleBinding.inflate(inflater, container, false)

        binding.periodSchedule.setOnClickListener { startActivity(Intent(context, WritePeriodActivity::class.java)) }
        binding.everydaySchedule.setOnClickListener { startActivity(Intent(context, WriteEveryDayScheduleActivity::class.java)) }
        return binding.root
    }

}