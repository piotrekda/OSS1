package com.example.piotr.oss.Nauka.Pulmono

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.piotr.oss.R
import com.example.piotr.oss.strefaNauki

class Pulmono : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pulmono)
    }
    fun tostrefaNauki (view: View) {
        val intent = Intent(applicationContext, strefaNauki::class.java)
        startActivity(intent)
    }

    fun toJOP (view: View) {
        val intent = Intent(applicationContext, JOP::class.java)
        startActivity(intent)
    }

    fun toST (view: View) {
        val intent = Intent(applicationContext, ST::class.java)
        startActivity(intent)
    }
    fun toSP (view: View) {
        val intent = Intent(applicationContext, SP::class.java)
        startActivity(intent)
    }
    fun toSO (view: View) {
        val intent = Intent(applicationContext, SO::class.java)
        startActivity(intent)
    }
    fun toRD (view: View) {
        val intent = Intent(applicationContext, RD::class.java)
        startActivity(intent)
    }
    fun toRG (view: View) {
        val intent = Intent(applicationContext, RG::class.java)
        startActivity(intent)
    }

    fun toSWy (view: View) {
        val intent = Intent(applicationContext, SWy::class.java)
        startActivity(intent)
    }

    fun toSWd (view: View) {
        val intent = Intent(applicationContext, SWd::class.java)
        startActivity(intent)
    }

    fun toF (view: View) {
        val intent = Intent(applicationContext, F::class.java)
        startActivity(intent)
    }

    fun toTO (view: View) {
        val intent = Intent(applicationContext, TO::class.java)
        startActivity(intent)
    }

}

