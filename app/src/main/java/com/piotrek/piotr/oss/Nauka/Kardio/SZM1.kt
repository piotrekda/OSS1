package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.piotrek.piotr.oss.R
import com.piotrek.piotr.oss.setUpActionBar

class SZM1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_szm1)
        setUpActionBar()
    }

    fun toSZM (view: View) {

        val intent = Intent(applicationContext, SZM::class.java)
        startActivity(intent)
    }

}
