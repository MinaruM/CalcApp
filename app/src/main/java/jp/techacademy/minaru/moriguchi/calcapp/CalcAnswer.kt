package jp.techacademy.minaru.moriguchi.calcapp


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calc_answer.*

class CalcAnswer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_answer)

        val result = intent.getDoubleExtra("ANSWER", 0.0)

        textView.text = "${result}"
    }
}