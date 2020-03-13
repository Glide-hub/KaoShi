package com.example.kaoshi.service;

import com.example.kaoshi.bean.MainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MainService {
    String URL = "https://cdwan.cn/";
    @GET("api/topic/list")
    Observable<MainBean> getBean();
}
