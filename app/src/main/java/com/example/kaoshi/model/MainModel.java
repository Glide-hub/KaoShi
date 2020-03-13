package com.example.kaoshi.model;

import com.example.kaoshi.bean.MainBean;
import com.example.kaoshi.service.MainService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel implements Model{
    @Override
    public void onModel(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        retrofit.create(MainService.class).getBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainBean value) {
                        callBack.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
