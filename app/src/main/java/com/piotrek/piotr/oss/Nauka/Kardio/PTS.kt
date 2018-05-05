package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.piotrek.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class PTS : AppCompatActivity() {



    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pts)


        textView.setText("W prawidłowej pracy serca możemy wyróżnić dwa fizjologiczne tony, występujące u wszystkich ludzi:\n" +
                "– I ton – przypada na początkowy okres skurczu komór, trwa około 140 ms. Widmo akustyczne tworzone jest poprzez zamykające się zastawki mitralną i trójdzielną. Najgłośniej słyszalny jest na koniuszku serca.\n" +
                "– II ton – przypada na początkowy okres rozkurczu, trwa około 110 ms. Widmo akustyczne tworzone jest poprzez zamykające się zastawki aortalną (A2) i tętnicy płucnej (P2). Fizjologicznie rozdwaja się na wdechu (A2 przed P2). Najgłośniej słyszalny jest u podstawy serca.\n")


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k01)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@PTS, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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
    fun toPTS1 (view: View) {
        val intent = Intent(applicationContext, PTS1::class.java)
        startActivity(intent)
    }
}
