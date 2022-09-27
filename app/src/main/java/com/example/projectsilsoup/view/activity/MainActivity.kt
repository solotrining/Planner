package com.example.projectsilsoup.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.room.Room
import androidx.viewpager2.widget.ViewPager2
import com.example.projectsilsoup.R
import com.example.projectsilsoup.databinding.ActivityMainBinding
import com.example.projectsilsoup.network.room.helper.ScheduleHelper
import com.example.projectsilsoup.view.adapter.fragment.FragmentAdapter
import com.example.projectsilsoup.view.fragment.MainFragment
import com.example.projectsilsoup.view.fragment.ScheduleFragment
import com.example.projectsilsoup.view.fragment.WriteScheduleFragment
import com.example.projectsilsoup.vm.activity.WriteScheduleModel
import com.example.projectsilsoup.vm.fragment.ScheduleModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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


}