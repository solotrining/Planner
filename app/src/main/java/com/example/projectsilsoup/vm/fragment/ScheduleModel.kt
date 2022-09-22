package com.example.projectsilsoup.vm.fragment

import androidx.lifecycle.ViewModel
import com.example.projectsilsoup.network.room.entity.ScheduleEntity
import com.example.projectsilsoup.network.room.helper.ScheduleHelper

class ScheduleModel private constructor(): ViewModel() {


    companion object {
        private var context : ScheduleModel? = null
        fun getInstance() : ScheduleModel {
            if (context == null) {
                context = ScheduleModel()
                return context!!
            }
            return context!!
        }
    }

    private var helper : ScheduleHelper? = null

    fun setHelper(helper: ScheduleHelper) {
        this.helper = helper
    }

    fun getAll() : List<ScheduleEntity> {
        return helper?.scheduleDao()!!.getAll()
    }

    fun getFinishedPlan() : List<ScheduleEntity> {
        return helper?.scheduleDao()!!.getFinishedPlan(true)
    }

    fun getPlanByCategory(category : String) : List<ScheduleEntity> {
        return helper?.scheduleDao()!!.getPlanByCategory(category)
    }

    fun getPlanByDate(date : String) : List<ScheduleEntity> {
        return helper?.scheduleDao()!!.getPlanByDate(date)
    }

    fun deletePlan(entity: ScheduleEntity) {
        helper?.scheduleDao()!!.deletePlan(entity)
    }

    fun deleteAll(entities : List<ScheduleEntity>) {
        entities.forEach { helper?.scheduleDao()!!.deletePlan(it) }
    }


}