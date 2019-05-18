package com.maxproit.explicit_intent_kotlin

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // example of explicit intent
        button.setOnClickListener {
            intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("id", 101)
            intent.putExtra("name", "Firoz Mahmud")
            startActivity(intent)
        }

        // example of implicit intent
        button2.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }
    }
}
