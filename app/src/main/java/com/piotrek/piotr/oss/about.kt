package com.piotrek.piotr.oss

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import kotlinx.android.synthetic.main.activity_jo.*

class about : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setUpActionBar()
        textView.setText(Html.fromHtml(" <b>  O aplikacji  </b> <br> Aplikację OsłuchajSięSam tworzyłem z myślą o ułatwieniu procesu nauki i utrwalania umiejętności osłuchiwania. Poprawność odtwarzania dźwięku wymaga użycia słuchawek. Aplikację podzieliłem na dwie części. <br>" +
                "W strefie nauki możemy doskonalić zdolności osłuchiwania serca i płuc oraz dowiedzieć się skąd się taki dźwięk bierze. <br>" +
                "W strefie testu możemy sprawdzić stan naszej wiedzy. Mamy tam do dyspozycji testy z podziałem na zakres kardiologiczny i pulmonologiczny. Żółtym suwakiem możemy wybrać liczbę pytań z podziałem na 5, 15 lub 25. Sprawdzają one umiejętność rozpoznawania oraz wiedzy z zakresu etiologii i charakterystyki danego dźwięku. Są to pytania jednokrotnego wyboru, a czas na udzielenie odpowiedzi wynosi 40 sekund. System przydziela 10 pkt za każdą poprawną odpowiedź, dodatkowo wraz z każdym kolejnym włączeniem testu dodaje 1 pkt.<br>" +
                "Chciałbym jeszcze podziękować tutaj  wszystkim osobom za wskazówki odnośnie zawartości oraz działania aplikacji, życzę owocnej nauki i dobrej zabawy.<br>" +
                "<i>Piotr Danielewski</i>"))

    }


}
