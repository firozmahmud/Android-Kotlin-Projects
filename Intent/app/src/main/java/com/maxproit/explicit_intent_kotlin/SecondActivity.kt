package com.maxproit.explicit_intent_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle = intent.extras
        val id = bundle.get("id")
        val name = bundle.get("name")

        textView.text = "Id: $id , name: $name"
    }
}
