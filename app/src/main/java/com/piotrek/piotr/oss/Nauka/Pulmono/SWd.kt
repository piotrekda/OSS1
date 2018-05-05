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

class SWd : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swd)
        textView.setText(Html.fromHtml(" <b>  Etiologia  </b> <br>Szmer oddechowy wskazujący na przycznę znajdującą się w krtni lub tchawicy. Może być wywołany przez porażenie strun głosowych, zmiany zapalne krtani i tchawicy, ucisk na tchawicę z zewnątrz, ciało obce. <br> <b>  Charakterystyka  </b> <br>Ciągły, głośny, wdechowy, szmer oddechowy o stałej częstoliwości."))


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.p05)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@SWd, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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
