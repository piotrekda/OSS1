package com.example.piotr.oss.Testy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.piotr.oss.MainActivity
import com.example.piotr.oss.R

class StrefaTestu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strefa_testu)
    }
    fun toMainActivity (view: View) {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
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
