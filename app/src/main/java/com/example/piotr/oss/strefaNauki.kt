package com.example.piotr.oss

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.piotr.oss.Nauka.Kardio.Kardio

import com.example.piotr.oss.Testy.Test1

class strefaNauki : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strefa_nauki)
    }
    fun toMainActivity (view: View) {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
    fun toKardio (view: View) {
        val intent = Intent(applicationContext, Kardio::class.java)
        startActivity(intent)
    }
    fun toPulmono (view: View) {
        val intent = Intent(applicationContext, Test1::class.java)
        startActivity(intent)
    }
}
