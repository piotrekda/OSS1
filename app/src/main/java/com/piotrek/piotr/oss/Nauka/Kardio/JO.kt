package com.piotrek.piotr.oss.Nauka.Kardio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.piotrek.piotr.oss.R
import kotlinx.android.synthetic.main.activity_jo.*

class JO : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jo)

        textView.setText("Osłuchuj serce u spokojnie oddychającego pacjenta leżącego na plecach, w razie potrzeby polecając mu zatrzymanie oddechu w fazie wdechu lub wydechu. Szmery z prawego serca z reguły są głośniejsze w fazie wdechu.\n" +
                "Na poniższej rycinie znajdują się 4 główne pola osłuchiwania serca wraz z ich centralnymi punktami:\n" +
                "– pole osłuchiwania zastawki mitralnej [M] (V lewe międzyżebrze przyśrodkowo od linii środkowo-obojczykowej)\n" +
                "– pole osłuchiwania zastawki trójdzielnej [T] (IV–V prawe międzyżebrze przy mostku)\n" +
                "– pole osłuchiwania zastawki pnia płucnego [PP]  (II lewe międzyżebrze przy mostku)\n" +
                "– pole osłuchiwania zastawki aorty [Ao] (II prawe międzyżebrze przy mostku)\n" +
                "– oraz punkt Erba (przyczep 3 lewego żebra do mostka ) - miejsce na klatce piersiowej, w którym I i II ton ma jednakowe natężenie.\n")


    }

    fun toKardio (view: View) {
        val intent = Intent(applicationContext, Kardio::class.java)
        startActivity(intent)
    }
    fun toJO1 (view: View) {
        val intent = Intent(applicationContext, JO1::class.java)
        startActivity(intent)
    }
}
