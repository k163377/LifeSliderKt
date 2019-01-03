package com.wrongwrong.lifesliderkt

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wrongwrong.lifesliderkt.calc.calcMaleSurvivalRate
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.max
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    //rateのセット関数
    @SuppressLint("SetTextI18n")
    private fun setRate(){
        val rate = calcMaleSurvivalRate(startSeekBar.progress, endSeekBar.progress) * 100.0
        rateText.text = "${"%.2f".format(rate)}%"
    }

    //シークバーのセット関数、moveで動作量制御
    private fun setStartBar(move: Int = 0){
        //スタートをセット
        val temp = startSeekBar.progress + move
        startSeekBar.progress = min(104, max(0, temp))
        //エンドを調整
        if(endSeekBar.progress <= startSeekBar.progress){
            endSeekBar.progress = startSeekBar.progress + 1
        }
        //テキスト系に反映
        setRate()
    }
    private fun setEndBar(move: Int = 0){
        //スタートをセット
        val temp = endSeekBar.progress + move
        endSeekBar.progress = min(105, max(1, temp))
        //エンドをセット
        if(endSeekBar.progress <= startSeekBar.progress){
            startSeekBar.progress = endSeekBar.progress - 1
        }
        //テキスト系に反映
        setRate()
    }
    //シークバーをボタンで動かす用、タグを使って書き直せばもっとシンプルにできる
    fun onClickMinusStartBar(view: View) { setStartBar(-1) }
    fun onClickPlusStartBar(view: View) { setStartBar(1) }
    fun onClickMinusEndBar(view: View) { setEndBar(-1) }
    fun onClickPlusEndBar(view: View) { setEndBar(1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初期値を設定
        setRate()
    }
}
