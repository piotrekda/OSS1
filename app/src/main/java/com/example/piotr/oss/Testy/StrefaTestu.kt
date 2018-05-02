package com.example.piotr.oss.Testy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.piotr.oss.R
import com.example.piotr.oss.setUpActionBar

class StrefaTestu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strefa_testu)
        setUpActionBar()
    }

    fun toTesty (view: View) {
        Test.start(this, "lungs")
    }
    fun toTesty1 (view: View) {
        Test.start(this, "heart")
    }
}
