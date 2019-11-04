package com.duke.kotlinlearn.learn2.d5

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.duke.kotlinlearn.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_kotlin1.*


/**
 * @Author: duke
 * @DateTime: 2019-09-22 21:50
 * @Description:
 * LayoutContainer 自动获取控件
 */
class NewRecyclerViewAdapter2(context: Context, private val infos: MutableList<String>)
    : BaseRecyclerViewAdapter<RecyclerView.ViewHolder>(context) {
    override fun getItemCount(): Int = infos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = inflater.inflate(R.layout.list_item, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val vh = holder as NewRecyclerViewAdapter.ItemHolder
//        vh.iv_pic.setImageResource(infos[position].pic_id)
//        vh.tv_title.text = infos[position].title
    }

    // 去掉 inner，否则报错
    // “java.lang.NoSuchMethodError: No virtual method _$_findCachedViewById
    // 需要在当前类头部导入：
    // import kotlinx.android.extensions.LayoutContainer
    // import kotlinx.android.synthetic.main.item_recycler_staggered.*
    /**
     * //LayoutContainer 需要设置 experimental = true
    androidExtensions {
    experimental = true
    }
     */
    inner class ItemHolder(override val containerView: View) : RecyclerView.
    ViewHolder(containerView), LayoutContainer {
        fun bind(item: String) {
            button1.setText("d")
        }
    }
}