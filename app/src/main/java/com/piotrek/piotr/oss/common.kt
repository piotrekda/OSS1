package com.piotrek.piotr.oss

import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*

fun AppCompatActivity.setUpActionBar() {
    setSupportActionBar(customtoolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.title = ""
}