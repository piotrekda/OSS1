package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.piotrek.piotr.oss.R
import com.piotrek.piotr.oss.setUpActionBar

class SZA1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sza1)
        setUpActionBar()
    }

    fun toSZA (view: View) {

        val intent = Intent(applicationContext, SZA::class.java)
        startActivity(intent)
    }

}
