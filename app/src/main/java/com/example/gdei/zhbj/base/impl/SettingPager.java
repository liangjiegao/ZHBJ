package com.example.gdei.zhbj.base.impl;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;

import com.example.gdei.zhbj.base.BasePager;

import static android.graphics.Color.RED;

/**
 * Created by gdei on 2018/6/17.
 */

public class SettingPager extends BasePager {

    public SettingPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initDate() {

        TextView textView = new TextView(mActivity);
        textView.setText("设置");
        textView.setTextColor(RED);
        textView.setGravity(Gravity.CENTER);
        fl_base_content.addView(textView);
        //设置布局标题
        tv_title_text.setText("设置");
    }
}
