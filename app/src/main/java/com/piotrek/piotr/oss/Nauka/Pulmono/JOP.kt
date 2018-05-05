package com.piotrek.piotr.oss.Nauka.Pulmono

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.piotrek.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class JOP : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jop)
        textView.setText("Pacjent powinien być zrelaksowany oraz znajdować się wyprostowany w pozycji siedzącej. Zachęcaj pacjenta do nieco głębszego niż normalnie oddechu przez usta. Osłuchuj przez co najmniej jeden cykl oddechowy w każdym miejscu. Zacznij od góry i osłuchuj porównawczo aż do podstawy płuc. Staraj się ocenić głośność, wysokość, czas trwania fazy wdechu do wydechu oraz cechy charakterystyczne.")


    }

    fun toPulmono (view: View) {
        val intent = Intent(applicationContext, Pulmono::class.java)
        startActivity(intent)
    }
    fun toJOP1 (view: View) {
        val intent = Intent(applicationContext, JOP1::class.java)
        startActivity(intent)
    }
}
