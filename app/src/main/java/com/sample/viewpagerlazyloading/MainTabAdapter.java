package com.sample.viewpagerlazyloading;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.sample.viewpagerlazyloading.base.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinghuihong on 16/6/29.
 */
public class MainTabAdapter extends FragmentPagerAdapter {

    private final List<PageFragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public MainTabAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(PageFragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

    public void notifyAllFragment() {
        for (PageFragment fragment : mFragments) {
            fragment.fetchDataIfViewInitiated(true);
        }
    }
}
