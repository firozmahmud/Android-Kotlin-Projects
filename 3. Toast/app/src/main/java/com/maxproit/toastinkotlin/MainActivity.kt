package com.maxproit.toastinkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        button1.setOnClickListener {
            showToast("Hello, This is toast")
        }
        button2.setOnClickListener {
            showCustomToast("Hello, This is custom toast")
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    private fun showCustomToast(msg: String) {
        val custom_layout = layoutInflater.inflate(R.layout.custom_toast, null)
        val customToast = Toast(applicationContext)
        customToast.setGravity(Gravity.CENTER, 10, 400)
        customToast.view = custom_layout
        customToast.duration = Toast.LENGTH_LONG
        custom_layout.findViewById<TextView>(R.id.titleTextView).text = msg
        customToast.show()
    }
}
