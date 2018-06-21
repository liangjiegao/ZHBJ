package com.example.gdei.zhbj.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gdei.zhbj.R;

/**
 * Created by gdei on 2018/6/17.
 */

public class BasePager {

    public Activity mActivity;
    public TextView tv_title_text;
    private ImageView iv_to_left_menu;
    public FrameLayout fl_base_content; //页面FrameLayout， 动态设置他的内容

    public View mRootView;

    public BasePager(Activity activity){
        mActivity = activity;
        mRootView = initView();
    }

    public View initView(){
        View view = View.inflate(mActivity, R.layout.base_pager, null);

        tv_title_text = view.findViewById(R.id.tv_title_text);
        iv_to_left_menu = view.findViewById(R.id.iv_to_left_menu);
        fl_base_content = view.findViewById(R.id.fl_base_content);

        return view;
    }
    public void initDate(){

    }
}
