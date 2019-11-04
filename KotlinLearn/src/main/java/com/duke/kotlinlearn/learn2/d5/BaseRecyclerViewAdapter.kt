package com.duke.kotlinlearn.learn2.d5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

/**
 * @Author: duke
 * @DateTime: 2019-09-22 22:27
 * @Description:
 *
 */
abstract class BaseRecyclerViewAdapter<VH : RecyclerView.ViewHolder>
(open val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>
(), AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    val inflater: LayoutInflater = LayoutInflater.from(context)

    override abstract fun getItemCount(): Int

    override abstract fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder


    override abstract fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)

    override fun getItemViewType(position: Int): Int = 0
    override fun getItemId(position: Int): Long = position.toLong()
    var itemClickListener: AdapterView.OnItemClickListener? = null
    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener) {
        this.itemClickListener = listener
    }

    var itemLongClickListener: AdapterView.OnItemLongClickListener? = null
    fun setOnItemLongClickListener(listener: AdapterView.OnItemLongClickListener) {
        this.itemLongClickListener = listener
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {}
    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
        return false
    }

}