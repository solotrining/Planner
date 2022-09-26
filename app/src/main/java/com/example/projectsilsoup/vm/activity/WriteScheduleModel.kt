package com.example.projectsilsoup.vm.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectsilsoup.network.room.entity.ScheduleEntity
import com.example.projectsilsoup.network.room.helper.ScheduleHelper

class WriteScheduleModel private constructor() : ViewModel(){

    companion object {
        private var context : WriteScheduleModel? = null

        fun getInstance() : WriteScheduleModel {
            if (context == null) {
                context = WriteScheduleModel()
                return context!!
            }
            return context!!
        }
    }

    private var helper : ScheduleHelper? = null

    private var title = MutableLiveData<String>()
    private var content = MutableLiveData<String>()

    fun setHelper(helper: ScheduleHelper) {
        this.helper = helper
    }

    fun insertAndUpdate(entity : ScheduleEntity) {
        helper?.scheduleDao()!!.insertPlan(entity)
    }

}