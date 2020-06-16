package com.example.viewpagerdemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

public abstract class BaseFragemnt extends Fragment {

    public boolean is=false;
    private boolean isVisible;
    private boolean isVievCreated;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          initData();
    }

    protected  void initData(){};

    /**
     * 解决ViewPager+Fragment的重复懒加载
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
           this.isVisible=isVisibleToUser;
           Log.e("==",isVisibleToUser+"");
           lay();
    }

    protected  void lay(){

            if(isVisible&&isVievCreated&&!is){
                LayzLoading();
                is=true;
                Log.e("00","--isVisible--"+isVisible+"==="+"isVievCreated=="+isVievCreated+"is==>"+is);
            }
    };


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isVievCreated=true;
        lay();
    }

    public  abstract void  LayzLoading();
}
