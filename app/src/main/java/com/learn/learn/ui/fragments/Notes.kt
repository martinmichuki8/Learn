package com.learn.learn.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.learn.learn.R
import com.learn.learn.interfaces.UpdateUi

class Notes(private var updateUi: UpdateUi) : Fragment() {
    private var upNext: ConstraintLayout? = null
    override fun onCreateView(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.notes, parent, false)
        upNext = view.findViewById(R.id.upNext)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        upNext!!.setOnClickListener { updateUi.updateScreen("quiz") }
    }
}