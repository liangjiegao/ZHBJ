package com.example.gdei.zhbj;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.gdei.zhbj.fragment.ContentFragment;
import com.example.gdei.zhbj.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * Created by gdei on 2018/6/16.
 */

public class MainActivity extends SlidingFragmentActivity {

    public static final String TAG_LEFT_MENU = "TAG_LEFT_MENU";
    public static final String TAG_CONTENT = "TAG_CONTENT";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBehindContentView(R.layout.left_layout);
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffset(400);

        initFragment();
    }

    /**
     * 初始化Fragment， 将Fragment添加到相应位置
     */
    private void initFragment(){
        FragmentManager fm = getSupportFragmentManager();    //获取Fragment管理器， 这个是版本兼容的， getFragmentManager是版本不兼容的
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        //将Fragment添加进相应的位置， 参数 一：要填充的位置， 二：要填充的Fragment， 参数三：标记， 用于获取
        transaction.replace(R.id.fl_left_menu,new LeftMenuFragment(), TAG_LEFT_MENU);
        transaction.replace(R.id.fl_content, new ContentFragment(), TAG_CONTENT);
        transaction.commit();

    }
}
