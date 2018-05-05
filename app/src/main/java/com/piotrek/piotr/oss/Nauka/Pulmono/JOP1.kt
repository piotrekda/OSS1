package com.piotrek.piotr.oss.Nauka.Pulmono

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.piotrek.piotr.oss.R
import com.github.chrisbanes.photoview.PhotoView

class JOP1 : AppCompatActivity() {

    lateinit var photoView : PhotoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jop1)

        photoView = findViewById<PhotoView>(R.id.photo)
        photoView.setImageResource(R.drawable.e9)

    }
    fun toJOP(view: View) {
        val intent = Intent(applicationContext, JOP::class.java)
        startActivity(intent)
    }
}