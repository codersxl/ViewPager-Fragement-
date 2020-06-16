package com.example.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.viewpagerdemo.Adapter.RecyViewAdapter;
import com.example.viewpagerdemo.Fragment.BaseFragemnt;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment1 extends BaseFragemnt {

    private List<String> datas = new ArrayList<>();
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private View view;
    private RecyViewAdapter recyViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }

        } else {
            view = inflater.inflate(R.layout.fragment1_layout, null);
            ButterKnife.bind(this, view);
        }

        Log.e("00", "----------1--------");
        unbinder = ButterKnife.bind(this, view);
        intView();
        return view;
    }

    private void intView() {
        recyViewAdapter = new RecyViewAdapter(datas, getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        //
        SimpeCallback simpeCallback = new SimpeCallback(recyViewAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(simpeCallback);
        helper.attachToRecyclerView(rv);
        //  new ItemTouchHelper.SimpeCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,ItemTouchHelper.RIGHT)
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.layout);
        rv.setLayoutAnimation(layoutAnimationController);
        rv.setAdapter(recyViewAdapter);
        rv.setNestedScrollingEnabled(true);


    }


    @Override
    public void LayzLoading() {
        Log.e("00", "----------1--加载数据了------");
        for (int i = 0; i < 100; i++) {
            datas.add("this is" + i);
        }
        recyViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
