package com.learn.learn.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.learn.learn.R
import com.learn.learn.adapter.ScreenSliderAdapter
import com.learn.learn.interfaces.UpdateUi

class Dashboard : AppCompatActivity() {

    private var viewPager2: ViewPager2? = null
    private var screenSliderAdapter: ScreenSliderAdapter? = null
    private var tabLayout: TabLayout? = null
    private var updateUi: UpdateUi? = null
    private var timeLeft: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        viewPager2 = findViewById(R.id.viewPager2)
        tabLayout = findViewById(R.id.tabLayout)
        timeLeft = findViewById(R.id.time_left);

        showTimeRemaining()

        updateUi = object : UpdateUi {
            override fun updateScreen(screen: String?) {
                when (screen) {
                    "notes" -> viewPager2?.setCurrentItem(1, true)
                    "quiz" -> viewPager2?.setCurrentItem(2, true)
                    "results" -> viewPager2?.setCurrentItem(3, true)
                }
            }
        }
        screenSliderAdapter = ScreenSliderAdapter(this@Dashboard, updateUi!!)
        viewPager2?.adapter = screenSliderAdapter
        TabLayoutMediator(tabLayout!!, viewPager2!!, TabConfigurationStrategy { tab, position ->
            when (position) {
                0 -> tab.text = "Video"
                1 -> tab.text = "Notes"
                2 -> tab.text = "Quiz"
                3 -> tab.text = "Quiz Results"
            }
        }).attach()
        viewPager2?.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })
    }
    private fun showTimeRemaining() {
        val totalTimeInMillis: Long = 10 * 60 * 1000 // 10 minutes in milliseconds
        val intervalInMillis: Long = 1000 // 1 second interval

        val countDownTimer = object : CountDownTimer(totalTimeInMillis, intervalInMillis) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                val formattedTime = String.format("%02d:%02d", minutes, seconds)
                timeLeft?.text = "$formattedTime min"
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                timeLeft?.text = "Time's Up!"
            }
        }

        countDownTimer.start()
    }

}