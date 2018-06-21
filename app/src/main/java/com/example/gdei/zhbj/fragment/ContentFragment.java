package com.example.gdei.zhbj.fragment;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.gdei.zhbj.R;
import com.example.gdei.zhbj.base.BasePager;
import com.example.gdei.zhbj.base.impl.GovAffairPager;
import com.example.gdei.zhbj.base.impl.HomePager;
import com.example.gdei.zhbj.base.impl.NewsCenterPager;
import com.example.gdei.zhbj.base.impl.SettingPager;
import com.example.gdei.zhbj.base.impl.SmartServicePager;
import com.example.gdei.zhbj.view.NoScrollViewPager;

import java.util.ArrayList;

/**
 * Created by gdei on 2018/6/17.
 */

public class ContentFragment extends BaseFragment {

    private NoScrollViewPager vp_content_pager;
    private ArrayList<BasePager> basePagers;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);

        vp_content_pager = view.findViewById(R.id.vp_content_pager);

        return view;
    }

    @Override
    public void initData() {
        basePagers = new ArrayList<>();
        //填充ViewPager页面
        basePagers.add(new HomePager(mActivity));
        basePagers.add(new NewsCenterPager(mActivity));
        basePagers.add(new SmartServicePager(mActivity));
        basePagers.add(new GovAffairPager(mActivity));
        basePagers.add(new SettingPager(mActivity));

        vp_content_pager.setAdapter(new MyContentPagerAdapter());


    }
    class MyContentPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            BasePager pager = basePagers.get(position);
            View view = pager.mRootView;
            container.addView(view);

            pager.initDate();

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

}
