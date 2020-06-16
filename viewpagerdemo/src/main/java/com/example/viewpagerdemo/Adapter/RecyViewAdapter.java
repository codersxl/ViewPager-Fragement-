package com.example.viewpagerdemo.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viewpagerdemo.R;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;

public class RecyViewAdapter extends RecyclerView.Adapter<RecyViewAdapter.MyAdapter>  implements ItemTouchHelperAdapter {


    private final List<String> data;
    private final FragmentActivity con;

    public RecyViewAdapter(List<String> datas, FragmentActivity activity) {
        this.data=datas;
        this.con=activity;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      // = View.inflate(con, ,null);
        View v  = LayoutInflater.from(con).inflate(R.layout.rv_item1,viewGroup,false);

        return new MyAdapter(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter myAdapter, int i) {
            myAdapter.tv.setText(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size()>0?data.size():0;
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        //交换位置
        Collections.swap(data,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDissmiss(int position) {
       //移除数据
        data.remove(position);
        notifyItemRemoved(position);
    }

    class MyAdapter extends RecyclerView.ViewHolder{
        TextView tv;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
          tv= itemView.findViewById(R.id.tv);

        }
    }
}
