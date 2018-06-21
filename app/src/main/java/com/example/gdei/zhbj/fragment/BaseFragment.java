package com.example.gdei.zhbj.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gdei on 2018/6/17.
 */

public abstract class BaseFragment extends Fragment {

    public Activity mActivity;
    //Fragment创建
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = getActivity();
    }
    //初始化Fragment布局
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = initView();

        return view;
    }
    //fragment所依赖的Activity的onCreate
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化数据
        initData();
    }
    //初始化View
    public abstract View initView();
    //初始化数据
    public abstract void initData();
}
