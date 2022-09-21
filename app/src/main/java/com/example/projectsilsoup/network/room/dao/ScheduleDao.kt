package com.example.projectsilsoup.network.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.projectsilsoup.network.room.entity.ScheduleEntity

@Dao
interface ScheduleDao {

    //Select
    @Query("select * from schedule")
    fun getAll() : List<ScheduleEntity>

    @Query("select * from schedule where isFinish = :finish")
    fun getFinishedPlan (finish : Boolean) : List<ScheduleEntity>

    @Query("select * from schedule where category = :category")
    fun getPlanByCategory(category : String) : List<ScheduleEntity>

    //Insert, Update
    @Insert (onConflict = REPLACE)
    fun insertPlan(schedule : ScheduleEntity)

    //Delete
    @Delete
    fun deletePlan(schedule: ScheduleEntity)
}