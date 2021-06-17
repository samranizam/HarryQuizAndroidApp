package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a= findViewById<Button>(R.id.start_quiz_btn)
        var b= findViewById<TextView>(R.id.name_et)
         a.setOnClickListener {
             if(b.text.toString().isEmpty())
             {
                Toast.makeText(this,"name cannot be blank",Toast.LENGTH_SHORT).show()
             }
             else
             {
                 var c= findViewById<TextView>(R.id.name_et)
                 val intent= Intent(this,QuestionsActivity::class.java)
                 intent.putExtra("Username",c.text.toString())
                 startActivity(intent)
                 finish()
             }
         }

    }
}