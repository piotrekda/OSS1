package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.piotrek.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class VSD : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vsd)
        textView.setText("Ubytek przegrody międzykomorowej (ang. ventricular septal defect, VSD) – najczęstsza wrodzona wada serca u noworodków. W późniejszym okresie życia przegroda może zamknąć się, w związku z tym ASD jest częstszą wrodzoną wadą u dorosłych. Zlokalizowany najczęściej w błoniastej części błoniastej przegrody.\n" +
                "Szmer trwający przez cały okres skurczu serca (holosystoliczny), głośny, wstęgowaty, pokrywający się z II tonem serca (S2).\n")

    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k09)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@VSD, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer!!.release()
    }



    fun toKardio (view: View) {

        val intent = Intent(applicationContext, Kardio::class.java)
        startActivity(intent)
    }



}
