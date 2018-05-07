package com.piotrek.piotr.oss.Nauka.Pulmono

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.piotrek.piotr.oss.R
import com.piotrek.piotr.oss.setUpActionBar
import kotlinx.android.synthetic.main.activity_jo.*

class RD : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer
    lateinit var playsound : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rd)
        setUpActionBar()
        playsound = findViewById(R.id.playsound) as ImageView
        textView.setText(Html.fromHtml(" <b>  Etiologia  </b> <br>Dźwięk wynika z owierających się wcześniej zamkniętych małych dróg oddechowych (związane z zalegającą wydzieliną, badź niedostatecznym upowietrzeniem – niedodma). Wczesne wdechowe i wydechowe trzeszczenia są oznaką chronicznego zapalenia oskrzeli. Późne wdechowe trzeszczenia mogą oznaczać zapalenie płuc, zastoinową niewydoloność serca, bądź niedodmę. <br> <b>  Charakterystyka  </b> <br> Przerywany, krótki szmer oddechowy (przypomina dźwięk drewna palonego w kominku). Słyszalne w zarówno w fazie wdechowej i wydechowej."))


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.p03)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
            playsound.setImageResource(R.drawable.e11)
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@RD, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
            playsound.setImageResource(R.drawable.e111)
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
