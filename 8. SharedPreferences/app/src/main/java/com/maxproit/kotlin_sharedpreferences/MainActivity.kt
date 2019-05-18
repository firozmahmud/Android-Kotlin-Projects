package com.maxproit.kotlin_sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.Files.delete

class MainActivity : AppCompatActivity() {

    private var key: String? = null
    private var value: String? = null
    private var pref: SharedPreferences? = null
    private val PREF_NAME = "kotlin_pref"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initObjects()
        initListener()
    }

    private fun initObjects() {
        pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    private fun initListener() {
        saveBtn.setOnClickListener {
            key = id.text.toString()
            value = name.text.toString()
            if (key!!.isEmpty()) {
                id.error = "Id is required"
                id.requestFocus()
                return@setOnClickListener
            }
            if (value!!.isEmpty()) {
                name.error = "Name is required"
                name.requestFocus()
                return@setOnClickListener
            }

            save(key!!, value!!)
        }

        viewBtn.setOnClickListener {
            key = id.text.toString()
            if (key!!.isEmpty()) {
                id.error = "Id is required"
                id.requestFocus()
                return@setOnClickListener
            }

            view(key!!)
        }

        deleteBtn.setOnClickListener {
            key = id.text.toString()
            if (key!!.isEmpty()) {
                id.error = "Id is required"
                id.requestFocus()
                return@setOnClickListener
            }

            deleteData(key!!)
        }

        clearBtn.setOnClickListener {
            clearData()
        }
    }

    // function for view data
    private fun view(key: String) {
        var nameTxt = pref!!.getString(key, "")
        name.setText(nameTxt)
    }

    // function for save data
    private fun save(key: String, value: String) {
        val editor = pref!!.edit()
        editor.putString(key, value).apply()
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
    }

    // function for delete data
    private fun deleteData(key: String) {
        pref!!.edit().remove(key).apply()
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
    }

    // function for delete all preferences data
    private fun clearData() {
        pref!!.edit().clear().apply()
        Toast.makeText(this, "All data cleared", Toast.LENGTH_SHORT).show()
    }
}
