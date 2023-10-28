package com.learn.learn.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView
import com.learn.learn.R
import com.learn.learn.interfaces.UpdateUi

class VideoScreen(private var updateUi: UpdateUi) : Fragment() {

    private var upNext: MaterialCardView? = null
    private var videoView: VideoView? = null

    override fun onCreateView(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.video_screen, parent, false)
        upNext = view.findViewById(R.id.upNext)
        videoView = view.findViewById(R.id.videoView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        upNext?.setOnClickListener {
            videoView!!.pause()
            updateUi.updateScreen("notes")
        }
    }
}