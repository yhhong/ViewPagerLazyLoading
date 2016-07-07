package com.sample.viewpagerlazyloading;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sample.viewpagerlazyloading.base.PageFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        MainTabAdapter adapter = new MainTabAdapter(getSupportFragmentManager());
        adapter.addFragment(PageFragment.newInstance("1"), "1");
        adapter.addFragment(PageFragment.newInstance("2"), "2");
        adapter.addFragment(PageFragment.newInstance("3"), "3");
        adapter.addFragment(PageFragment.newInstance("4"), "4");
        adapter.addFragment(PageFragment.newInstance("5"), "5");
        mViewPager.setAdapter(adapter);
    }
}
