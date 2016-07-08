package com.sample.viewpagerlazyloading.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by yinghuihong on 16/7/7.
 */
public abstract class BasePageFragment extends Fragment {

    protected boolean isViewInitiated;
    protected boolean isVisibleToUser;
    protected boolean isDataInitiated;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        fetchDataInForeground();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        fetchDataInForeground();
    }

    public abstract void fetchData();

    public boolean fetchDataInForeground() {
        return fetchDataInForeground(false);
    }

    public boolean fetchDataInForeground(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }

    public boolean fetchDataIfViewInitiated(boolean forceUpdate) {
        if (isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }

}