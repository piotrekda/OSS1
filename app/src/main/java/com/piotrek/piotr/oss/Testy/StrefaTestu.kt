package com.piotrek.piotr.oss.Testy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.piotrek.piotr.oss.MainActivity
import com.piotrek.piotr.oss.R

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
        Test.start(this, "lungs")
    }
    fun toTesty1 (view: View) {
        Test.start(this, "heart")
    }
}