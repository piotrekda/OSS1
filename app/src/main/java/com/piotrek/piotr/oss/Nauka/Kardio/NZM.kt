package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.piotrek.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class NZM : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nzm)


        textView.setText("Patologia polegająca na cofaniu się krwi z lewej komory do lewego przedsionka w wyniku nieprawidłowego zamykania płatków zastawki mitralnej. Niedomykalność powstała w wyniku pierwotnego uszkodzenia aparatu zastawkowego (płatków lub strun ścięgnistych) nazywana jest pierwotną; niedomykalność wtórna wynika ze zmian geometrii lewej komory (najczęściej w przebiegu choroby niedokrwiennej serca – tzw. niedomykalność niedokrwienna).\n" +
                "Szmer trwający przez cały okres skurczu serca (holosystoliczny)  pasmowaty lub decrescendo (stopniowo cichnący), połączony z 1 tonem serca. Najgłośniejszy zwykle nad koniuszkiem, promieniuje do lewego dołu pachowego i ku tyłowi do lewej łopatki. Głośność proporcjolnalna do wielkości fali zwrotnej, staje się głośniejszy przy kucnięciu. Szmer późnoskurczowy (telesystoliczny) towrzyszący najczęściej wypadaniu płatka zastawki mitralnej lub dysfunkcją mięśnia brodawkowatego. \n")


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k07)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@NZM, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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
