package com.learn.learn.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.learn.learn.R

class AnswersAdapter(private var answers: List<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return answers.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.answers_list, parent, false)
            holder = ViewHolder()
            holder.answerTextView = view.findViewById(R.id.answer)
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        holder.answerTextView?.text = answers[position]
        return view
    }

    private class ViewHolder {
        var answerTextView: TextView? = null
    }
}