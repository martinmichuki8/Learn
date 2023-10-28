package com.learn.learn.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.learn.learn.R

class QuizResult : Fragment() {
    override fun onCreateView(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.results, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {}
}