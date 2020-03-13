package com.example.kaoshi.presenter;

import com.example.kaoshi.bean.MainBean;
import com.example.kaoshi.fragment.SubjectFragment;
import com.example.kaoshi.model.CallBack;
import com.example.kaoshi.model.MainModel;
import com.example.kaoshi.view.MainView;

public class MainPresenter implements Presenter, CallBack {
    private final MainModel model;
    private MainView mainView;

    public MainPresenter(MainView mv) {
        mainView = mv;
        model = new MainModel();
    }

    @Override
    public void onSuccess(MainBean mainBean) {
        mainView.onSuccess(mainBean);
    }

    @Override
    public void onFile(String str) {
        mainView.onFile(str);
    }

    @Override
    public void onP() {
        model.onModel(this);
    }
}
