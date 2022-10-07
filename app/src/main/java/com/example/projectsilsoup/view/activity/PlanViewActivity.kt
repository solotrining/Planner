package com.example.projectsilsoup.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectsilsoup.databinding.ActivityPlanViewBinding

class PlanViewActivity : AppCompatActivity() {

    private val binding by lazy { ActivityPlanViewBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent
        val mapping = intent.getStringExtra("mapping")
        val error = intent.getStringExtra("error")
        val date = intent.getStringExtra("date")
        val category = intent.getStringExtra("category")

        binding.viewTitle.text = intent.getStringExtra("title")
        binding.viewId.text = intent.getIntExtra("id", 0).toString()
        binding.viewContent.text =intent.getStringExtra("content")



    }
}