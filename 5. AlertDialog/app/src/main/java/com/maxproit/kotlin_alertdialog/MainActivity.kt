package com.maxproit.kotlin_alertdialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Window
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.util.DisplayMetrics
import android.view.ViewGroup


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            showAlert()
        }

        button2.setOnClickListener {
            customAlert()
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.delete_file_txt))
        builder.setMessage(getString(R.string.delete_message_txt))
        builder.setIcon(R.drawable.ic_warning)
        builder.setCancelable(false)

        builder.setPositiveButton("YES") { dialog, which ->
            Toast.makeText(this, getString(R.string.deleted_txt), Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("Cancel", null)
        builder.setNegativeButton("No") { dialog, which ->
            Toast.makeText(this, getString(R.string.not_deleted_txt), Toast.LENGTH_SHORT).show()
        }

        builder.create().show()
    }


    private fun customAlert() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.setCancelable(false)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val yesBtn = dialog.findViewById<Button>(R.id.btn_yes)
        val noBtn = dialog.findViewById<Button>(R.id.btn_no)

        yesBtn.setOnClickListener {
            dialog.dismiss()
            finish()
        }
        noBtn.setOnClickListener {
            dialog.dismiss()
        }

        val metrics = resources.displayMetrics
        val width = metrics.widthPixels
        val height = metrics.heightPixels

        dialog.getWindow().setLayout((6 * width)/7, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.show()
    }
}
