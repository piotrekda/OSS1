package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import com.piotrek.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class IIITS : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iiits)


        textView.setText(Html.fromHtml(" <b>  Etiologia  </b> <br>Patologiczny ton wczesnorozkurczowy, bardzo rzadko występuje fizjologicznie u dzieci i młodzieży. Najczęściej objaw ciężkiej choroby serca. Powstaje w fazie szybkiego biernego napełniania komór, gdy upośledzona jest podatność komory lub zwiększona objętość napływającej krwi. Składowa cwału wczesnorozkurczowego (cwału komorowego)."))


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k02)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@IIITS, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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
