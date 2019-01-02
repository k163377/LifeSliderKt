package com.wrongwrong.lifesliderkt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.max
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    //シークバーをボタンで動かす用
    fun minusStartBar(view: View) {
        val temp = startSeekBar.progress - 1
        startSeekBar.progress = min(104, max(0, temp))
    }
    fun plusStartBar(view: View) {
        val temp = startSeekBar.progress + 1
        startSeekBar.progress = min(104, max(0, temp))
    }
    fun minusEndBar(view: View) {
        val temp = endSeekBar.progress - 1
        endSeekBar.progress = min(105, max(1, temp))
    }
    fun plusEndBar(view: View) {
        val temp = endSeekBar.progress + 1
        endSeekBar.progress = min(105, max(1, temp))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
