package jp.techacademy.minaru.moriguchi.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
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
        val item1 :Double = editText1.text.toString().toDouble()
        val item2 :Double = editText2.text.toString().toDouble()

        try {
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
                Snackbar.make(v, "Replace with your own action1", Snackbar.LENGTH_INDEFINITE)
                        .show()
        } finally {
            Snackbar.make(v, "Replace with your own action2", Snackbar.LENGTH_INDEFINITE)
                    .show()
        }

    }
}
