package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import com.piotrek.piotr.oss.R
import com.piotrek.piotr.oss.setUpActionBar
import kotlinx.android.synthetic.main.activity_jo.*

class IVTS : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ivts)
        setUpActionBar()


        textView.setText(Html.fromHtml(" <b>  Etiologia  </b> <br>Patologiczny ton późnorozkurczowy. Powstaje w późnej fazie rozkurczu w czasie skurczu przedsionków, na skutek upośledzonej podatności komory. Składowa cwału przedskurczowego (cwału przedsionkowego)."))


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.k03)
    }

    fun playMusic(view: View) {




        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
        } else {
            mediaPlayer!!.start()
            Toast.makeText(this@IVTS, "Załóż słuchawki", Toast.LENGTH_SHORT).show()
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
    fun toIVTS1 (view: View) {
        val intent = Intent(applicationContext, IVTS1::class.java)
        startActivity(intent)
    }

}
