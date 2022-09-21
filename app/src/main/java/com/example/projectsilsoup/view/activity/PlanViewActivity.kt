package com.example.projectsilsoup.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectsilsoup.databinding.ActivityPlanViewBinding

class PlanViewActivity : AppCompatActivity() {

    private val binding by lazy { ActivityPlanViewBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}