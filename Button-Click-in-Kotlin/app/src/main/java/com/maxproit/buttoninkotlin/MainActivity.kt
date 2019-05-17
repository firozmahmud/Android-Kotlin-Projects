package com.maxproit.buttoninkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val button4_id: Int = 111

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {

        // option 1 , button click listener
        button1.setOnClickListener {
            Toast.makeText(this, "Button one is clicked", Toast.LENGTH_LONG).show()
        }

        // option 2 , button click listener
        button2.setOnClickListener(this)

        // add button 4 dynamically
        val button4 = Button(this)
        button4.text = "Button 4 added dynamically"
        button4.layoutParams =
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        button4.id = button4_id
        button4.x = 120f
        button4.y = 750f
        button4.setOnClickListener(this)
        constraintLayout.addView(button4)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button2 ->
                Toast.makeText(this, "Button two is clicked", Toast.LENGTH_LONG).show()
            button4_id -> {
                Toast.makeText(this, "Button four is clicked", Toast.LENGTH_LONG).show()
            }
        }
    }

    // option 3 , button click listener
    fun button3Click(v: View?) {
        Toast.makeText(this, "Button three is clicked", Toast.LENGTH_LONG).show()
    }
}
