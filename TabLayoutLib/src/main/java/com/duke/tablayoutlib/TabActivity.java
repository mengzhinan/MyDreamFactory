package com.duke.tablayoutlib;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabLayout = findViewById(R.id.tab_layout_view);
        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new TabPagerAdapter(this, initTitles(4));
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
        tabLayout.setupWithViewPager(viewPager);

        // 设置底部导航线是否占满 item 宽度
        tabLayout.setTabIndicatorFullWidth(false);

        // 设置 item 的在父布局中的布局模式
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // 设置多个 item 时，是否允许滑动
        tabLayout.setTabMode(tabLayout.getTabCount() > 5 ? TabLayout.MODE_SCROLLABLE : TabLayout.MODE_FIXED);

        // 设置背景
        tabLayout.setBackgroundColor(Color.parseColor("#cccccc"));

        // 设置是否不限制 item 的点击背景效果
        tabLayout.setUnboundedRipple(true);

        // 设置点击 item 时的背景颜色
        tabLayout.setTabRippleColor(ColorStateList.valueOf(Color.RED));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.getTabAt(2).select();
            }
        });

    }

    private ArrayList<String> initTitles(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("count mast > 0");
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {

            if (i == (count - 1)) {
                list.add("测试数据 " + (i + 1));
            } else {
                list.add("测试 " + (i + 1));
            }
        }
        return list;
    }
}
