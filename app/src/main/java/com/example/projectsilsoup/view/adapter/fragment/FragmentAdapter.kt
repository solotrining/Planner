package com.example.projectsilsoup.view.adapter.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter (FragmentActivity : FragmentActivity, list : List<Fragment>) : FragmentStateAdapter(FragmentActivity){

    var fragments = list

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}