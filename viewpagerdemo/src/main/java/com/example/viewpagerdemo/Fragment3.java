package com.example.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpagerdemo.Fragment.BaseFragemnt;

public class Fragment3 extends BaseFragemnt {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if (view != null) {
            //解决actitvy异常销毁时fragment布局重建
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }

        } else {
            view = inflater.inflate(R.layout.fragment3_layout, null);
        }

        Log.e("00", "----------1--------");
        return view;
    }


    @Override
    public void LayzLoading() {
        Log.e("00", "----------3---加载数据了-----");
    }


}