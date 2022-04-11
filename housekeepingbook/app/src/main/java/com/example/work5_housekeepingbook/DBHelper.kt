package com.example.work5_housekeepingbook

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Dao == DB와 연결
// 외우기
class DBHelper(context:Context?, filename:String, factory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper(context, filename, null, 1) {

    // Singleton으로 작성 - DBHelper로 생성하지 않아도 접근할 수 있도록(DBHelper.~~로 작성하지 않고 그냥 { }안에 작성해주면 된다
    companion object{
        // dbhelper == 인스턴스
        private var dbhelper:DBHelper? = null
        // getInstance에 들어와서 생성하려는 것이 DBHelper > context와 filename는 반드시 적어줘야함
        fun getInstance(context: Context, filename: String) : DBHelper {
            // dbhelper가 null일때 dbhelper를 생성해줘라
            if(dbhelper == null){
                dbhelper = DBHelper(context, filename, null, 1)
            }
            return dbhelper!!
        }
    }


    // 테이블을 만들어주는 부분분
   override fun onCreate(db: SQLiteDatabase?) {
        var sql:String = " CREATE TABLE if not exists LIST( " +
                                " seq integer primary key autoincrement , " +
                                " usage String , " +
                                " date String, " +
                                " price Int, " +
                                " memo String ) "
        // db를 통해 쿼리문 작성
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        var sql:String = " DROP TABLE IF EXISTS LIST"
        db?.execSQL(sql)
        onCreate(db)
    }

    fun insert(vo: List){
        var sql = " INSERT INTO LIST(usage, date, price, memo) " +
                        " VALUES('${vo.usage}', '${vo.date}', ${vo.price}, '${vo.memo}')"
        var db = this.writableDatabase
        db.execSQL(sql)
    }


    fun select(date:String) : MutableList<List>{
        val list = mutableListOf<List>()
        var search = "SELECT * FROM LIST WHERE DATE = '${date}'"
        var rd = readableDatabase
        var cursor = rd.rawQuery(search, null)

        val seqIdx = cursor.getColumnIndex("SEQ")
        val usageIdx = cursor.getColumnIndex("USAGE")
        val dateIdx = cursor.getColumnIndex("DATE")
        val priceIdx = cursor.getColumnIndex("PRICE")
        val memoIdx = cursor.getColumnIndex("MEMO")

        while(cursor.moveToNext()){
            var seq = cursor.getInt(seqIdx)
            var usage = cursor.getString(usageIdx)
            var date = cursor.getString(dateIdx)
            var price = cursor.getInt(priceIdx)
            var memo = cursor.getString(memoIdx)

            list.add(List(seq, usage, date, price, memo))
        }

        cursor.close()
        rd.close()
        return list
    }






}