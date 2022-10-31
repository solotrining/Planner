package com.example.projectsilsoup.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectsilsoup.R
import com.example.projectsilsoup.databinding.FragmentMainBinding
import com.example.projectsilsoup.network.room.entity.ScheduleEntity
import com.example.projectsilsoup.vm.fragment.ScheduleModel
import java.util.*

class MainFragment : Fragment() {

    private val model = ScheduleModel.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        val cal = Calendar.getInstance()

        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        val nowPlan : List<ScheduleEntity> = model.getPlanByDate("${year}-${month}-${day}")

        if (nowPlan.isNotEmpty()) binding.todayPlan.text = nowPlan[0].title

        return binding.root
    }

}