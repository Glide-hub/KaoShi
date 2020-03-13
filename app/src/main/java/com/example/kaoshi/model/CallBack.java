package com.example.kaoshi.model;

import com.example.kaoshi.bean.MainBean;

public interface CallBack {
    void onSuccess(MainBean mainBean);
    void onFile(String str);
}
