package com.example.roomdb.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.room.Room
import com.example.roomdb.AppDataBase
import com.example.roomdb.R
import com.example.roomdb.models.Car
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
      lateinit var db: AppDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = Room.databaseBuilder(this, AppDataBase::class.java, "mydb")
            .allowMainThreadQueries()
            .build()
        tvCount.setText(db.objectCars().countOfCars.toString())

    }
    fun search(view: View) {



        val u = db.objectCars().searchForUserByID(etID.text.toString())
        if (u != null) {
            etName.setText(u.type)
            etPassword.setText(u.price.toString())
        }
    }
    fun save(view: View) {


try {
    val u = Car()

    u.type=etName.text.toString()
    var put=u.price.toString()
    put=etPassword.text.toString()

    db.objectCars().insert(u)
    tvCount.text = db.objectCars().countOfCars.toString()
}

        catch (e:Exception){

        }

    }
    fun fillList(view: View) {
        val myList = db.objectCars().allCars
        val a = ArrayAdapter<Car>(this, android.R.layout.simple_list_item_1, myList)
        lv.adapter = a


        lv.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val u = lv.getItemAtPosition(position) as Car
                Toast.makeText(this@MainActivity, u.type, Toast.LENGTH_SHORT).show()
            }
    }
}