package com.juancasasm.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintSet

const val TARGET_KEY = "target_key"
const val BASIC_SLIDE = "basic_slide"
const val IMAGE_FILTER_VIEW = "image_filter_view"
const val SWIPE_BUTTON = "swipe_button"
const val VIEW_BACKGROUND_SLIDE = "slide_w_background"

class ExampleActivity : AppCompatActivity(), MotionLayout.TransitionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layoutRes = when(intent.extras!!.getString(TARGET_KEY)) {
            BASIC_SLIDE -> R.layout.layout_basic_slide
            IMAGE_FILTER_VIEW -> R.layout.layout_image_filter
            SWIPE_BUTTON -> R.layout.layout_swipe
            VIEW_BACKGROUND_SLIDE -> R.layout.layout_basic_slide_background
            else -> R.layout.activity_example
        }
        setContentView(layoutRes)
        if (layoutRes == R.layout.layout_swipe) {
            findViewById<MotionLayout>(R.id.swipe_container).setTransitionListener(this)
        }
    }

    override fun onTransitionStarted(layout: MotionLayout?, startId: Int, endId: Int) = Unit

    override fun onTransitionChange(layout: MotionLayout?, startId: Int, endId: Int, progress: Float) = Unit

    override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
        if (currentId == R.id.end) {
            Toast.makeText(this, "Swipe Completed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) = Unit
}