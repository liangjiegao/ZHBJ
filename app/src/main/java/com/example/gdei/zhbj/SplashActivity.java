package com.example.gdei.zhbj;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import util.PrefUtil;

public class SplashActivity extends Activity {

    private RelativeLayout rl;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        rl = findViewById(R.id.rl_root);

        //旋转动画
        RotateAnimation ra = new RotateAnimation(180,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(1000);
        ra.setFillAfter(true);

        //缩放动画
        ScaleAnimation sa = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(1000);
        sa.setFillAfter(true);

        //渐变动画
        AlphaAnimation aa = new AlphaAnimation(0,1);
        aa.setDuration(1000);
        aa.setFillAfter(true);

        //动画集合  ---> 同时启动多个动画
        AnimationSet as = new AnimationSet(true);
        as.addAnimation(ra);
        as.addAnimation(sa);
        as.addAnimation(aa);

        rl.startAnimation(as);

        as.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束， 跳转页面
                boolean isFirstInter = PrefUtil.getIsFirstStart(SplashActivity.this,"is_first", true);
                //如果是第一次进入， 条新手引导页
                if (isFirstInter){
                    PrefUtil.setIsFirstStart(SplashActivity.this,"is_first", false);
                    intent = new Intent(SplashActivity.this, GuideActivity.class);
                }else {
                    //否则跳主页
                    intent = new Intent(SplashActivity.this, GuideActivity.class);
                }
                startActivity(intent);
                finish();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }
}
