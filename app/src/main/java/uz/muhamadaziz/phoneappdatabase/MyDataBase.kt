package uz.muhamadaziz.phoneappdatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import uz.muhamadaziz.phoneappdatabase.Content.DB_NAME
import uz.muhamadaziz.phoneappdatabase.Content.DB_VERSION
import uz.muhamadaziz.phoneappdatabase.Content.FEATURES
import uz.muhamadaziz.phoneappdatabase.Content.ID
import uz.muhamadaziz.phoneappdatabase.Content.NAME
import uz.muhamadaziz.phoneappdatabase.Content.POSITION
import uz.muhamadaziz.phoneappdatabase.Content.TABLE_NAME

class MyDataBase(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION), Service {
    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "CREATE TABLE $TABLE_NAME($ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,$POSITION INTEGER NOT NULL, $NAME TEXT NOT NULL, $FEATURES TEXT NOT NULL)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)

    }

    override fun addPhone(phonedata: Phonedata) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME, phonedata.name)
        contentValues.put(POSITION, phonedata.position)
        contentValues.put(FEATURES, phonedata.feature)
        database.insert(TABLE_NAME, null, contentValues)
        database.close()
    }

    override fun deletePhone(phonedata: Phonedata) {
        val database = this.writableDatabase
        database.delete(TABLE_NAME, "$ID = ?", arrayOf("${phonedata.id}"))
        database.close()
    }

    override fun getAllPhoneList(): List<Phonedata> {

        val phoneList = ArrayList<Phonedata>()

        val query: String = "SELECT * FROM $TABLE_NAME"
        val dataBase = this.readableDatabase
        val cursor = dataBase.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val id: Int = cursor.getInt(0)
                val position = cursor.getInt(1)
                val name: String = cursor.getString(2)
                val features: String = cursor.getString(3)

                val phone = Phonedata(id, position, name, features)
                phoneList.add(phone)
            } while (cursor.moveToNext())
        }
        return phoneList


    }
}