package com.example.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.piotr.oss.R
import com.github.chrisbanes.photoview.PhotoView

class PTS1 : AppCompatActivity() {

    lateinit var photoView : PhotoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pts1)

        photoView = findViewById<PhotoView>(R.id.photo)
        photoView.setImageResource(R.drawable.tonyserca)
    }
    fun toPTS(view: View) {
        val intent = Intent(applicationContext, PTS::class.java)
        startActivity(intent)
    }
}
