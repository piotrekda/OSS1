package com.example.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class JO1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jo1)
    }
    fun toJO(view: View) {
        val intent = Intent(applicationContext, JO::class.java)
        startActivity(intent)
    }
}
