package com.example.projectsilsoup.listener.itemSelected

import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.MutableLiveData
import com.example.projectsilsoup.category.Category
import com.example.projectsilsoup.network.room.entity.ScheduleEntity
import com.example.projectsilsoup.network.room.helper.ScheduleHelper
import com.example.projectsilsoup.vm.fragment.ScheduleModel

class ItemSelectedListenerSchedule(private val model: ScheduleModel) : AdapterView.OnItemSelectedListener {

    val list = MutableLiveData<List<ScheduleEntity>>()
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            0 -> {
                Log.e("0", "전체 불러오기")
                list.value = model.getAll()
                Log.e("list", list.value.toString())
            }

            1 -> {
                Log.e("1", "끝난 계획 불러오기")
                list.value = model.getFinishedPlan()
                Log.e("list", list.value.toString())
            }

            2 -> {
                Log.e("2", "기간 계획 불러오기")
                list.value = model.getPlanByCategory(Category.PERIOD.toString())
                Log.e("list", list.value.toString())
            }

            3 -> {
                Log.e("3", "매일 계획 불러오기")
                list.value = model.getPlanByCategory(Category.PERIOD.toString())
                Log.e("list", list.value.toString())
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Log.e("아무것도 선택안됨", "전체 불러오셈ㅇㅇ")
        list.value = model.getAll()
        Log.e("list", list.value.toString())
    }
}