package com.piotrek.piotr.oss.Nauka.Kardio

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

class VSD : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer
    lateinit var playsound : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vsd)
        setUpActionBar()
        playsound = findViewById(R.id.playsound) as ImageView
        textView.setText(Html.fromHtml(" <b>  Etiologia  </b> <br>Ubytek przegrody międzykomorowej (ang. ventricular septal defect, VSD) – najczęstsza wrodzona wada serca u noworodków. W późniejszym okresie życia przegroda może zamknąć się, w związku z tym ASD jest częstszą wrodzoną wadą u dorosłych. Zlokalizowany najczęściej w błoniastej części błoniastej przegrody." +
                "<br> <b>  Charakterystyka  </b> <br>Szmer trwający przez cały okres skurczu serca (holosystoliczny), głośny, wstęgowaty, pokrywający się z II tonem serca (S2)."))

    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k09)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
            playsound.setImageResource(R.drawable.e11)
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@VSD, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
            playsound.setImageResource(R.drawable.e111)
        }
        mediaPlayer.setOnCompletionListener {
            playsound.setImageResource(R.drawable.e11)
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
