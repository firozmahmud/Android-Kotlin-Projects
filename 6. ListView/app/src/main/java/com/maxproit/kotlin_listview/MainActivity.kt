package com.maxproit.kotlin_listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListView()
    }

    private fun initListView() {
        val languages = resources.getStringArray(R.array.languages)
        val adapter = ArrayAdapter(this, R.layout.sample_layout, R.id.titleTextView, languages)

        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapter, view, pos, id ->
            val selectedItem = adapter.getItemAtPosition(pos)
            Toast.makeText(this, "Language: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}
