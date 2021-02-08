package com.juancasasm.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonSlide).setOnClickListener(this)
        findViewById<Button>(R.id.buttonImage).setOnClickListener(this)
        findViewById<Button>(R.id.buttonSlideBackground).setOnClickListener(this)
        findViewById<Button>(R.id.buttonSwipe).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val targetKey = when(v?.id) {
            R.id.buttonSlide -> BASIC_SLIDE
            R.id.buttonImage -> IMAGE_FILTER_VIEW
            R.id.buttonSlideBackground -> VIEW_BACKGROUND_SLIDE
            else -> SWIPE_BUTTON
        }
        Intent(this, ExampleActivity::class.java).also {
            it.putExtra(TARGET_KEY, targetKey)
            startActivity(it)
        }
    }
}