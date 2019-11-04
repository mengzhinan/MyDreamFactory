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
public class TestLeftHolder extends BaseNewAdapter.ViewHolder<String> {

    private TextView leftText;

    public TestLeftHolder(@NonNull View itemView) {
        super(itemView);
        leftText = itemView.findViewById(R.id.left_text);
    }

    @Override
    public void onBindData(String data) {
        leftText.setText(data);
    }

}
