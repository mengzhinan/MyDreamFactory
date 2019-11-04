package com.duke.kotlinlearn.learn2.d5

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duke.kotlinlearn.R

/**
 * @Author: duke
 * @DateTime: 2019-09-22 21:50
 * @Description:
 *
 */
class NewRecyclerViewAdapter(context: Context, private val infos: MutableList<String>)
    : BaseRecyclerViewAdapter<RecyclerView.ViewHolder>(context) {
    override fun getItemCount(): Int= infos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = inflater.inflate(R.layout.list_item, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val vh = holder as ItemHolder
//        vh.iv_pic.setImageResource(infos[position].pic_id)
//        vh.tv_title.text = infos[position].title
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view){
        var ll_item = view.findViewById<TextView>(R.id.button1)
    }
}