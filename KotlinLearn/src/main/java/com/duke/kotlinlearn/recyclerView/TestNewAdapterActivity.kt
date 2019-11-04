package com.duke.kotlinlearn.recyclerView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.duke.kotlinlearn.R
import com.duke.kotlinlearn.recyclerView.adapter.BaseNewAdapter
import kotlinx.android.synthetic.main.activity_test_new_adapter.*

class TestNewAdapterActivity : AppCompatActivity() {


    private lateinit var testAdapter: TestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_new_adapter)

        testAdapter = TestAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = testAdapter
        recyclerView.itemAnimator = DefaultItemAnimator()
        testAdapter.addRecyclerItemList(mock())

    }

    fun mock(): List<BaseNewAdapter.RecyclerItem<String>> {
        val list = mutableListOf<BaseNewAdapter.RecyclerItem<String>>()
        list.add(TestAdapter.createLeftItem("0"))
        list.add(TestAdapter.createRightItem("1"))
        list.add(TestAdapter.createLeftItem("2"))
        list.add(TestAdapter.createRightItem("3"))
        list.add(TestAdapter.createLeftItem("4"))
        list.add(TestAdapter.createRightItem("5"))
        list.add(TestAdapter.createLeftItem("6"))
        list.add(TestAdapter.createRightItem("7"))
        return list
    }
}
