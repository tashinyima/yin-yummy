package com.example.yinyummy.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yinyummy.databinding.ActivityStartBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}