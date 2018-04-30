package com.example.piotr.oss.Nauka.Pulmono

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class RD : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rd)
        textView.setText("Przerywany, krótki szmer oddechowy (przypomina dźwięk drewna palonego w kominku). Dźwięk wynika z owierających się wcześniej zamkniętych małych dróg oddechowych (związane z zalegającą wydzieliną, badź niedostatecznym upowietrzeniem – niedodma). Słyszalne w zarówno w fazie wdechowej i wydechowej. Wczesne wdechowe i wydechowe trzeszczenia są oznaką chronicznego zapalenia oskrzeli. Późne wdechowe trzeszczenia mogą oznaczać zapalenie płuc, zastoinowe niewydoloność serca bądź niedodmę.")


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.p03)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@RD, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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
