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


class ScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentScheduleBinding.inflate(inflater, container, false)

        val items = resources.getStringArray(R.array.spinner_array)
        val adapter = ArrayAdapter<String>(requireContext(), com.google.android.material.R.layout.support_simple_spinner_dropdown_item, items)

        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        Log.e("0", "전체 불러오기")
                    }

                    1 -> {
                        Log.e("1", "끝난 계획 불러오기")
                    }

                    2 -> {
                        Log.e("2", "기간 계획 불러오기")
                    }

                    3 -> {
                        Log.e("3", "매일 계획 불러오기")
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.e("아무것도 선택안됨", "전체 불러오셈ㅇㅇ")
            }
        }

        return binding.root
    }

}