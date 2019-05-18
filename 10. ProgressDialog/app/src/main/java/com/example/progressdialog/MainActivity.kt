package com.example.progressdialog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        button.setOnClickListener {
            showProgressDialog()
        }
    }


    // function for showing progress dialog
    private fun showProgressDialog() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.custom_progress_bar, null)
        builder.setView(view)
        builder.setCancelable(false)
        val tv = view.findViewById<TextView>(R.id.dialog_text_view)
        tv.text = "Downloading. Pls wait..."
        val dialog = builder.create()

        dialog.show()

        Handler().postDelayed(Runnable {
            dialog.dismiss()
        }, 5000)
    }

    // when back button is pressed, close the progressbar
    override fun onBackPressed() {
        progressBar.visibility = View.GONE
    }
}

