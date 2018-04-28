package com.example.piotr.oss

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.piotr.oss.Testy.Test
import com.example.piotr.oss.Testy.Test1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toTesty (view: View) {
        val intent = Intent(applicationContext, Test::class.java)
        startActivity(intent)
    }
    fun toTesty1 (view: View) {
        val intent = Intent(applicationContext, Test1::class.java)
        startActivity(intent)
    }
}
