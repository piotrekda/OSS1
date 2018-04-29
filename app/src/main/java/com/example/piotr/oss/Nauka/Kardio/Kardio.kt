package com.example.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.piotr.oss.MainActivity
import com.example.piotr.oss.R
import com.example.piotr.oss.strefaNauki

class Kardio : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kardio)




    }

    fun tostrefaNauki (view: View) {
        val intent = Intent(applicationContext, strefaNauki::class.java)
        startActivity(intent)
    }

    fun toJO (view: View) {
        val intent = Intent(applicationContext, JO::class.java)
        startActivity(intent)
    }

    fun toPTS (view: View) {
        val intent = Intent(applicationContext, PTS::class.java)
        startActivity(intent)
    }




}
