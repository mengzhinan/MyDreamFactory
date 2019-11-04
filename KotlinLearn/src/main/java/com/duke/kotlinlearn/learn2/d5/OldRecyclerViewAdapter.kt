package com.duke.kotlinlearn.learn2.d5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duke.kotlinlearn.R


/**
 * @Author: duke
 * @DateTime: 2019-09-22 21:50
 * @Description:
 *
 */
class OldRecyclerViewAdapter(private val context: Context, private val infos:MutableList<String>)
    : RecyclerView.Adapter<OldRecyclerViewAdapter.MyViewHolder>() {

    val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder{
        val view: View = inflater.inflate(R.layout.list_item,p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int =infos.size

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val vh:MyViewHolder = p0 as MyViewHolder

    }


    // viewholder 中的属性在构造时初始化
    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var title = view.findViewById<TextView>(R.id.button1)
    }

    private var itemClickListener: AdapterView.OnItemClickListener?=null


}