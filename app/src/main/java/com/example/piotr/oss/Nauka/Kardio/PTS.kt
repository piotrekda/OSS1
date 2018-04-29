package com.example.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class PTS : AppCompatActivity() {


    internal var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pts)


        textView.setText("W prawidłowej pracy serca możemy wyróżnić dwa fizjologiczne tony, występujące u wszystkich ludzi:\n" +
                "– I ton – przypada na początkowy okres skurczu komór, trwa około 140 ms. Widmo akustyczne tworzone jest poprzez zamykające się zastawki mitralną i trójdzielną. Najgłośniej słyszalny jest na koniuszku serca.\n" +
                "– II ton – przypada na początkowy okres rozkurczu, trwa około 110 ms. Widmo akustyczne tworzone jest poprzez zamykające się zastawki aortalną (A2) i tętnicy płucnej (P2). Fizjologicznie rozdwaja się na wdechu (A2 przed P2). Najgłośniej słyszalny jest u podstawy serca.\n")


    }



    fun playMusic(view: View) {
        if (mediaPlayer != null)
        {
            mediaPlayer!!.release()
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.k01)

        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.stop()
        } else {
            mediaPlayer!!.start()
        }
    }




        fun toKardio (view: View) {
        if (mediaPlayer != null && mediaPlayer!!.isPlaying()) {
            mediaPlayer!!.stop()
        }

        val intent = Intent(applicationContext, Kardio::class.java)
        startActivity(intent)
    }
    fun toPTS1 (view: View) {
        val intent = Intent(applicationContext, PTS1::class.java)
        startActivity(intent)
    }
}
