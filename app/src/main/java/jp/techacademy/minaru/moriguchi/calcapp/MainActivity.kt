package jp.techacademy.minaru.moriguchi.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import jp.techacademy.minaru.moriguchi.calcapp.R.id.editText1
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), View.OnClickListener {

    var answer:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        multiple.setOnClickListener(this)
        divide.setOnClickListener(this)
    }

    override fun onClick(v:View){

        try {
            val item1 :Double = editText1.text.toString().toDouble()
            val item2 :Double = editText2.text.toString().toDouble()

            when (v.id) {
                R.id.plus -> answer = item1 + item2
                R.id.minus -> answer = item1 - item2
                R.id.multiple -> answer = item1 * item2
                R.id.divide -> answer = item1 / item2
            }
            val intent = Intent(this, CalcAnswer::class.java)
            intent.putExtra("ANSWER", answer)
            startActivity(intent)
        } catch (e:NumberFormatException){
                Snackbar.make(v, "数値が入力されていません。", Snackbar.LENGTH_INDEFINITE)
                        .show()
        }

    }
}
