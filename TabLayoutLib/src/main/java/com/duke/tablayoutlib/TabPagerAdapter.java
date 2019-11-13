package com.duke.tablayoutlib;

import android.util.SparseArray;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-04-15 18:34
 * description:
 */
public class TabPagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<String> titleList;
    private final SparseArray<Fragment> fragmentArray;

    public TabPagerAdapter(final FragmentActivity activity, ArrayList<String> titleList) {
        super(activity.getSupportFragmentManager());
        this.fragmentArray = new SparseArray<>();
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(final int position) {
        Fragment fragment = fragmentArray.get(position);
        if (fragment == null) {
            fragment = BlankFragment.newInstance(titleList.get(position));
            fragmentArray.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getItemPosition(final Object object) {
        // 强制触发 notifyDataSetChanged 时刷新 fragment
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return titleList.get(position);
    }

    @Override
    public int getCount() {
        return titleList.size();
    }
}
