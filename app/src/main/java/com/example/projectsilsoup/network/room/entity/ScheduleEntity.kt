package com.example.projectsilsoup.network.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedule")
class ScheduleEntity (@ColumnInfo var title : String,
                      @ColumnInfo var content : String,
                      @ColumnInfo var category: String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id : Long? = null

    @ColumnInfo(name = "Date")
    var date : String? = null

    @ColumnInfo(name = "ErrorContent")
    var error : String? = null

    @ColumnInfo(name = "Mapping")
    var mapping : String? = null


}