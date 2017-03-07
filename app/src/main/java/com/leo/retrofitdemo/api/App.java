package com.leo.retrofitdemo.api;

import com.leo.retrofitdemo.bean.CookListBean;
import com.leo.retrofitdemo.bean.HotEventsBean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Leo on 2017/3/7.
 */

public class App {
    public static Retrofit initRetrofit(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(ApiContancts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public static Observable<CookListBean> initCookList(int page,int rows){
        Observable<CookListBean> cookList = initRetrofit().create(ApiService.class).getCookList(page, rows);
        return cookList;
    }
    public static Observable<HotEventsBean> initHotEvents(int page, int rows){
        Observable<HotEventsBean> hotEvents = initRetrofit().create(ApiService.class).getHotEvents(page, rows);
        return hotEvents;
    }
}
