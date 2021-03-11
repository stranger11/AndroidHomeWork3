package com.example.homework3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FirstFragment : Fragment() {
    private var pos = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<View>(R.id.button1)?.setOnClickListener {
            (requireActivity() as MyInterface).startQuestions()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}