package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val name=intent.getStringExtra("Username")
        val name1= findViewById<TextView>(R.id.username)
        name1.text=name

        val totalQuestions= intent.getIntExtra("Total",10)
        val correctAnswers= intent.getIntExtra("Correct",0)

        val score1= findViewById<TextView>(R.id.score)
        score1.text="Your score is $correctAnswers / $totalQuestions which makes you....."
        if(correctAnswers>=8)
        {
            val blood1= findViewById<TextView>(R.id.blood)
            blood1.text= "Pure-blood"
        }
        else
            if(correctAnswers in 5..7)
            {
                val blood1= findViewById<TextView>(R.id.blood)
                blood1.text= "Half-blood"
            }

         else
         {
            val blood1= findViewById<TextView>(R.id.blood)
            blood1.text= "Muggle-born"
        }
        val qe= findViewById<Button>(R.id.quizend)
        qe.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}
