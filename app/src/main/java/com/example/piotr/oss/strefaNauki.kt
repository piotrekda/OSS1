package com.example.piotr.oss

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.piotr.oss.Nauka.Kardio.Kardio
import com.example.piotr.oss.Nauka.Pulmono.Pulmono

class strefaNauki : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strefa_nauki)
        setUpActionBar()
    }

    fun toKardio (view: View) {
        val intent = Intent(applicationContext, Kardio::class.java)
        startActivity(intent)
    }
    fun toPulmono (view: View) {
        val intent = Intent(applicationContext, Pulmono::class.java)
        startActivity(intent)
    }
}
