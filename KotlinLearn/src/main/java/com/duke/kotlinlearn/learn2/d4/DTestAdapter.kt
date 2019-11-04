package com.duke.kotlinlearn.learn2.d4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.duke.kotlinlearn.R


/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-19 09:34
 * description:
 *
 */
class DTestAdapter(private val context: Context, private val textList: MutableList<String>, private val background: Int) : BaseAdapter() {


    override fun getItem(position: Int): Any = textList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    /**
     * 两种写法
     */
    override fun getCount(): Int = textList.size

//    override fun getCount(): Int {
//        TODO("not implemented")
//    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView
        val holder: TestViewHolder
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, null)
            holder = TestViewHolder(view)
            view.tag = holder
        } else {
            holder = view.tag as TestViewHolder
        }

        TODO("业务")

        return view!!
    }

    private inner class TestViewHolder(val view: View) {
        val textView = view.findViewById<TextView>(R.id.item_text)
        val imageView = view.findViewById<ImageView>(R.id.item_icon)

    }
}


