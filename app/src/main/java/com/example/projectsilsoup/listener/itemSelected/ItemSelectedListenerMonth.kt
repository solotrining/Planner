package com.example.projectsilsoup.listener.itemSelected

import android.util.Log
import android.view.View
import android.widget.AdapterView

class ItemSelectedListenerMonth : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            0 -> {
                Log.e(position.toString(), (position + 1).toString())
            }

            1 -> {
                Log.e(position.toString(), (position + 1).toString())
            }

            2 -> {
                Log.e(position.toString(), (position + 1).toString())
            }

            3 -> {
                Log.e(position.toString(), (position + 1).toString())
            }

            4 -> {
                Log.e(position.toString(), (position + 1).toString())
            }

            5 -> {
                Log.e(position.toString(), (position + 1).toString())
            }

            6 -> {
                Log.e(position.toString(), (position + 1).toString())
            }

            7 -> {
                Log.e(position.toString(), (position + 1).toString())
            }

            8 -> {
                Log.e(position.toString(), (position + 1).toString())
            }

            9 -> {
                Log.e(position.toString(), (position + 1).toString())
            }

            10 -> {
                Log.e(position.toString(), (position + 1).toString())
            }

            11 -> {
                Log.e(position.toString(), (position + 1).toString())
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}