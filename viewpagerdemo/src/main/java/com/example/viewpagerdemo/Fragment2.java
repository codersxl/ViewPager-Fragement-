package com.example.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.viewpagerdemo.Fragment.BaseFragemnt;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment2 extends BaseFragemnt {

    @BindView(R.id.banner)
    XBanner banner;
    Unbinder unbinder;
    private View view;
    private ArrayList<String> images;
    private ArrayList<String> titles;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }

        } else {
            view = inflater.inflate(R.layout.fragment2_layout, null);
            ButterKnife.bind(this, view);
        }


        Log.e("00", "----------1--------");
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void LayzLoading() {
        Log.e("00", "----------2---加载数据了-----");
        initDatas();
    }

    private void initDatas() {

        // 初始化XBanner中展示的数据
        images = new ArrayList<>();
        titles = new ArrayList<>();
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
                Glide.with(getActivity()).load(images.get(position)).into((ImageView) view);
            }
        });

        // 设置XBanner的页面切换特效
        banner.setPageTransformer(Transformer.Default);
        // 设置XBanner页面切换的时间，即动画时长
        banner.setPageChangeDuration(1000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
