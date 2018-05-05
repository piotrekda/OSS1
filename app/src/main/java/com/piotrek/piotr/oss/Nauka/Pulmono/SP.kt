package com.piotrek.piotr.oss.Nauka.Pulmono

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.piotrek.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class SP : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)


        textView.setText("Szmer zazwyczaj cichy, głównie wdechowy z wyraźnie zanaczoną przerwą przed cichszą wydechową fazą, ze stosunkiem składowej wdechowej do wydechowej 3 do 1.  Powodowany poprzez turbulentny przepływ powietrza przez oskrzela płatowe i segmentowe. Słyszalny nad niemal całymi płucami. Ściszenie powodowane jest przez: spadek napędu oddechowego, w rozedmie (upośledzeny jest przepływ powietrza do obwodowych części płuc), osłabienie przenoszenia szmeru (obecności płynu lub powietrza w jamie opłucnej), obecności dużych pęcherzy rozedmowych lub deformacji klatki piersiowej.")


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.p02)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@SP, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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
