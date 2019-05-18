package com.maxproit.custom_listview

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class CustomListAdapter(val context: Activity, val items: MutableList<ItemModel>) :
    ArrayAdapter<String>(context, R.layout.sample_layout) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = context.layoutInflater.inflate(R.layout.sample_layout, null)

        itemView.setOnClickListener{
           Toast.makeText(context, items.get(position).title , Toast.LENGTH_SHORT).show()
        }

        val title = itemView.findViewById<TextView>(R.id.titleTextView)
        val desc = itemView.findViewById<TextView>(R.id.descTextView)
        val image = itemView.findViewById<ImageView>(R.id.itemImageView)

        title.text = items.get(position).title
        desc.text = items.get(position).desc
        image.setImageResource(items.get(position).image!!)
        return itemView
    }

    override fun getCount(): Int {
        return items.size
    }
}