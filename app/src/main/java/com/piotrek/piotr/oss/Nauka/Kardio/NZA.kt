package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Toast
import com.piotrek.piotr.oss.R
import com.piotrek.piotr.oss.setUpActionBar
import kotlinx.android.synthetic.main.activity_jo.*

class NZA : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nz)
        setUpActionBar()


        textView.setText(Html.fromHtml(" <b>  Etiologia  </b> <br>Patologia polegająca na cofaniu się krwi z aorty do lewej komory w wyniku nieprawidłowego zamykania się płatków zastawki aortalnej. Dzielimy ją na niedomykalność pierwotną (uszkodzenie lub wrodzona nieprawidłowość płatków i następnie poszerzenie drogi odpływu) i wtórną (poszerzenie drogi odpływu). Niedomykalność aortalna może być ostra (np. w rozwarstwieniu aorty, infekcyjnym zapaleniu wsierdzia) lub przewlekła (gorączka reumatyczna, miażdżyca, tętniak aorty wstępującej, choroby tkanki łącznej). " +
                "<br> <b>  Charakterystyka  </b> <br>Szmer trwający cały okres rozkurczu (holodiastoliczny) typu decrescendo (stopniowo cichnący) w punkcie osłuchiwania zastawki aortalnej. Zwykle najgłośniejszy przy lewym brzegu mostka, rozpoczynający się zaraz po II tonie serca, głośniejszy w pozycji siedzącej z przodopochyleniem albo po nagłym kucnięciu. W długotrwałej niedomykalności może występować szmer Austina Flinta (szmer względnej stenozy zastawki mitralnej). Występuje duża amplituda ciśnienia krwi (ciśnienie skurczowe zwiększone i często nieoznaczalne ciśnienie rozkurczowe), zawsze z tętnem wysokim i chybkim."))


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k05)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@NZA, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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
