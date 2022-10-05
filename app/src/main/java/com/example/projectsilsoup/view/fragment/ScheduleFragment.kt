package com.example.projectsilsoup.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projectsilsoup.R
import com.example.projectsilsoup.databinding.FragmentScheduleBinding
import com.example.projectsilsoup.listener.itemSelected.ItemSelectedListenerSchedule
import com.example.projectsilsoup.network.room.entity.ScheduleEntity
import com.example.projectsilsoup.view.adapter.recycler.GridViewAdapter
import com.example.projectsilsoup.view.adapter.recycler.decoration.RecyclerDecorationHeight
import com.example.projectsilsoup.view.adapter.recycler.decoration.RecyclerDecorationWidth
import com.example.projectsilsoup.vm.fragment.ScheduleModel


class ScheduleFragment : Fragment() {

    private var scheduleList : List<ScheduleEntity>? = null
    private val model = ScheduleModel.getInstance()
    private val itemSelectedListenerSchedule = ItemSelectedListenerSchedule(model)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentScheduleBinding.inflate(inflater, container, false)

        val items = resources.getStringArray(R.array.spinner_array)
        val spinnerAdapter = ArrayAdapter(requireContext(), com.google.android.material.R.layout.support_simple_spinner_dropdown_item, items)

        binding.spinner.adapter = spinnerAdapter

        binding.spinner.onItemSelectedListener = itemSelectedListenerSchedule

        scheduleList = model.getAll()


        val recyclerAdapter = GridViewAdapter(scheduleList!!)

        binding.scheduleRecycler.addItemDecoration(RecyclerDecorationHeight(50))
        binding.scheduleRecycler.addItemDecoration(RecyclerDecorationWidth(30))
        binding.scheduleRecycler.adapter = recyclerAdapter
        binding.scheduleRecycler.layoutManager = GridLayoutManager(context,2)

        itemSelectedListenerSchedule.list.observe(this.viewLifecycleOwner) {
            binding.scheduleRecycler.adapter = GridViewAdapter(it)
        }

        return binding.root
    }




}