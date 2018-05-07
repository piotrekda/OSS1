package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.piotrek.piotr.oss.R
import com.piotrek.piotr.oss.setUpActionBar

class JO1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jo1)
        setUpActionBar()
    }
    fun toJO(view: View) {
        val intent = Intent(applicationContext, JO::class.java)
        startActivity(intent)
    }
}
