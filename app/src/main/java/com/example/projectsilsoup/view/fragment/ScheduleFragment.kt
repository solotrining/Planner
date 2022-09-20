package com.example.projectsilsoup.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.projectsilsoup.R
import com.example.projectsilsoup.databinding.FragmentScheduleBinding
import com.example.projectsilsoup.listener.ItemSelectedListenerSchedule


class ScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentScheduleBinding.inflate(inflater, container, false)

        val items = resources.getStringArray(R.array.spinner_array)
        val adapter = ArrayAdapter<String>(requireContext(), com.google.android.material.R.layout.support_simple_spinner_dropdown_item, items)

        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = ItemSelectedListenerSchedule()

        return binding.root
    }

}