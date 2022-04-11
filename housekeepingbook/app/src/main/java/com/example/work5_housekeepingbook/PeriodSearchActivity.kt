package com.example.work5_housekeepingbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class PeriodSearchActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_period_search)


        var menu =findViewById<Button>(R.id.menuBtn3)

        menu.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.menuBtn3 -> startActivity(Intent(this, MainActivity::class.java))
        }
    }
}