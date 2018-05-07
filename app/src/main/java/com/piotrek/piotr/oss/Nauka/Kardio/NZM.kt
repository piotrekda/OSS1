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

class NZM : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer
    lateinit var playsound : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nzm)
        setUpActionBar()
        playsound = findViewById(R.id.playsound) as ImageView

        textView.setText(Html.fromHtml(" <b>  Etiologia  </b> <br>Patologia polegająca na cofaniu się krwi z lewej komory do lewego przedsionka w wyniku nieprawidłowego zamykania płatków zastawki mitralnej. Niedomykalność powstała w wyniku pierwotnego uszkodzenia aparatu zastawkowego (płatków lub strun ścięgnistych) nazywana jest pierwotną; niedomykalność wtórna wynika ze zmian geometrii lewej komory (najczęściej w przebiegu choroby niedokrwiennej serca – tzw. niedomykalność niedokrwienna)." +
                "<br> <b>  Charakterystyka  </b> <br>Szmer trwający przez cały okres skurczu serca (holosystoliczny)  pasmowaty lub decrescendo (stopniowo cichnący), połączony z 1 tonem serca. Najgłośniejszy zwykle nad koniuszkiem, promieniuje do lewego dołu pachowego i ku tyłowi do lewej łopatki. Głośność proporcjolnalna do wielkości fali zwrotnej, staje się głośniejszy przy kucnięciu. <br> Szmer późnoskurczowy (telesystoliczny) towrzyszący najczęściej wypadaniu płatka zastawki mitralnej lub dysfunkcją mięśnia brodawkowatego."))


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k07)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
            playsound.setImageResource(R.drawable.e11)
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@NZM, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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
