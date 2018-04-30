package com.example.piotr.oss.Nauka.Pulmono

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class SO : AppCompatActivity() {
    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_so)
        textView.setText("Szmer prawidłowo słyszalny nad tchawicą i dużymi oskrzelami, patologicznie nad obwodowymi częściami płuc (może wywołany być przez naciek zapalny lub krwotok). Faza wydechowa wyraźniej zaznaczona od wdechowej.")


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.p04)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@SO, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer!!.release()
    }



    fun toPulmono (view: View) {

        val intent = Intent(applicationContext, Pulmono::class.java)
        startActivity(intent)
    }

}
