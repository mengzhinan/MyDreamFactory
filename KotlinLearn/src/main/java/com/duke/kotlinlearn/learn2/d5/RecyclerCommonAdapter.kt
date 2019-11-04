package com.duke.kotlinlearn.learn2.d5

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/**
 * @Author: duke
 * @DateTime: 2019-09-22 22:58
 * @Description:
 *
 * val adapter = RecyclerCommonAdapter(this, R.layout.item_recycler_stagge
red, RecyclerInfo.defaultStag,
{view, item ->
val iv_pic = view.findViewById<ImageView>(R.id.iv_pic)
val tv_title = view.findViewById<TextView>(R.id.tv_title)
iv_pic.setImageResource(item.pic_id)
tv_title.text = item.title
})
 */
class RecyclerCommonAdapter<T>
(context: Context, private val layoutId: Int,
 private val items: List<T>,
 val init: (View, T) -> Unit)
    : BaseRecyclerViewAdapter<RecyclerCommonAdapter.ItemHolder<T>>(context) {

    override fun getItemCount(): Int = items.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val view: View = inflater.inflate(layoutId, parent, false)
        return ItemHolder<T>(view, init)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh: ItemHolder<T> = holder as ItemHolder<T>
        vh.bind(items.get(position))
    }

    // 注意 init 是一个函数形式的输入参数
    class ItemHolder<in T>(val view: View, val init: (View, T) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bind(item: T) {
            init(view, item)
        }
    }
}