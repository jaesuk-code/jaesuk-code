package com.example.work5_housekeepingbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class InsertActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        var dbHelper = DBHelper(this, "mydb.db", null, 1)

        val insert = findViewById<Button>(R.id.insertBtn2)
        val menu = findViewById<Button>(R.id.menuBtn)
        val radio = findViewById<RadioGroup>(R.id.radioGroup)


        // DB를 불러오면서 데이터를 넣어줄 인스턴스 작성
        val insertUsage = findViewById<EditText>(R.id.insertUsage)
        var insertCalendar = findViewById<DatePicker>(R.id.insertCalendar)
        val insertPrice = findViewById<EditText>(R.id.insertPrice)
        val insertMemo = findViewById<EditText>(R.id.insertMemo)

        // 버튼 클릭하면서 데이터 불러오기
        insert.setOnClickListener {
            val date = "${insertCalendar.year}-${insertCalendar.month + 1}-${insertCalendar.dayOfMonth}"

            val li = List(0, insertUsage.text.toString(), date, insertPrice.text.toString().toInt(), insertMemo.text.toString() )

            val dbHelper = DBHelper.getInstance(this, "list.db")
            dbHelper.insert(li)

            Toast.makeText(this, "추가되었습니다", Toast.LENGTH_SHORT).show()
        }

        radio.setOnCheckedChangeListener(this)

        menu.setOnClickListener(this)
    }

    // 메인 화면으로 이동
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.menuBtn -> startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onCheckedChanged(p0: RadioGroup?, i: Int) {
        val income = findViewById<EditText>(R.id.insertPrice)
        val radio = findViewById<RadioGroup>(R.id.radioGroup)


    /*
        when(i){
            R.id.incomeBtn -> { income.text = " + ${income.text}" }
        }
            R.id.expenseBtn -> { income.text = " - "  }
    }
    */


    }
}




