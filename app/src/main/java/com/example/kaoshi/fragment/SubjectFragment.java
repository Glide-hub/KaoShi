package com.example.kaoshi.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kaoshi.R;
import com.example.kaoshi.adapter.RecyAdapter;
import com.example.kaoshi.bean.MainBean;
import com.example.kaoshi.presenter.MainPresenter;
import com.example.kaoshi.view.MainView;

import java.util.ArrayList;
public class SubjectFragment extends Fragment implements MainView {


    private MainPresenter presenter;
    private ArrayList<MainBean.DataBeanX.DataBean> list;
    private RecyclerView Recy;
    private RecyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_subject, container, false);
        initData(inflate);
        initView();
        return inflate;
    }

    private void initData(View inflate) {
        Recy = inflate.findViewById(R.id.Recy);
        list = new ArrayList<>();
        Recy.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyAdapter(list, getContext());
        Recy.setAdapter(adapter);
    }

    private void initView() {
        presenter = new MainPresenter(this);
        presenter.onP();
    }

    @Override
    public void onSuccess(MainBean mainBean) {
        ArrayList<MainBean.DataBeanX.DataBean> data = (ArrayList<MainBean.DataBeanX.DataBean>) mainBean.getData().getData();
        list.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFile(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }
}
