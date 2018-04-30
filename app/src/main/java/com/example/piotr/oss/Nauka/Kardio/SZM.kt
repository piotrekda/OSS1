package com.example.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class SZM : AppCompatActivity() {
    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_szm)


        textView.setText("Patologiczne zmniejszenie się pola powierzchni ujścia zastawki mitralnej, utrudniające napływ krwi do lewej komory. Zwężenie ze względu na etiologię dzielimy na strukturalne (ograniczenie ruchomości płatków spowodowane przez zmiany organiczne w ich obrębie), czynnościowe (nieprawidłowe otwieranie płatów o prawidłowej strukturze) i względne (stany chorobowe przebiegające ze zwiększonym przepływem przez zastawkę mitralną)\n" +
                "Szmer śródrozkurczowy (mezodiastoliczny) typu decrescendo, przechodzący w narastający (crescendo) szmer przedskurczowy, najgłośniejszy nad koniuszkiem serca. Nie promieniujący, głośny, „kłapiący” I ton serca s1. Ton (trzask) otwarcia zastawki mitralnej.\n")


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k06)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@SZM, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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

    fun toSZM1 (view: View) {

        val intent = Intent(applicationContext, SZM1::class.java)
        startActivity(intent)
    }


}