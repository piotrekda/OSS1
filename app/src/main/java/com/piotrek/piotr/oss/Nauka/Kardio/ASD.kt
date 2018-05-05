package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.piotrek.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class ASD : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asd)
        textView.setText("Ubytek w przegrodzie międzyprzedsionkowej (ang. atrial septal defect, ASD) – jedna z najczęstszych wrodzonych wad serca. Dzielimy je na otwór wtórny (ASD2 ok. 70 %), otwór pierwotny (ASD I ok. 15%), typu żyły głównej (ASD sv ok. 7%), typu zatoki wieńcowej (ASD cs <1%), różnią się one lokalizacją oraz współistnieniem innych wad serca.\n" +
                "Szmer wczesnośródskurczowy (protomezosystoliczny) cichy i miękki najlepiej słyszalny w II lub III lewym międzyżebrzu przy mostku, wynikający z względnej stenozy tętnicy płucnej. Szerokie i sztywne rozdwojenie II tonu serca S2\n")

    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k08)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@ASD, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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
