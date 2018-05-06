package com.piotrek.piotr.oss.Nauka.Pulmono

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import com.piotrek.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class RG : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rg)

        textView.setText(Html.fromHtml(" <b>  Etiologia  </b> <br>Szmer oddechowy związany z dużą ilością płynu w płucach. <br> <b>  Charakterystyka  </b> <br>Typowo wdechowy, przerywany, krótki szmer oddechowy. W porównaniu z trzeszczeniami jest głośniejszy, trwa dłużej i ma niższą częstotliwość. Określa się go także jako dźwięk bulgoczący."))


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.p06)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@RG, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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