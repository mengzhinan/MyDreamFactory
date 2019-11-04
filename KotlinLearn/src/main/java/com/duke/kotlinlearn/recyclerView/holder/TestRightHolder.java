package com.duke.kotlinlearn.recyclerView.holder;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.duke.kotlinlearn.R;
import com.duke.kotlinlearn.recyclerView.adapter.BaseNewAdapter;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-07-09 10:51
 * description:
 */
public class TestRightHolder extends BaseNewAdapter.ViewHolder<String> {

    private TextView rightText;

    public TestRightHolder(@NonNull View itemView) {
        super(itemView);
        rightText = itemView.findViewById(R.id.right_text);
    }

    @Override
    public void onBindData(String data) {
        rightText.setText(data);
    }

}
