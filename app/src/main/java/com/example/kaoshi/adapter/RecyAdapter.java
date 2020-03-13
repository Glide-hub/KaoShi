package com.example.kaoshi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.kaoshi.R;
import com.example.kaoshi.bean.MainBean;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<MainBean.DataBeanX.DataBean> list;
    private Context context;

    public RecyAdapter(ArrayList<MainBean.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item, null);
        return new ViewHorder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHorder viewHorder = (ViewHorder) holder;
        Glide.with(context).load(list.get(position).getScene_pic_url()).into(viewHorder.Iv);
       viewHorder.Tv1.setText(list.get(position).getTitle());
       viewHorder.Tv2.setText(list.get(position).getSubtitle());
       viewHorder.Tv3.setText(list.get(position).getPrice_info()+"元起");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHorder extends RecyclerView.ViewHolder {
        ImageView Iv;
        TextView Tv1;
        TextView Tv2;
        TextView Tv3;
        public ViewHorder(View inflate) {
            super(inflate);
            Iv = inflate.findViewById(R.id.Iv);
            Tv1 = inflate.findViewById(R.id.Tv1);
            Tv2 = inflate.findViewById(R.id.Tv2);
            Tv3 = inflate.findViewById(R.id.Tv3);
        }
    }
}
