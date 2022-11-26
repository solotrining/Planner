package com.example.projectsilsoup.view.activity

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.room.Room
import androidx.viewpager2.widget.ViewPager2
import com.example.projectsilsoup.R
import com.example.projectsilsoup.databinding.ActivityMainBinding
import com.example.projectsilsoup.network.alarm.Alarm
import com.example.projectsilsoup.network.room.helper.ScheduleHelper
import com.example.projectsilsoup.view.adapter.fragment.FragmentAdapter
import com.example.projectsilsoup.view.fragment.MainFragment
import com.example.projectsilsoup.view.fragment.ScheduleFragment
import com.example.projectsilsoup.view.fragment.WriteScheduleFragment
import com.example.projectsilsoup.vm.activity.WriteScheduleModel
import com.example.projectsilsoup.vm.fragment.ScheduleModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var alarmManager : AlarmManager

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        setAlarm()

        val helper = Room.databaseBuilder(this, ScheduleHelper::class.java, "schedule")

        val fragments = listOf(WriteScheduleFragment(), MainFragment(), ScheduleFragment())
        val adapter = FragmentAdapter(this, fragments)

        ScheduleModel.getInstance().setHelper(helper.allowMainThreadQueries().build())
        WriteScheduleModel.getInstance().setHelper(helper.allowMainThreadQueries().build())

        binding.viewPager.adapter = adapter
        binding.viewPager.currentItem = 1
        binding.viewPager.registerOnPageChangeCallback(PageChangerCallBack())

        binding.bottomNavigation.setOnItemSelectedListener {
            navigation(it)
        }
        binding.bottomNavigation.selectedItemId = R.id.item_main

    }

    private fun navigation(item: MenuItem) : Boolean{
        val check = item.setChecked(true)
        when (check.itemId) {
            R.id.item_write -> {
                binding.viewPager.currentItem = 0
                return true
            }

            R.id.item_main -> {
                binding.viewPager.currentItem = 1
                return true
            }

            R.id.item_schedule -> {
                binding.viewPager.currentItem = 2
                return true
            }
        }
        return false
    }

    inner class PageChangerCallBack : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.bottomNavigation.selectedItemId = when (position) {
                0 -> R.id.item_write
                1 -> R.id.item_main
                2 -> R.id.item_schedule
                else -> {Log.e("없는 아이디", "id")}
            }
        }
    }

    private fun setAlarm() {
        val receiverIntent = Intent(this@MainActivity, Alarm::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this@MainActivity, 0, receiverIntent, 0)
        val calendar: Calendar = Calendar.getInstance()

        val from = "${calendar.get(Calendar.YEAR)}-${calendar.get(Calendar.MONTH)}-${calendar.get(Calendar.DAY_OF_MONTH)} 20:00:00"

        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        var datetime: Date? = null
        try {
            datetime = dateFormat.parse(from)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        calendar.setTime(datetime)
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent)
    }

}