package com.example.piotr.oss

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.piotr.oss.Testy.StrefaTestu

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toNauka(view: View) {
        val intent = Intent(applicationContext, strefaNauki::class.java)
        startActivity(intent)
    }

    fun toTesty(view: View) {
        val intent = Intent(applicationContext, StrefaTestu::class.java)
        startActivity(intent)
    }
}
