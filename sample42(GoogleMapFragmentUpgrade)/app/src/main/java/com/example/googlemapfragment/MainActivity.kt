package com.example.googlemapfragment

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        val mapsFragment = MapsFragment(this)
        fragmentTransaction.add(R.id.content, mapsFragment) // <- 수정됨
        fragmentTransaction.commit()

        var button1: Button = findViewById<Button>(R.id.button) // 위도, 경로로 변환

        val editText: EditText = findViewById<EditText>(R.id.editAddr)  // 주소입력
        val editText1:EditText = findViewById<EditText>(R.id.editLat) // 위도입력
        val editText2:EditText = findViewById<EditText>(R.id.editLon) // 경도입력

        val geocoder: Geocoder = Geocoder(this)

        var latitude:Double = -34.0
        var longitude:Double = 151.0

        // 변환1 주소 -> 위도, 경도
        button1.setOnClickListener{
            var list: List<Address>? = null
            val str: String = editText.text.toString()
            try {
                list = geocoder.getFromLocationName(
                    str,  // 지역 이름
                    10
                ) // 읽을 개수
            } catch (e: IOException) {
                e.printStackTrace()
                Log.e("test", "입출력 오류 - 서버에서 주소변환시 에러발생")
            }

            if (list != null) {
                if (list!!.isEmpty()) {
                    Toast.makeText(this, "해당되는 주소 정보는 없습니다", Toast.LENGTH_LONG).show()
                } else {
                    // editText1.text 는 안된다
                    editText1.setText(list!![0].latitude.toString())
                    editText2.setText(list!![0].longitude.toString())

                    latitude = list!![0].latitude
                    longitude = list!![0].longitude

                    // 위도,경도 입력 후 지도
                    mapsFragment.setLocation(latitude, longitude)
                }
            }
        }
    }
}
