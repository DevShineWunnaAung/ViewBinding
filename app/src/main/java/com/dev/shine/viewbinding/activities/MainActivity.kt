package com.dev.shine.viewbinding.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.shine.viewbinding.adapter.ViewPagerAdapter
import com.dev.shine.viewbinding.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // ViewPager
        viewPagerAdapter = ViewPagerAdapter(this)
        binding.vpMain.adapter = viewPagerAdapter

        // TabLayout
        TabLayoutMediator(binding.tlMain, binding.vpMain){ tab, position ->
            when(position){
                0 -> tab.text = "RecycleView Page"
                1 -> tab.text = "Inflate Page"
                else -> tab.text = "Bind Page"
            }
        }.attach()

    }


}