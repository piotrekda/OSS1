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

class ASD : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer
    lateinit var playsound : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asd)
        setUpActionBar()
        playsound = findViewById(R.id.playsound) as ImageView

        textView.setText(Html.fromHtml(" <b>  Etiologia  </b> <br> Ubytek w przegrodzie międzyprzedsionkowej (ang. atrial septal defect, ASD) – jedna z najczęstszych wrodzonych wad serca, którą dzielimy na otwór wtórny (ASD2 ok. 70 %), otwór pierwotny (ASD I ok. 15%), typu żyły głównej (ASD sv ok. 7%), typu zatoki wieńcowej (ASD cs 1%), różnią się one lokalizacją oraz współistnieniem innych wad serca." +
                "<br> <b>  Charakterystyka  </b> <br> Szmer wczesnośródskurczowy (protomezosystoliczny) cichy i miękki najlepiej słyszalny w II lub III lewym międzyżebrzu przy mostku, wynikający z względnej stenozy tętnicy płucnej. Szerokie i sztywne rozdwojenie II tonu serca S2."))

    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k08)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
            playsound.setImageResource(R.drawable.e11)

        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@ASD, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
            playsound.setImageResource(R.drawable.e111)
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
