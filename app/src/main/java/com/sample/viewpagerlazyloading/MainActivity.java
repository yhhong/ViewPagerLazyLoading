package com.sample.viewpagerlazyloading;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        final MainTabAdapter adapter = new MainTabAdapter(getSupportFragmentManager());
        adapter.addFragment(PageFragment.newInstance("title_1"), "1");
        adapter.addFragment(PageFragment.newInstance("title_2"), "2");
        adapter.addFragment(PageFragment.newInstance("title_3"), "3");
        adapter.addFragment(PageFragment.newInstance("title_4"), "4");
        adapter.addFragment(PageFragment.newInstance("title_5"), "5");
        mViewPager.setAdapter(adapter);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyAllFragment();
            }
        });
    }
}
