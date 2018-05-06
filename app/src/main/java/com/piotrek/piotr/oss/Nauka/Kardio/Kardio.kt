package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.piotrek.piotr.oss.MainActivity
import com.piotrek.piotr.oss.R
import com.piotrek.piotr.oss.strefaNauki

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

    fun toIIITS (view: View) {
        val intent = Intent(applicationContext, IIITS::class.java)
        startActivity(intent)
    }

    fun toIVTS (view: View) {
        val intent = Intent(applicationContext, IVTS::class.java)
        startActivity(intent)
    }
    fun toSZA(view: View) {
        val intent = Intent(applicationContext, SZA::class.java)
        startActivity(intent)
    }

    fun toNZA(view: View) {
        val intent = Intent(applicationContext, NZA::class.java)
        startActivity(intent)
    }

    fun toSZM(view: View) {
        val intent = Intent(applicationContext, SZM::class.java)
        startActivity(intent)
    }
    fun toNZM(view: View) {
        val intent = Intent(applicationContext, NZM::class.java)
        startActivity(intent)
    }
    fun toASD(view: View) {
        val intent = Intent(applicationContext, ASD::class.java)
        startActivity(intent)
    }
    fun toVSD(view: View) {
        val intent = Intent(applicationContext, VSD::class.java)
        startActivity(intent)
    }



}
