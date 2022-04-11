package com.example.work5_housekeepingbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        var menu = findViewById<Button>(R.id.menuBtn2)
        var resultBtn = findViewById<Button>(R.id.resultBtn)
        var searchDatePicker = findViewById<DatePicker>(R.id.searchCalendar)
        var date:String = ""
        var recyclerView = findViewById<RecyclerView>(R.id.searchList)

        resultBtn.setOnClickListener{
            date = "${searchDatePicker.year}-${searchDatePicker.month +1}-${searchDatePicker.dayOfMonth}"
            val list = DBHelper.getInstance(this, "mydb.db").select(date)
            val adapter = CustomAdapter(this, list)
            recyclerView.adapter = adapter

            val layout = LinearLayoutManager(this)
            recyclerView.layoutManager = layout
            recyclerView.setHasFixedSize(true)
        }

        menu.setOnClickListener(this)
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.menuBtn2 -> startActivity(Intent(this, MainActivity::class.java))
        }
    }











}