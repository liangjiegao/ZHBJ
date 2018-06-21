package com.example.gdei.zhbj.base.impl;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;

import com.example.gdei.zhbj.base.BasePager;

import static android.graphics.Color.RED;

/**
 * Created by gdei on 2018/6/17.
 */

public class NewsCenterPager extends BasePager {

    public NewsCenterPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initDate() {

        TextView textView = new TextView(mActivity);
        textView.setText("新闻中心");
        textView.setTextColor(RED);
        textView.setGravity(Gravity.CENTER);
        fl_base_content.addView(textView);
        //设置布局标题
        tv_title_text.setText("新闻中心");
    }
}
