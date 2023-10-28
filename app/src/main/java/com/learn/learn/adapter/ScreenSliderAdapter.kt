package com.learn.learn.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.learn.learn.interfaces.UpdateUi
import com.learn.learn.ui.fragments.Notes
import com.learn.learn.ui.fragments.Quiz
import com.learn.learn.ui.fragments.QuizResult
import com.learn.learn.ui.fragments.VideoScreen

class ScreenSliderAdapter(fragmentActivity: FragmentActivity, private var updateUi: UpdateUi) :
    FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        VideoScreen(updateUi)
        return when (position) {
            1 -> Notes(updateUi)
            2 -> Quiz(updateUi)
            3 -> QuizResult()
            else -> VideoScreen(updateUi)
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}