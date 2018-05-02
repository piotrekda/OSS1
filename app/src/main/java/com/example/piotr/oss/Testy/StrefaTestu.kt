package com.example.piotr.oss.Testy

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.piotr.oss.MainActivity
import com.example.piotr.oss.R
import kotlinx.android.synthetic.main.toolbar.*

class StrefaTestu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strefa_testu)
        setSupportActionBar(customtoolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }
    fun toMainActivity (view: View) {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }

    fun toTesty (view: View) {
        Test.start(this, "lungs")
    }
    fun toTesty1 (view: View) {
        Test.start(this, "heart")
    }
}
