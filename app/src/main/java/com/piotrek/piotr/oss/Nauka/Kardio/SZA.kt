package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.piotrek.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class SZA : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sz)


        textView.setText("Patologiczne zmniejszenie się pola powierzchni ujścia aortalnego, wpływające na utrudnienie wypływu krwi z lewej komory. Najczęściej jest to wada nabyta, wywołana przez zwyrodnienie, rzadko przez chorobę reumatyczną serca. Może występować też jako wada wrodzona (najczęściej dwupłatkowa zastawka aorty).\n" +
                "Szmer śródskurczowy (mezosystoliczny) nad polem osłuchiwania zastawki, promieniujący do tętnic szyjnych (przy ciasnym zwężeniu). Głośność szmeru może nie odzwierciedlać stopnia zwężenia. Składowa aortalna II tonu ściszona lub nie występuje, tętno małe i leniwe, niekiedy słyszalny IV ton.\n")


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k04)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@SZA, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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

    fun toSZA1 (view: View) {

        val intent = Intent(applicationContext, SZA1::class.java)
        startActivity(intent)
    }


}
