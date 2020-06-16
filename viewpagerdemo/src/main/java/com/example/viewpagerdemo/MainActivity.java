package com.example.viewpagerdemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.viewpagerdemo.Adapter.ViewPagerAdapter;
import com.example.viewpagerdemo.Fragment.BaseFragemnt;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.magic_indicator)
    TabLayout magicIndicator;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.banner)
    XBanner banner;
    private ArrayList<BaseFragemnt> list;
    private int height;
    private int width;
    private ArrayList<String> images;
    private ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDatas();
        initViewPager();
        //initDispaly();
    }

    private void initDatas() {

        // 初始化XBanner中展示的数据
        images = new ArrayList<>();
        titles = new ArrayList<>();
        //images.add("http://img3.fengniao.com/forum/attachpics/913/114/36502745.jpg");
        //titles.add("这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片");
        images.add("http://imageprocess.yitos.net/images/public/20160910/99381473502384338.jpg");
        titles.add("这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片");
        images.add("http://imageprocess.yitos.net/images/public/20160910/77991473496077677.jpg");
        titles.add("这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片");
        images.add("http://imageprocess.yitos.net/images/public/20160906/1291473163104906.jpg");
        titles.add("这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片");
        // 为XBanner绑定数据
        banner.setData(images, titles);

        // XBanner适配数据
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(MainActivity.this).load(images.get(position)).into((ImageView) view);
            }
        });
        /**
         *  Default,
         *     Alpha,
         *     Rotate,
         *     Cube,
         *     Flip,
         *     Accordion,
         *     ZoomFade,
         *     ZoomCenter,
         *     ZoomStack,
         *     Stack,
         *     Depth,
         *     Zoom
         */
        // 设置XBanner的页面切换特效
        banner.setPageTransformer(Transformer.Rotate);

        // 设置XBanner页面切换的时间，即动画时长
        banner.setPageChangeDuration(1000);
        // XBanner中某一项的点击事件
        banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, int position) {
                Toast.makeText(MainActivity.this, "点击了第" + (position + 1) + "张图片", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDispaly() {
        DisplayMetrics metr = new DisplayMetrics();
        this.height = metr.heightPixels;
        this.width = metr.widthPixels;
        getWindowManager().getDefaultDisplay().getMetrics(metr);
    }

    private void initViewPager() {
        list = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        vp.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), list));
        magicIndicator.setupWithViewPager(vp);
        // vp.setOffscreenPageLimit(3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }
}
