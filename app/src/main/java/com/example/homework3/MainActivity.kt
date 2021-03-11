package com.example.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

interface MyInterface {
    fun startQuestions()
    fun finishQuestions()
    fun answerQuestion(answer: Boolean)
}

class MainActivity : AppCompatActivity(), MyInterface {

    private var positionQuestion = 0
    private var pointCorrect = 0
    private var answerList: List<Boolean> = listOf(
            true, false, false, false, true, false, false, true, false, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        replaceFragment(FirstFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun finishQuestions() {
        replaceFragment(ResultFragment.newInstance(pointCorrect))
        pointCorrect = 0
        positionQuestion = 0
    }

    override fun startQuestions() {
        replaceFragment(QuestionsFragment.newInstance(positionQuestion))

    }

    override fun answerQuestion(answer: Boolean) {
        if (answer == answerList[positionQuestion]) pointCorrect++
        replaceFragment(QuestionsFragment.newInstance(++positionQuestion))

    }
}