package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

   private var currentPosition:Int=1
    private var questionsList:ArrayList<QuestionModel>?=null
    private var selectedOptionPosition:Int=0
    private var countCorrectAnswers:Int =0
    private var userName:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
         userName= intent.getStringExtra("Username")
        questionsList= QuestionController.getQuestions()
       setQuestion()

        val opt1= findViewById<TextView>(R.id.option_one)
        opt1.setOnClickListener(this)
        val opt2= findViewById<TextView>(R.id.option_two)
        opt2.setOnClickListener(this)
        val opt3= findViewById<TextView>(R.id.option_three)
        opt3.setOnClickListener(this)
        val opt4= findViewById<TextView>(R.id.option_four)
        opt4.setOnClickListener(this)
        val submit= findViewById<Button>(R.id.submit_button)
        submit.setOnClickListener(this)
    }
    fun setQuestion()
    {
        val question:QuestionModel=questionsList!![currentPosition-1]
        optionDefaultBackground()
        if (currentPosition == questionsList!!.size) {
            val submit = findViewById<Button>(R.id.submit_button)
            submit.text = "FINISH"

        }
        val p= findViewById<ProgressBar>(R.id.progressBar)
        p.progress=currentPosition
        val pt= findViewById<TextView>(R.id.progress_textview)
        pt.text= "$currentPosition/${questionsList!!.size}"
        val qt= findViewById<TextView>(R.id.question_text)
        qt.text=question.questionText
        val opt1= findViewById<TextView>(R.id.option_one)
        opt1.text=question.optionOne
        val opt2= findViewById<TextView>(R.id.option_two)
        opt2.text=question.optionTwo
        val opt3= findViewById<TextView>(R.id.option_three)
        opt3.text=question.optionThree
        val opt4= findViewById<TextView>(R.id.option_four)
        opt4.text=question.optionFour
    }
    fun optionDefaultBackground()
    {
        val opt1= findViewById<TextView>(R.id.option_one)
        opt1.background=ContextCompat.getDrawable(this,R.drawable.option_border)
        val opt2= findViewById<TextView>(R.id.option_two)
        opt2.background=ContextCompat.getDrawable(this,R.drawable.option_border)
        val opt3= findViewById<TextView>(R.id.option_three)
        opt3.background=ContextCompat.getDrawable(this,R.drawable.option_border)
        val opt4= findViewById<TextView>(R.id.option_four)
        opt4.background=ContextCompat.getDrawable(this,R.drawable.option_border)
    }

    override fun onClick(v: View?) {
     when(v?.id) {
         R.id.option_one -> {
             val opt1 = findViewById<TextView>(R.id.option_one)
             optionSelectedBackground(opt1, 1)
         }
         R.id.option_two -> {
             val opt2 = findViewById<TextView>(R.id.option_two)
             optionSelectedBackground(opt2, 2)
         }
         R.id.option_three -> {
             val opt3 = findViewById<TextView>(R.id.option_three)
             optionSelectedBackground(opt3, 3)
         }
         R.id.option_four -> {
             val opt4 = findViewById<TextView>(R.id.option_four)
             optionSelectedBackground(opt4, 4)

         }
         R.id.submit_button -> {
             if (selectedOptionPosition == 0) {
                 currentPosition++
                 when {
                     currentPosition <= questionsList!!.size -> {
                         setQuestion()
                     }
                     else -> {
                         val intent= Intent(this,FinalActivity::class.java)
                         intent.putExtra("Username",userName)
                         intent.putExtra("Correct",countCorrectAnswers)
                         intent.putExtra("Total",questionsList!!.size)
                         startActivity(intent)
                         finish()
                     }
                 }

             } else {
                 val question = questionsList?.get(currentPosition - 1)
                 if (question != null) {
                     if (question.correctAnswer != selectedOptionPosition) {
                         redgreenHighlight(selectedOptionPosition, R.drawable.wrong_answer)

                     }
                     else
                     {
                         countCorrectAnswers++
                     }
                 }
                 if (question != null) {
                     redgreenHighlight(question.correctAnswer, R.drawable.correct_answer)
                     selectedOptionPosition=0
                 }

             }
         }
     }
     }

    fun redgreenHighlight(answer:Int,drawable:Int){
        when(answer){
            1->{
                val opt1= findViewById<TextView>(R.id.option_one)
                opt1.background=ContextCompat.getDrawable(this,drawable)
            }
            2->{
                val opt2= findViewById<TextView>(R.id.option_two)
                opt2.background=ContextCompat.getDrawable(this,drawable)
            }
            3->{
                val opt3= findViewById<TextView>(R.id.option_three)
                opt3.background=ContextCompat.getDrawable(this,drawable)
            }
            4->{
                val opt4= findViewById<TextView>(R.id.option_four)
                opt4.background=ContextCompat.getDrawable(this,drawable)
            }
        }
    }
    fun optionSelectedBackground(tv:TextView,selectedOptionNo:Int)
    {
        optionDefaultBackground()
        selectedOptionPosition= selectedOptionNo
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option)

    }
}