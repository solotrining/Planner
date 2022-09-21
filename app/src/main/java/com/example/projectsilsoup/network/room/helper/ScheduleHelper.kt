package com.example.projectsilsoup.network.room.helper

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projectsilsoup.network.room.dao.ScheduleDao
import com.example.projectsilsoup.network.room.entity.ScheduleEntity

@Database(entities = [ScheduleEntity::class], version = 1, exportSchema = false)
abstract class ScheduleHelper : RoomDatabase() {
    abstract fun scheduleDao() : ScheduleDao
}