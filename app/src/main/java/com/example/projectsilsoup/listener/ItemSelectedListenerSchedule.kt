package com.example.projectsilsoup.listener

import android.util.Log
import android.view.View
import android.widget.AdapterView

class ItemSelectedListenerSchedule : AdapterView.OnItemSelectedListener {
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