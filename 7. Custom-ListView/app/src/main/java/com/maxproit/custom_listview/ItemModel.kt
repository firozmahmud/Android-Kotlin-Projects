package com.maxproit.custom_listview

import android.app.Activity
import android.content.res.TypedArray
import com.maxproit.custom_listview.ItemModel as ItemModel

class ItemModel {
    var title: String? = null
    var desc: String? = null
    var image: Int? = null

    constructor(title: String, desc: String, image: Int) {
        this.title = title
        this.desc = desc
        this.image = image
    }

    constructor()


    fun getItemList(context: Activity): MutableList<ItemModel> {
        var items: MutableList<ItemModel> = ArrayList()
        var titleList: Array<String> = context.resources.getStringArray(R.array.language_list)
        var descList: Array<String> = context.resources.getStringArray(R.array.desc_list)
        var imageList: TypedArray = context.resources.obtainTypedArray(R.array.image_list)

        for (i in 0.until(10)) {
            var item = ItemModel(titleList[i], descList[i], imageList.getResourceId(i, -1))
            items.add(item)
        }
        return items
    }


}