package com.example.homework3

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView


private const val ID = "param1"

class QuestionsFragment : Fragment() {

    private lateinit var resultButton: Button
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var layoutWithButtons: ViewGroup
    private var position: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(
            R.layout.fragment_questions,
            container,
            false)
        val questionsList = resources.getStringArray(R.array.questions)
        root.findViewById<TextView>(R.id.question1).text = questionsList.getOrNull(position)
        return root
    }

    override fun onStart() {
        super.onStart()
        resultButton = view!!.findViewById(R.id.button_res)
        layoutWithButtons = view!!.findViewById(R.id.questions_layout)
        yesButton = view!!.findViewById(R.id.button_yes)
        noButton = view!!.findViewById(R.id.button_no)
        yesButton.setOnClickListener { (requireActivity() as MyInterface).answerQuestion(true) }
        noButton.setOnClickListener { (requireActivity() as MyInterface).answerQuestion(false) }
        val questionsList = resources.getStringArray(R.array.questions)
        if (questionsList.size == position){
            layoutWithButtons.visibility = View.GONE
            resultButton.visibility = View.VISIBLE
            resultButton.setOnClickListener { (requireActivity() as MyInterface).finishQuestions() }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) =
            QuestionsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ID, position)
                }
            }

    }


}