package com.piotrek.piotr.oss

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.piotrek.piotr.oss.Testy.StrefaTestu

class MainActivity : AppCompatActivity() {

    lateinit var fab_main: FloatingActionButton
    lateinit var fab_sub1: FloatingActionButton
    lateinit var fab_sub2: FloatingActionButton
    lateinit var fab_sub3: FloatingActionButton
    lateinit var fab_open: Animation
    lateinit var fab_close: Animation
    lateinit var rotate_cw: Animation
    lateinit var rotate_acw: Animation
    var isOpen: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab_main = findViewById(R.id.fab) as FloatingActionButton
        fab_sub1 = findViewById(R.id.fab1) as FloatingActionButton
        fab_sub2 = findViewById(R.id.fab2) as FloatingActionButton
        fab_sub3 = findViewById(R.id.fab3) as FloatingActionButton
        fab_open = AnimationUtils.loadAnimation(applicationContext,R.anim.open_fab)
        fab_close = AnimationUtils.loadAnimation(applicationContext,R.anim.close_fab)
        rotate_cw = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_clockwise)
        rotate_acw = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_anticlockwise)
        fab_main.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                if(isOpen)
                {

                    fab_sub1.startAnimation(fab_close)
                    fab_sub2.startAnimation(fab_close)
                    fab_sub3.startAnimation(fab_close)
                    fab_main.startAnimation(rotate_acw)
                    fab_sub1.visibility = View.GONE
                    fab_sub2.visibility = View.GONE
                    fab_sub3.visibility = View.GONE
                    isOpen = false

                }else
                {
                    fab_sub1.startAnimation(fab_open)
                    fab_sub2.startAnimation(fab_open)
                    fab_sub3.startAnimation(fab_open)
                    fab_main.startAnimation(rotate_cw)
                    fab_sub1.visibility = View.VISIBLE
                    fab_sub2.visibility = View.VISIBLE
                    fab_sub3.visibility = View.VISIBLE
                    fab_sub1.isClickable = true
                    fab_sub2.isClickable = true
                    fab_sub3.isClickable = true
                    isOpen = true

                }


            }
        })

        fab_sub1.setOnClickListener({
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/OsluchajSieSam"))
            startActivity(i)
        })

        fab_sub2.setOnClickListener({
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/apps/com.piotrek.piotr.oss"))
            startActivity(i)
        })

        fab_sub3.setOnClickListener({
            val i = Intent(applicationContext, about::class.java)
            startActivity(i)
        })


    }

    fun toNauka(view: View) {
        val intent = Intent(applicationContext, strefaNauki::class.java)
        startActivity(intent)
    }

    fun toTesty(view: View) {
        val intent = Intent(applicationContext, StrefaTestu::class.java)
        startActivity(intent)
    }
}
