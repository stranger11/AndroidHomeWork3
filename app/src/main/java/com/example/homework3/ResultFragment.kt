package com.example.homework3

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

private const val RESULT = "param1"

class ResultFragment : Fragment() {

    private var result: Int? = null
    private lateinit var begin : Button
    private var newPosition = 0
    private lateinit var colorResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            result = it.getInt(RESULT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_result, container, false)
        root.findViewById<TextView>(R.id.text_res).text = result.toString()
        return root
    }

    override fun onStart() {
        super.onStart()
        colorResult = view!!.findViewById(R.id.text_res)
        if (result!! > 3) colorResult.setTextColor(Color.GREEN)
        else colorResult.setTextColor(Color.RED)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        begin = view!!.findViewById(R.id.button_start)
        begin.setOnClickListener {
            transaction.replace(R.id.fragment_container,
                QuestionsFragment.newInstance(newPosition))
            transaction.commit()
        }
    }

    override fun onStop() {
        super.onStop()
        begin.setOnClickListener(null)
    }

    companion object {
        @JvmStatic
        fun newInstance(result: Int) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putInt(RESULT, result)
                }
            }
    }
}