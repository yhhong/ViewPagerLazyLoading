package com.sample.viewpagerlazyloading.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * {@refrence http://android.jobbole.com/83606/}
 * Created by yinghuihong on 16/7/7.
 */
public class PageFragment extends BasePageFragment {

    private final static String TAG = PageFragment.class.getSimpleName();
    private String title;
    private TextView tv;

    public static PageFragment newInstance(String title) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString("key_fragment_title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("key_fragment_title");
        Log.d(TAG, title + ":onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, title + ":onResume");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, title + ":onCreateView");
        tv = new TextView(getActivity());
        return tv;
    }

    @Override
    public void fetchData() {
        tv.setText(title);
        /** * 在这里请求网络。 */
    }

}