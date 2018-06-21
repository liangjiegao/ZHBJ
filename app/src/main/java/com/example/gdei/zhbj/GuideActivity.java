package com.example.gdei.zhbj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by gdei on 2018/6/16.
 */

public class GuideActivity extends Activity {
    private static final String TAG = "GuideActivity";

    private ViewPager vp_guide;
    private LinearLayout ll_doc;
    private RelativeLayout rl_root_doc;
    private ImageView iv_change_doc;
    private RelativeLayout.LayoutParams rl_lp;

    int[] imageIds = new int[]{R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};
    private ImageView image;
    private ArrayList<ImageView> imgList;
    private LinearLayout.LayoutParams layoutParams;

    private int dis;
    private Button inter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
        initData();
        vp_guide.setAdapter(new MyViewPagerAdapter());
        //保存移动的红点的布局参数
        rl_lp = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vp_guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //两个点之间的距离
                dis = ll_doc.getChildAt(1).getLeft() - ll_doc.getChildAt(0).getLeft();
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) iv_change_doc.getLayoutParams();

                lp.leftMargin = (int) ((dis *positionOffset)+ dis *position) ;  //修改左边距， 在原来的基础上 加 移动百分比
                iv_change_doc.setLayoutParams(lp);
            }
            @Override
            public void onPageSelected(int position) {
                if (position < imgList.size() - 1){
                    inter.setVisibility(View.INVISIBLE);
                }else {
                    inter.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });
    }
    /**
     * 初始化视图
     */
    private void initView(){
        vp_guide = findViewById(R.id.vp_guide);
        ll_doc = findViewById(R.id.ll_doc);
        rl_root_doc = findViewById(R.id.rl_root_doc);
        iv_change_doc = findViewById(R.id.iv_change_doc);

        inter = findViewById(R.id.btn_inter);
    }
    /**
     * 初始化数据
     */
    private void initData(){
        imgList = new ArrayList<>();
        layoutParams = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMarginStart(10);
        for (int i = 0; i < imageIds.length; i++) {
            //添加引导页的背景图
            image = new ImageView(this);
            image.setBackgroundResource(imageIds[i]);
            imgList.add(image);

            //添加提示小圆点
            image = new ImageView(this);
            if (i > 0){
                image.setLayoutParams(layoutParams);
            }
            image.setImageResource(R.drawable.guide_doce_gray);
            ll_doc.addView(image);

        }
        //添加以个会移动的小红点
        iv_change_doc.setImageResource(R.drawable.guide_doce_red);
    }
    class MyViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imgList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        /**
         * 初始化一个Item
         * @param container
         * @param position
         * @return
         */
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            container.addView(imgList.get(position));

            return imgList.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
