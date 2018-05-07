package com.piotrek.piotr.oss.Nauka.Pulmono

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import com.piotrek.piotr.oss.R
import com.piotrek.piotr.oss.setUpActionBar
import kotlinx.android.synthetic.main.activity_jo.*

class F : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_f)
        setUpActionBar()

        textView.setText(Html.fromHtml(" <b>  Etiologia  </b> <br>Dźwięk wynika z obecności wydzieliny w drogach oddechowych, występuje w klatce piersiowej nad oskrzelami (nie nad pęcherzykami). <br> <b>  Charakterystyka  </b> <br>Ciągły, zarówno wdechowy i wydechowy szmer oddechowy o niskiej częstotliwości. Furczenia zazwyczaj ustępują po odkaszlnięciu."))


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.p08)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()

            Toast.makeText(this@F, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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

