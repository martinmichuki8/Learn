package com.learn.learn.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.learn.learn.R
import com.learn.learn.adapter.AnswersAdapter
import com.learn.learn.interfaces.UpdateUi

class Quiz(private var updateUi: UpdateUi) : Fragment() {

    private var upNext: ConstraintLayout? = null
    private var answersList: ListView? = null
    private var answers: MutableList<String>? = null
    private var answersAdapter: AnswersAdapter? = null

    override fun onCreateView(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.quiz, parent, false)
        upNext = view.findViewById(R.id.upNext)
        answersList = view.findViewById(R.id.answers_list)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAnswersList()
        answersAdapter = answers?.let { AnswersAdapter(it) }
        answersList!!.adapter = answersAdapter
        upNext!!.setOnClickListener { updateUi.updateScreen("results") }
    }

    private fun setAnswersList() {
        answers = ArrayList()
        (answers as ArrayList<String>).add("Increase in mass, cell differentiation")
        (answers as ArrayList<String>).add("Increase in number of individuals, sell differentiation")
        (answers as ArrayList<String>).add("Increase in mass, Increase in number of differentiation")
        (answers as ArrayList<String>).add("Cell differentiation, cell organisation")
    }
}