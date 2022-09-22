package com.example.projectsilsoup.vm.activity

import com.example.projectsilsoup.network.room.entity.ScheduleEntity
import com.example.projectsilsoup.network.room.helper.ScheduleHelper

class WriteAndEditScheduleModel {

    companion object {
        private var context : WriteAndEditScheduleModel? = null
        fun getInstance() : WriteAndEditScheduleModel {
            if (context == null) {
                context = WriteAndEditScheduleModel()
                return context!!
            }
            return context!!
        }
    }

    private var helper : ScheduleHelper? = null

    fun setHelper(helper: ScheduleHelper) {
        this.helper = helper
    }

    fun insertAndUpdate(entity : ScheduleEntity) {
        helper?.scheduleDao()!!.insertPlan(entity)
    }


}