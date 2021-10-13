package com.example.parsingxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var rvMain : RecyclerView
    private  var stuList = arrayListOf<Students>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvMain)

        try {
            val parser = MyXmlPullParserHandler()
            val assets = applicationContext!!.assets.open("students.xml")
            val parsedAssets = parser.parse(assets)
            stuList.addAll(parsedAssets)
            rvMain.adapter?.notifyDataSetChanged()
        } catch (io: IOException){
            io.printStackTrace()
        }

        rvMain.adapter = StudentAdapter( stuList)
        rvMain.layoutManager = LinearLayoutManager(this)

    }
}