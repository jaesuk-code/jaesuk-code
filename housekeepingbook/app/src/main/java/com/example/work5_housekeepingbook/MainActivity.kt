package com.example.work5_housekeepingbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import  android.content.Intent

class MainActivity : AppCompatActivity(), View.OnClickListener{

       override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

       val insetBtn = findViewById<Button>(R.id.insertBtn)
       val searchBtn = findViewById<Button>(R.id.searchBtn)
       val periodSearchBtn = findViewById<Button>(R.id.periodSearchBtn)


       insetBtn.setOnClickListener(this)
       searchBtn.setOnClickListener(this)
       periodSearchBtn.setOnClickListener(this)
       }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.insertBtn -> startActivity(Intent(this, InsertActivity::class.java))
            R.id.searchBtn -> startActivity(Intent(this, SearchActivity::class.java))
            R.id.periodSearchBtn -> startActivity(Intent(this, PeriodSearchActivity::class.java))
        }

    }




}